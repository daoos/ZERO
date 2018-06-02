package com.zeroyip.zero.controller;

import com.zeroyip.zero.pojo.UserSetting;
import com.zeroyip.zero.service.UserSettingService;
import com.zeroyip.zero.util.jwt.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/userSetting", produces = {"application/json; charset=utf-8"})
public class UserSettingController {
    @Autowired(required = false)
    private UserSettingService userSettingService;

    // 查询用户设置
    @GetMapping(value = "/findUserSetting")
    public UserSetting findUserSetting(@RequestHeader String token) {
        return userSettingService.findUserSetting(JWTUtil.getuserEmail(token));
    }

    // 更改用户设置
    @PatchMapping(value = "/setUserSetting", consumes = "application/json")
    public String setUserSetting(@RequestHeader String token,
                                 @Valid @RequestBody UserSetting userNewSetting) {
        if ( userSettingService.setUserSetting(JWTUtil.getuserEmail(token), userNewSetting) == "true" ) {
            return "Succeeded";
        }
        else {
            return "Failed";
        }
    }
}
