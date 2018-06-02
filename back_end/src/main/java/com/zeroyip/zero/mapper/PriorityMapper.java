package com.zeroyip.zero.mapper;

import com.zeroyip.zero.pojo.Priority;
import com.zeroyip.zero.pojo.PriorityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PriorityMapper {
    int countByExample(PriorityExample example);

    int deleteByExample(PriorityExample example);

    int deleteByPrimaryKey(String priorityLevel);

    int insert(Priority record);

    int insertSelective(Priority record);

    List<Priority> selectByExample(PriorityExample example);

    int updateByExampleSelective(@Param("record") Priority record, @Param("example") PriorityExample example);

    int updateByExample(@Param("record") Priority record, @Param("example") PriorityExample example);
}