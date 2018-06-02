package com.zeroyip.zero.service;

import com.zeroyip.zero.pojo.Inventory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("inventoryService")
public interface InventoryService {
    List<Inventory> findInventory(String userEmail);

    void addInventory(String userEmail, String invTitle);

    String modifyInventory(Integer invNum, String invTitle);

    String deleteInventory(Integer InvNum);
}
