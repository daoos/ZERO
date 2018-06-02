package com.zeroyip.zero.mapper;

import com.zeroyip.zero.pojo.TeamworkTask;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeamworkTaskMapper {
    List<TeamworkTask> listMyTask(@Param("groupNum") Integer groupNum, @Param("userEmail") String userEmail);

    void addTask(@Param("groupNum") Integer groupNum,
                 @Param("taskCreateTime") Date taskCreateTime,
                 @Param("taskContent") String taskContent,
                 @Param("taskTrustee") String taskTrustee);

    void finishTask(Integer taskNum);

    void removeTask(Integer taskNum);
}