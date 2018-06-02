package com.zeroyip.zero.service.imlp;

import com.zeroyip.zero.mapper.*;
import com.zeroyip.zero.pojo.*;
import com.zeroyip.zero.service.TeamworkService;
import com.zeroyip.zero.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

// @Rollback
@Transactional
@Service("teamworkService")
public class TeamworkServiceImpl implements TeamworkService {
    @Autowired(required = false)
    private UserRoleMapper userRoleMapper;
    @Autowired(required = false)
    private TeamworkGroupMapper teamworkGroupMapper;
    @Autowired(required = false)
    private TeamworkMessageMapper teamworkMessageMapper;
    @Autowired(required = false)
    private TeamworkMessagesMapper teamworkMessagesMapper;
    @Autowired(required = false)
    private TeamworkMemberMapper teamworkMemberMapper;
    @Autowired(required = false)
    private TeamworkMembersMapper teamworkMembersMapper;
    @Autowired(required = false)
    private TeamworkScheduleMapper teamworkScheduleMapper;
    @Autowired(required = false)
    private TeamworkTaskMapper teamworkTaskMapper;
    @Autowired(required = false)
    private TeamworkTasksMapper teamworkTasksMapper;

    @Override
    public UserRole identification(String userEmail) {
        return userRoleMapper.identification(userEmail);
    }

    @Override
    public List<TeamworkMember> listGroup(String userEmail) {
        return teamworkMembersMapper.listGroup(userEmail);
    }

    @Override
    public String listPermission(String userEmail, Integer groupNum) {
        return teamworkMemberMapper.listPermission(userEmail, groupNum);
    }

    @Override
    public TeamworkGroup listTeamworkGroup(String userEmail) {
        return teamworkGroupMapper.listTeamworkGroup(userEmail);
    }

    @Override
    public List<TeamworkMember> groupDetails(Integer groupNum) {
        return teamworkGroupMapper.groupDetails(groupNum);
    }

    @Override
    public void createGroup(TeamworkGroup teamworkGroup) {
        teamworkGroupMapper.createGroup(teamworkGroup);
    }

    @Override
    public void createGroupManager(Integer groupNum, String groupName, String groupMember) {
        teamworkMemberMapper.addManager(groupNum, groupName, groupMember);
    }

    @Override
    public List<TeamworkMessage> listMessage(Integer groupNum) {
        return teamworkMessagesMapper.listMessage(groupNum);
    }

    @Override
    public void sendMessage(TeamworkMessage teamworkMessage) {
        teamworkMessageMapper.sendMessage(teamworkMessage);
    }

    @Override
    public List<TeamworkMember> listMember(Integer groupNum) {
        return teamworkMembersMapper.listMember(groupNum);
    }

    @Override
    public void addMember(Integer groupNum, String groupName, String groupMember) {
        teamworkMemberMapper.addMember(groupNum, groupName, groupMember);
    }

    @Override
    public void removeMember(Integer groupNum, Integer memberNum) {
        teamworkMemberMapper.removeMember(groupNum, memberNum);
    }

    @Override
    public List<TeamworkSchedule> listSchedule(Integer groupNum) {
        return teamworkScheduleMapper.listSchedule(groupNum);
    }

    @Override
    public void addSchedule(Integer groupNum, String schContent, Date schTime) {
        teamworkScheduleMapper.addSchedule(groupNum, schContent, schTime);
    }

    @Override
    public String removeSchedule(Integer schNum) {
        if ( teamworkScheduleMapper.removeSchedule(schNum) != 0 ) {
            return "true";
        }
        else {
            return "false";
        }
    }

    @Override
    public String removeAllSchedule(Integer groupNum) {
        if ( teamworkScheduleMapper.removeAllSchedule(groupNum) != 0 ) {
            return "true";
        }
        else {
            return "false";
        }
    }

    @Override
    public List<TeamworkTask> listMyTask(Integer groupNum, String userEmail) {
        return teamworkTaskMapper.listMyTask(groupNum, userEmail);
    }

    @Override
    public List<TeamworkTask> listOtherTask(Integer groupNum, String userEmail) {
        return teamworkTasksMapper.listOtherTask(groupNum, userEmail);
    }

    @Override
    public void addTask(Integer groupNum, Date taskCreateTime, String taskContent, String taskTrustee) {
        teamworkTaskMapper.addTask(groupNum, taskCreateTime, taskContent, taskTrustee);
    }

    @Override
    public void finishTask(Integer taskNum) {
        teamworkTaskMapper.finishTask(taskNum);
    }

    @Override
    public void removeTask(Integer taskNum) {
        teamworkTaskMapper.removeTask(taskNum);
    }

    @Override
    public void deleteGroup(Integer groupNum) {
        teamworkGroupMapper.deleteGroup(groupNum);
    }

    @Override
    public void quitGroup(String userEmail, Integer groupNum) {
        teamworkMemberMapper.quitGroup(userEmail, groupNum);
    }
}
