package com.group.libraryapp.domain.loan;

import javax.persistence.*;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String bookName;

    public Loan(String userName, String bookName) {
        this.userName = userName;
        this.bookName = bookName;
    }

    protected Loan() {

    }
}
