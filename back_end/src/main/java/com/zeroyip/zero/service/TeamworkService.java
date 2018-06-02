package com.zeroyip.zero.service;

import com.zeroyip.zero.pojo.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("teamworkService")
public interface TeamworkService {
    UserRole identification(String userEmail);

    List<TeamworkMember> listGroup(String userEmail);

    String listPermission(String userEmail, Integer groupNum);

    TeamworkGroup listTeamworkGroup(String userEmail);

    List<TeamworkMember> groupDetails(Integer groupNum);

    void createGroup(TeamworkGroup teamworkGroup);

    void createGroupManager(Integer groupNum, String groupName, String groupMember);


    List<TeamworkMessage> listMessage(Integer groupNum);

    void sendMessage(TeamworkMessage teamworkMessage);

    List<TeamworkMember> listMember(Integer groupNum);

    void addMember(Integer groupNum, String groupName, String groupMember);

    void removeMember(Integer groupNum, Integer memberNum);

    List<TeamworkSchedule> listSchedule(Integer groupNum);

    void addSchedule(Integer groupNum, String schContent, Date schTime);

    String removeSchedule(Integer schNum);

    String removeAllSchedule(Integer groupNum);

    List<TeamworkTask> listMyTask(Integer groupNum, String userEmail);

    List<TeamworkTask> listOtherTask(Integer groupNum, String userEmail);

    void addTask(Integer groupNum,
                 Date taskCreateTime,
                 String taskContent,
                 String taskTrustee);

    void finishTask(Integer taskNum);

    void removeTask(Integer taskNum);

    void deleteGroup(Integer groupNum);

    void quitGroup(String userEmail, Integer groupNum);
}
