package com.example.my_java;

import com.example.my_java.mapper.ShopMapper;
import com.example.my_java.pojo.Shop;
import com.example.my_java.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyJavaApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void haha() {
        System.out.println("哈哈哈");
    }

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 方式1: getMapper
        ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);
        List<Shop> shops = mapper.getShops(1, 10);
        for (Shop shop : shops) {
            System.out.println(shop);
        }

        sqlSession.close();
    }
}
