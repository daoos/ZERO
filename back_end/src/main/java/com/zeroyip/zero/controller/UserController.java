package com.zeroyip.zero.controller;

import com.zeroyip.zero.pojo.Notification;
import com.zeroyip.zero.pojo.User;
import com.zeroyip.zero.util.exception.UnauthorizedException;
import com.zeroyip.zero.util.response.Response;
import com.zeroyip.zero.util.jwt.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import com.zeroyip.zero.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/user", produces = {"application/json; charset=utf-8"})
public class UserController {
    @Autowired(required = false)
    private UserService userService;

    // 用户登录
    @PostMapping(value = "/login", consumes = "application/json")
    public Response login(@RequestBody @Valid User userInfo) {
        String userEmail = userInfo.getUserEmail();
        String userPsw = userInfo.getUserPsw();

        User user = userService.login(userEmail, userPsw);

        // 将传入的参数与数据库进行比对
        if ( user.getUserPsw().equals(userPsw) ) {
            // 若两者一致，则返回"200"状态码，并生成token
            return new Response(
                    200,
                    "Login Success",
                    JWTUtil.sign(userEmail, userPsw)
            );
        }
        else {
            throw new UnauthorizedException();
        }
    }

    // 用户注册
    @PostMapping(value = "/register", consumes = "application/json")
    public void register(@RequestBody @Valid User user) {
        userService.createUser(user);
    }

    // 修改用户密码
    @PatchMapping(value = "/modifypsw")
    public String modifyPsw(@RequestHeader String token,
                           @RequestBody @Valid User user) {
        if ( userService.resetPsw(JWTUtil.getuserEmail(token) ,user.getUserPsw()) == "true" ) {
            return "Succeeded";
        }
        else {
            return "Failed";
        }
    }

    // 重置用户密码
    @PatchMapping(value = "/resetpsw")
    public String resetPsw(@RequestBody @Valid User user) {
        if ( userService.resetPsw(user.getUserEmail() ,user.getUserPsw()) == "true" ) {
            return "Succeeded";
        }
        else {
            return "Failed";
        }
    }

    // 修改用户个人信息
    @PatchMapping(value = "/modify")
    public String modify(@RequestHeader String token,
                         @RequestBody @Valid User user) {
        if ( userService.modify(JWTUtil.getuserEmail(token), user) == "true" ) {
            return "Succeeded";
        }
        else {
            return "Failed";
        }
    }

    // 用户查询(登入前)
    @GetMapping(value = "/{userEmail:.+}/find")
    public User findUser(@PathVariable("userEmail") String userEmail) {
        return userService.findUser(userEmail);
    }

    // 用户查询(登入后)
     @GetMapping(value = "/finduserinfo")
     public User findUserInfo(@RequestHeader String token) {
         return userService.findUserInfo(JWTUtil.getuserEmail(token));
     }

    // 用户名查询
    @GetMapping(value = "/{userName}/findusername")
    public User findUsername(@PathVariable("userName") String userName) {
        return userService.findUsername(userName);
    }

    // 删除账户
    @DeleteMapping(value = "/delete")
    public String deleteUser(@RequestHeader String token) {
        if ( userService.deleteUser(JWTUtil.getuserEmail(token)) == "true" ) {
            return "Succeeded";
        }
        else {
            return "Failed";
        }
    }

    // 获取全部通告
    @GetMapping(value = "/getnotice")
    public List<Notification> getNotice(@RequestHeader String token) {
        return userService.getNotice(JWTUtil.getuserEmail(token));
    }

    // 获取未读通告
    @GetMapping(value = "/getnoticeunread")
    public List<Notification> getNoticeUnread(@RequestHeader String token) {
        return userService.getNoticeUnread(JWTUtil.getuserEmail(token));
    }

    // 标记通告为已读
    @PatchMapping(value = "/readnotice/{noticeNum}")
    public void readNotice(@RequestHeader String token,
                                         @PathVariable("noticeNum") Integer noticeNum) {
        userService.readNotice(JWTUtil.getuserEmail(token), noticeNum);
    }

    // 标记所有通告为已读
    @PatchMapping(value = "/readallnotice")
    public void readAllNotification(@RequestHeader String token) {
        userService.readAllNotification(JWTUtil.getuserEmail(token));
    }

    // 捕捉Unauthorized异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @RequestMapping(path = "/401")
    public Response unauthorized() {
        return new Response(
                401,
                "Unauthorized",
                null
        );
    }
}
