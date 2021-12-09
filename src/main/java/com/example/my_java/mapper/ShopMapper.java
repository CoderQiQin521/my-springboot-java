package com.example.my_java.mapper;

import com.example.my_java.pojo.Shop;

import java.util.List;

public interface ShopMapper {
    Shop getShopById(int id);

    List<Shop> getShops(int page, int size);
}
