package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.domain.loan.LoanRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;
    private final LoanRepository loanRepository;

    public BookService(BookRepository bookRepository, LoanRepository loanRepository, UserLoanHistoryRepository userLoanHistoryRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
        this.loanRepository = loanRepository;

    }

    @Transactional
    public void saveBook(BookCreateRequest request) {
        bookRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {
        // 1. 책 정보를 가져온다.
        Book book = bookRepository.findByName(request.getBookName())
                .orElseThrow(IllegalAccessError::new);

        // 2. 대출 기록 정보를 확인해서 대출중인지 확인한다.
        // 3. 만약 대출중이면 예외를 발생시킨다.
        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)) {
            // 대출중인 책인 경우
            throw new IllegalArgumentException("이미 대출되어 있는 책입니다.");
        }

        // 4. 유저 정보를 가져온다.
        User user = userRepository.findByName(request.getUserName());
        // 5. 유저 정보와 책 정보를 기반으로 UserLoanHistory를 저장한다.
        userLoanHistoryRepository.save(new UserLoanHistory(user, book.getName()));

//        loanRepository.save(new Loan(request.getUserName(), request.getBookName())); // 처음에 내가 구현한 방식
    }

    @Transactional
    public void returnBook(BookReturnRequest request) {

        User user = userRepository.findByName(request.getUserName());

        UserLoanHistory history = userLoanHistoryRepository.findByUserIdAndBookName(user.getId(), request.getBookName())
                .orElseThrow(IllegalAccessError::new);

        history.doReturn();

        // => 나는 책 이름만을 가지고 대출기록 정보를 찾았는데, 이렇게 하면 서로 다른 사람이 똑같은 제목의 책을 빌린 경우도 있을 수 있으므로, userId와 bookName을 함께 이용해서 대출기록 정보를 찾아야 한다.
        //  대출기록 정보를 가져온다.
        // isReturn 속성을 true로 변경한다.
//        UserLoanHistory userLoanHistory = userLoanHistoryRepository.findByBookName(request.getBookName())
//                .orElseThrow(IllegalAccessError::new);
//
//        userLoanHistory.updateIsReturn();
    }
}
