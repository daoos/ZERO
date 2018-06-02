package com.zeroyip.zero.mapper;

import com.zeroyip.zero.pojo.TeamworkMember;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeamworkMemberMapper {
    String listPermission(@Param("userEmail") String userEmail, @Param("groupNum") Integer groupNum);

    void addManager(@Param("groupNum") Integer groupNum,
                    @Param("groupName") String groupName,
                    @Param("groupMember") String groupMember);

    void addMember(@Param("groupNum") Integer groupNum,
                   @Param("groupName") String groupName,
                   @Param("groupMember") String groupMember);

    void removeMember(@Param("groupNum") Integer groupNum, @Param("memberNum") Integer memberNum);

    void quitGroup(@Param("userEmail") String userEmail, @Param("groupNum") Integer groupNum);
}