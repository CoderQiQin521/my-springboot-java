package com.example.my_java.controller;

import com.example.my_java.mapper.ShopMapper;
import com.example.my_java.pojo.Shop;
import com.example.my_java.utils.MybatisUtils;
import com.example.my_java.utils.Result;
import com.example.my_java.utils.ResultUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @GetMapping()
    public Result<Shop> index(Integer page, Integer size) {
        page = page == null ? 1 : (page - 1) * size;
        size = size == null ? 10 : size;
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ShopMapper shopMapper = sqlSession.getMapper(ShopMapper.class);
        List<Shop> list = shopMapper.getShops(page, size);
        sqlSession.close();
        return ResultUtil.success(list);
    }

    @GetMapping("/{id}")
    public Shop detail(@PathVariable Integer id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ShopMapper shopMapper = sqlSession.getMapper(ShopMapper.class);
        Shop shop = shopMapper.getShopById(id);
        sqlSession.close();
        return shop;
    }
}
