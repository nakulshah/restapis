package com.nakulshah;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @PostMapping("/calculate")
    public CalculateResponse calculate(@RequestBody CalculateRequest calculateRequest)
    {
        return new CalculateResponse(calculateRequest.num1, calculateRequest.num2, calculateRequest.operator, (calculateRequest.num1+calculateRequest.num2)) ;
    }
}
