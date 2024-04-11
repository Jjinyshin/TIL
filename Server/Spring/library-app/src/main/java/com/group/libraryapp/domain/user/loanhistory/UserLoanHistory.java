package com.group.libraryapp.domain.user.loanhistory;

import javax.persistence.*;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String bookName;

    private boolean isReturn;

    public UserLoanHistory(Long userId, String bookName) {
        this.userId = userId;
        this.bookName = bookName;
        this.isReturn = false;
    }

    protected UserLoanHistory() {

    }
}
