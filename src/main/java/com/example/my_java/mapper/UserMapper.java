package com.example.my_java.mapper;

import com.example.my_java.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from lgcms_user limit #{page},#{size}")
    List<User> findAll(Integer page, Integer size);

    @Select("select * from lgcms_user where id = #{id}")
    User findOne(Integer id);

    User updateOne();
}
