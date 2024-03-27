package com.group.libraryapp.controller.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    // jdbc == java database connector
    private final JdbcTemplate jdbcTemplate;

    public UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/user") // POST /user
    public void saveUser(@RequestBody UserCreateRequest request) {
        String sql = "INSERT INTO user (name, age) VALUES (?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getAge());
    }

    @GetMapping("/user")
    public List<UserResponse> getAllUsers(){
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponse(id, name, age);
        });

//        return jdbcTemplate.query(sql, new RowMapper<UserResponse>() {
//            // sql query를 통해 가져온 user정보를 UserResponse객체로 바꿔주는게 mapRow의 기능
//            @Override
//            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
//                long id = rs.getLong("id"); // 결과에서 id라는 이름의 long type 변수를 가져옴
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                return new UserResponse(id, name, age);
//            }
//        });
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
        String sql = "UPDATE user SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, request.getName(), request.getId());
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) { // 바디를 쓰지 않고 쿼리를 사용함. 객체를 사용할 수도 있지만, 변수가 1개이기 때문에 간단하게 쿼리파라미터로 받음.
        String sql = "DELETE FROM user WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }
}
