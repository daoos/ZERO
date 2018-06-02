package com.zeroyip.zero.controller;

import com.zeroyip.zero.pojo.Inventory;
import com.zeroyip.zero.pojo.Notification;
import com.zeroyip.zero.pojo.User;
import com.zeroyip.zero.service.InventoryService;
import com.zeroyip.zero.service.UserService;
import com.zeroyip.zero.util.exception.UnauthorizedException;
import com.zeroyip.zero.util.jwt.JWTUtil;
import com.zeroyip.zero.util.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/inventory", produces = {"application/json; charset=utf-8"})
public class InventoryController {
    @Autowired(required = false)
    private InventoryService inventoryService;

    // 获取清单
    @GetMapping(value = "/find")
    public List<Inventory> findInventory(@RequestHeader String token) {
        return inventoryService.findInventory(JWTUtil.getuserEmail(token));
    }

    // 添加清单
    @PostMapping(value = "/add", consumes = "application/json")
    public void addInventory(@RequestHeader String token,
                             @RequestBody @Valid Inventory inventory) {
        inventoryService.addInventory(JWTUtil.getuserEmail(token), inventory.getInvTitle());
    }

    // 修改清单
    @PatchMapping(value = "/modify")
    public String modifyInventory(@RequestBody @Valid Inventory inventory) {
        if ( inventoryService.modifyInventory(inventory.getInvNum(), inventory.getInvTitle()) == "true" ) {
            return "Succeeded";
        }
        else {
            return "Failed";
        }
    }

    // 删除清单
    @DeleteMapping(value = "/delete")
    public String deleteInventory(@RequestBody @Valid Inventory inventory) {
        if ( inventoryService.deleteInventory(inventory.getInvNum()) == "true" ) {
            return "Succeeded";
        }
        else {
            return "Failed";
        }
    }
}
