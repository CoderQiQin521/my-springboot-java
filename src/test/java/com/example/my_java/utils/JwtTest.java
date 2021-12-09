package com.example.my_java.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// https://blog.csdn.net/qq_43948583/article/details/104437752
@SpringBootTest
public class JwtTest {
    @Test
    public void test() {
        String token = JwtUtils.createToken("1", "齐秦");
        System.out.println(token);
    }
}
