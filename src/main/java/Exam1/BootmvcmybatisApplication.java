package Exam1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan("Exam1.util")
@MapperScan("Exam1.dao")
public class BootmvcmybatisApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BootmvcmybatisApplication.class, args);
    }
}
