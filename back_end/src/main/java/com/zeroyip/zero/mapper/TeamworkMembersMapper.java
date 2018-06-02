package com.zeroyip.zero.mapper;

import com.zeroyip.zero.pojo.TeamworkMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeamworkMembersMapper {
    List<TeamworkMember> listGroup(String userEmail);

    List<TeamworkMember> listMember(Integer groupNum);
}