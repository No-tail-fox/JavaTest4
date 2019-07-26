package Exam1.util;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class logAspect {
    @Before("bean(musicserviceimpl)")
    public void test(){
        System.out.println("-----------------方法执行前-------------------");
    }
}
