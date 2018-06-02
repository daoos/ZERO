package com.zeroyip.zero.controller;

import com.zeroyip.zero.pojo.Filter;
import com.zeroyip.zero.pojo.Manager;
import com.zeroyip.zero.pojo.Notification;
import com.zeroyip.zero.pojo.User;
import com.zeroyip.zero.service.ManagerService;
import com.zeroyip.zero.util.exception.UnauthorizedException;
import com.zeroyip.zero.util.jwt.JWTUtil;
import com.zeroyip.zero.util.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/manager", produces = {"application/json; charset=utf-8"})
public class ManagerController {
    @Autowired(required = false)
    private ManagerService managerService;

    // 用户登录
    @PostMapping(value = "/login", consumes = "application/json")
    public Response login(@RequestBody @Valid Manager managerInfo) {
        String managerId = managerInfo.getManagerId();
        String managerPsw = managerInfo.getManagerPsw();

        Manager manager = managerService.login(managerId, managerPsw);

        // 将传入的参数与数据库进行比对
        if ( manager.getManagerPsw().equals(managerPsw) ) {
            // 若两者一致，则返回"200"状态码，并生成token
            return new Response(
                    200,
                    "Login Success",
                    JWTUtil.sign(managerId, managerPsw)
            );
        }
        else {
            throw new UnauthorizedException();
        }
    }

    // 查看所有用户
    @GetMapping(value = "/findalluser")
    public List<User> findAllUser() {
        System.out.println(managerService.findAllUser().get(0));
        return managerService.findAllUser();
    }

    // 冗余清除
    @DeleteMapping(value = "/deleteredundancy")
    public String deleteRedundancy() {
        if ( managerService.deleteRedundancy() == "true" ) {
            return "Succeeded";
        }
        else {
            return "Failed";
        }
    }

    // 发布公告
    @PostMapping(value = "/sendnotice", consumes = "application/json")
    public void sendNotice(@RequestHeader String token,
                           @RequestBody @Valid Notification notification) {
        managerService.sendNotice(
                JWTUtil.getuserEmail(token),
                notification.getNoticeSendTime(),
                notification.getNoticeReceiver(),
                notification.getNoticeTitle(),
                notification.getNoticeContent());
    }

    // 添加过滤器
    @PostMapping(value = "/{managerId}/addfilter", consumes = "application/json")
    public void addFilter(@PathVariable("managerId") String managerId,
                           @RequestBody @Valid Filter filter) {
        managerService.addFilter(managerId, filter);
    }
}
