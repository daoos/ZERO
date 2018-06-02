package com.zeroyip.zero.service.imlp;

import com.zeroyip.zero.mapper.InventoryMapper;
import com.zeroyip.zero.mapper.NotificationMapper;
import com.zeroyip.zero.mapper.UserMapper;
import com.zeroyip.zero.pojo.Inventory;
import com.zeroyip.zero.pojo.Notification;
import com.zeroyip.zero.pojo.User;
import com.zeroyip.zero.service.InventoryService;
import com.zeroyip.zero.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// @Rollback
@Transactional
@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService {
    @Autowired(required = false)
    private InventoryMapper inventoryMapper;

    @Override
    public List<Inventory> findInventory(String userEmail) {
        return inventoryMapper.findInventory(userEmail);
    }

    @Override
    public void addInventory(String userEmail, String invTitle) {
        inventoryMapper.addInventory(userEmail, invTitle);
    }

    @Override
    public String modifyInventory(Integer InvNum, String invTitle) {
        if ( inventoryMapper.modifyInventory(InvNum, invTitle) != 0 ) {
            return "true";
        }
        else {
            return "false";
        }
    }

    @Override
    public String deleteInventory(Integer InvNum) {
        if ( inventoryMapper.deleteInventory(InvNum) != 0  ) {
            return "true";
        }
        else {
            return "false";
        }
    }
}
