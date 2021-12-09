package com.example.my_java.controller;

import com.example.my_java.utils.JwtUtils;
import com.example.my_java.utils.Result;
import com.example.my_java.utils.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping()
    public Result login(@RequestParam("mobile") String mobile, @RequestParam("password") String password) {
        String token = JwtUtils.createToken(mobile, "qiqin");
        return ResultUtil.success(token);
    }
}
