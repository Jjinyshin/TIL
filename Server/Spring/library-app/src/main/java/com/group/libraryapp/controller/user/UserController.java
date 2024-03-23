package com.group.libraryapp.controller.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final List<User> users = new ArrayList<>();

    @PostMapping("/user") // POST /user
    public void saveUser(@RequestBody UserCreateRequest request) {
        users.add(new User(request.getName(), request.getAge()));
        // json형식으로 name, age가 들어오면 UserCreateRequest 객체에 값이 매핑되고, 그 값들은 새로운 User객체를 생성하는 데에 사용된다. 새로운 User가 정상적으로 생성되고 나서 User 리스트에 저장되면, 200 OK를 반환한다.
    }

    @GetMapping("/user")
    public List<UserResponse> getAllUsers(){
        List<UserResponse> responses = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            responses.add(new UserResponse(i + 1, users.get(i)));
        }

        return responses;
    }

}
