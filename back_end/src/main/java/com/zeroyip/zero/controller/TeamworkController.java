package com.zeroyip.zero.controller;

import com.zeroyip.zero.pojo.*;
import com.zeroyip.zero.service.TeamworkService;
import com.zeroyip.zero.service.UserService;
import com.zeroyip.zero.util.jwt.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/teamwork", produces = {"application/json; charset=utf-8"})
public class TeamworkController {
    @Autowired(required = false)
    private TeamworkService teamworkService;

    // 用户鉴权
    @PostMapping(value = "/identification", consumes = "application/json")
    public UserRole identification(@RequestHeader String token,
                                   @RequestBody @Valid UserRole userInfo) {
        String userEmail = JWTUtil.getuserEmail(token);

        userInfo.setUserEmail(userEmail);

        String userRole = userInfo.getUserEmail();

        return teamworkService.identification(userRole);
    }

    // 罗列当前用户的所有讨论组
    @GetMapping(value = "/listgroup")
    public List<TeamworkMember> listGroup(@RequestHeader String token) {
        return teamworkService.listGroup(JWTUtil.getuserEmail(token));
    }

    // 新建讨论组
    @PostMapping(value = "/creategroup")
    public void createGroup(@RequestHeader String token,
                            @RequestBody @Valid TeamworkGroup teamworkGroup ) {
        teamworkGroup.setCreator(JWTUtil.getuserEmail(token));
        teamworkService.createGroup(teamworkGroup);
    }

    // 查询当前用户的当前讨论组的权限
    @PostMapping(value = "/listpermission")
    public String listPermission(@RequestHeader String token,
                                 @RequestBody @Valid TeamworkMember teamworkMember) {
        String userPermission = teamworkService.listPermission(JWTUtil.getuserEmail(token), teamworkMember.getGroupNum());
        return userPermission;
    }

    // 查询讨论组管理员信息
    @GetMapping(value = "/listteamworkgroup")
    public TeamworkGroup listTeamworkGroup(@RequestHeader String token) {
        return teamworkService.listTeamworkGroup(JWTUtil.getuserEmail(token));
    }

    // 添加讨论组管理者
    @PostMapping(value = "/creategroupmanager")
    public void createGroupManager(@RequestHeader String token,
                                   @RequestBody @Valid TeamworkMember teamworkMember) {
        teamworkService.createGroupManager(teamworkMember.getGroupNum(), teamworkMember.getGroupName(), JWTUtil.getuserEmail(token));
    }

    // 罗列讨论组消息内容
    @GetMapping(value = "/{groupNum}/listmessage")
    public List<TeamworkMessage> listMessage(@PathVariable("groupNum") Integer groupNum) {
        return teamworkService.listMessage(groupNum);
    }

    // 发送消息
    @PostMapping(value = "/sendmessage")
    public void sendMessage(@RequestHeader String token,
                            @RequestBody @Valid TeamworkMessage teamworkMessage ) {
        teamworkMessage.setMessInitiator(JWTUtil.getuserEmail(token));
        teamworkService.sendMessage(teamworkMessage);
    }

    // 罗列当前讨论组成员
    @GetMapping(value = "/{groupNum}/listmember")
    public List<TeamworkMember> listMember(@PathVariable("groupNum") Integer groupNum) {
        return teamworkService.listMember(groupNum);
    }

    // 查询讨论组详情
    @GetMapping(value = "/{groupNum}/groupdetails")
    public List<TeamworkMember> groupDetails(@PathVariable("groupNum") Integer groupNum) {
        return teamworkService.groupDetails(groupNum);
    }

    // 添加讨论组成员
    @PostMapping(value = "/{groupNum}/addmember")
    public void addMember(@PathVariable("groupNum") Integer groupNum,
                          @RequestBody @Valid TeamworkMember teamworkMember) {
        teamworkService.addMember(groupNum, teamworkMember.getGroupName(), teamworkMember.getGroupMember());
    }

    // 移除讨论组成员(仅讨论组建立者可用)
    @DeleteMapping(value = "/{groupNum}/removemember")
    public void removeMember(@PathVariable("groupNum") Integer groupNum,
                             @RequestBody @Valid TeamworkMember teamworkMember) {
        teamworkService.removeMember(groupNum, teamworkMember.getMemberNum());
    }

    // 罗列当前讨论组的日程表
    @GetMapping(value = "/{groupNum}/listschedule")
    public List<TeamworkSchedule> listSchedule(@PathVariable("groupNum") Integer groupNum) {
        return teamworkService.listSchedule(groupNum);
    }

    // 添加日程表(仅讨论组建立者可用)
    @PostMapping(value = "/{groupNum}/addschedule")
    public void addSchedule(@PathVariable("groupNum") Integer groupNum,
                            @RequestBody @Valid TeamworkSchedule teamworkSchedule) {
        teamworkService.addSchedule(groupNum, teamworkSchedule.getSchContent(), teamworkSchedule.getSchTime());
    }

    // 移除某条日程表(仅讨论组建立者可用)
    @DeleteMapping(value = "/{schNum}/removeschedule")
    public String removeSchedule(@PathVariable("schNum") Integer schNum) {
        if ( teamworkService.removeSchedule(schNum) == "true" ) {
            return "Succeeded";
        }
        else {
            return "Failed";
        }
    }

    // 移除所有日程表
    @DeleteMapping(value = "/{groupNum}/removeallschedule")
    public String removeAllSchedule(@PathVariable("groupNum") Integer groupNum) {
        if ( teamworkService.removeAllSchedule(groupNum) == "true" ) {
            return "Succeeded";
        }
        else {
            return "Failed";
        }
    }

    // 显示自己的任务
    @GetMapping(value = "/{groupNum}/listmytask")
    public List<TeamworkTask> listMyTask(@PathVariable("groupNum") Integer groupNum,
                                         @RequestHeader String token) {
        return teamworkService.listMyTask(groupNum, JWTUtil.getuserEmail(token));
    }

    // 显示他人的任务
    @GetMapping(value = "/{groupNum}/listothertask")
    public List<TeamworkTask> listOtherTask(@PathVariable("groupNum") Integer groupNum,
                                            @RequestHeader String token) {
        return teamworkService.listOtherTask(groupNum, JWTUtil.getuserEmail(token));
    }

    // 添加任务(仅讨论组建立者可用)
    @PostMapping(value = "/{groupNum}/addtask")
    public void addTask(@PathVariable("groupNum") Integer groupNum,
                        @RequestBody @Valid TeamworkTask teamworkTask) {
        teamworkService.addTask(
                groupNum,
                teamworkTask.getTaskCreateTime(),
                teamworkTask.getTaskContent(),
                teamworkTask.getTaskTrustee());
    }

    // 完成某条任务
    @PatchMapping(value = "/{taskNum}/finishtask")
    public void finishTask(@PathVariable("taskNum") Integer taskNum) {
        teamworkService.finishTask(taskNum);
    }

    // 移除某条任务
    @DeleteMapping(value = "/{taskNum}/removetask")
    public void removeTask(@PathVariable("taskNum") Integer taskNum) {
        teamworkService.removeTask(taskNum);
    }

    // 删除讨论组(对讨论组建立者)
    @DeleteMapping(value = "/deletegroup/{groupNum}")
    public void deleteGroup(@PathVariable("groupNum") Integer groupNum) {
        teamworkService.deleteGroup(groupNum);
    }

    // 退出讨论组(对讨论组成员)
    @DeleteMapping(value = "/quitgroup/{groupNum}")
    public void quitGroup(@RequestHeader String token,
                          @PathVariable("groupNum") Integer groupNum) {
        teamworkService.quitGroup(JWTUtil.getuserEmail(token), groupNum);
    }
}
