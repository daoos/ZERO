package com.zeroyip.zero.mapper;

import com.zeroyip.zero.pojo.TeamworkTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeamworkTasksMapper {
    List<TeamworkTask> listOtherTask(@Param("groupNum") Integer groupNum, @Param("userEmail") String userEmail);
}