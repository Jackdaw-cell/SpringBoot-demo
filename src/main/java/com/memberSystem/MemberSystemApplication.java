package com.memberSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //响应和请求的注解
@SpringBootApplication
public class MemberSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberSystemApplication.class, args);

    }
}
