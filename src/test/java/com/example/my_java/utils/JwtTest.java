package com.example.my_java.utils;

import com.auth0.jwt.interfaces.DecodedJWT;
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

    @Test
    public void ver() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxODUzODMwMDgzOSIsImV4cCI6MTYzOTA0NTM1MywiaWF0IjoxNjM5MDQzNTUzLCJyZWFsbmFtZSI6InFpcWluIn0.dnoXT2NPfy1RgzDOd1tm2PLWHoyizyLxYRn8BHqo7Lo";

        try {
            DecodedJWT aa = JwtUtils.verifyToken(token);
            System.out.println(aa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
