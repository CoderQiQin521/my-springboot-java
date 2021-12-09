package com.example.my_java.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

@MyAnnotation(info = "注解执行了")
public class JwtUtils {
//    @Deprecated

    /**
     * 签发时间: 现在
     * 过期时间30分钟
     * 载荷内容: 用户名
     * 加密字符串 hello
     *
     * @param userId   签发对象这个用户的id
     * @param realname
     * @return
     */
    public static String createToken(String userId, String realname) {

        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 30);
        Date expiresDate = nowTime.getTime();

        return JWT.create().withAudience(userId)
                .withIssuedAt(new Date())
                .withExpiresAt(expiresDate)
                .withClaim("realname", realname)
                .sign(Algorithm.HMAC256(userId + "hello"));
    }

    public static DecodedJWT verifyToken(String token) throws Exception {
        DecodedJWT jwt = null;
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(Base64.getDecoder().decode("1hello"))).build();
        return verifier.verify(token);
    }
}
