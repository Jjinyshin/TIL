package com.group.libraryapp.dto.user.request;

public class UserCreateRequest {

    private String name;
    private Integer age; // Integer는 null 표현이 가능한 반면, int는 null 표현이 불가하므로 요구사항(age는 null 가능)에 따라알맞은 자료형을 선택함.

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
