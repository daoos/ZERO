package com.zeroyip.zero.mapper;

import com.zeroyip.zero.pojo.TeamworkSchedule;
import com.zeroyip.zero.pojo.TeamworkScheduleExample;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeamworkScheduleMapper {
    List<TeamworkSchedule> listSchedule(Integer groupNum);

    void addSchedule(@Param("groupNum") Integer groupNum,
                     @Param("schContent") String schContent,
                     @Param("schTime") Date schTime);

    int removeSchedule(@Param("schNum") Integer schNum);

    int removeAllSchedule(Integer groupNum);
}