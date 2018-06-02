package com.zeroyip.zero.mapper;

import com.zeroyip.zero.pojo.TeamworkGroup;
import com.zeroyip.zero.pojo.TeamworkGroupExample;
import java.util.List;

import com.zeroyip.zero.pojo.TeamworkMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeamworkGroupMapper {
    void createGroup(TeamworkGroup teamworkGroup);

    TeamworkGroup listTeamworkGroup(String userEmail);

    List<TeamworkMember> groupDetails(Integer groupNum);

    void deleteGroup(Integer groupNum);
}