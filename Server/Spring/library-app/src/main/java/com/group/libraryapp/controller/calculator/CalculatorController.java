package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/add")// GET /add
    public int addTwoNumbers(CalculatorAddRequest request) {
        return request.getNum1() + request.getNum2();
    }

    @PostMapping("/multiply") // 이 어노테이션은 `POST /multiply` 라는 API가 호출되었을 때, 아래 함수를 실행시켜줌
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
        // @RequestBody 어노테이션이 붙어있어야 http body 에 담겨 들어온 JSON을 CalculatorMultiplyRequest 객체로 변환시킬 수 있다.
        return request.getNum1() * request.getNum2();
    }
}
