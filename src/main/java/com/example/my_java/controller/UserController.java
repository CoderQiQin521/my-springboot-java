package com.example.my_java.controller;

import com.example.my_java.mapper.UserMapper;
import com.example.my_java.pojo.User;
import com.example.my_java.utils.MybatisUtils;
import com.example.my_java.utils.Result;
import com.example.my_java.utils.ResultUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

//    @GetMapping()
//    public Result<User> findAll(@RequestParam(value = "page", defaultValue = "1") String page, @RequestParam(value = "size", defaultValue = "10") String size) {
//        page = Integer.toString(page);
//        page = page == null ? 0 : (page-1)*size;
//        size = size == null ? 10 : size;
//
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = mapper.findAll(page,size);
//        sqlSession.close();
//
//        return ResultUtil.success(users);
//    }

    @PostMapping("/{id}")
    public Result<User> findOne(@PathVariable("id") Integer id, @RequestParam("name") String name) {
        System.out.println(name);
        System.out.println("aa");

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User users = mapper.findOne(id);
        sqlSession.close();

        return ResultUtil.success(users);
    }
}
