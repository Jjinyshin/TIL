package com.group.libraryapp.domain.loan;

import com.group.libraryapp.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {
//    Optional<Loan> findByBookName(String name);
}
