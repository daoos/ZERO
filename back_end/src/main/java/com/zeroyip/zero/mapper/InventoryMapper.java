package com.zeroyip.zero.mapper;

import com.zeroyip.zero.pojo.Inventory;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InventoryMapper {
    List<Inventory> findInventory(String userEmail);

    void addInventory(@Param("userEmail") String userEmail, @Param("invTitle") String invTitle);

    int modifyInventory(@Param("invNum") Integer invNum, @Param("invTitle") String invTitle);

    int deleteInventory(Integer InvNum);
}