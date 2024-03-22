package com.group.libraryapp.domain.user;

public class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        // API를 통해 들어온 name 값이 null이거나 비어있다면 예외를 던지기 때문에 User 자체가 생성되지 않으므로 신규 유저가 저장될 수 없다.
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
            // 어떤 값이 예외를 발생시켰는지 알려주기 위하여 메시지를 작성함.
        }
        this.name = name;
        this.age = age;
    }
}
