package com.group.libraryapp.domain.book;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    public String getName() {
        return name;
    }

    @Column(nullable = false) // @Column의 length 기본값은 255
    private String name;

    public Book(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 입력되었습니다.", name));
        }

        this.name = name;
    }

    protected Book() {

    }
}
