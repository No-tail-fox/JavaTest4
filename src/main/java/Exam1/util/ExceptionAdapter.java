package Exam1.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdapter {

    @ExceptionHandler(TestException.class)
    public String handler(TestException e){
        System.out.println("捕获到了异常");
        return "异常";
    }
}
