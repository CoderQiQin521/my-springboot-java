package com.example.my_java.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;
import java.util.Date;

@MyAnnotation(info = "注解执行了")
public class JwtUtils {
//    @Deprecated
    public static String createToken(String userId, String realname) {

        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 30);
        Date expiresDate = nowTime.getTime();

        return JWT.create().withAudience(userId)
                .withIssuedAt(new Date())
                .withExpiresAt(expiresDate)
                .withClaim("realname", realname)
                .sign(Algorithm.HMAC256(userId+"hello"));
    }
}
