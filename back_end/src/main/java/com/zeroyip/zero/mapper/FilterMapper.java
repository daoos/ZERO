package com.zeroyip.zero.mapper;

import com.zeroyip.zero.pojo.Filter;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FilterMapper {
    void addFilter(@Param("managerId") String managerId, @Param("Filter") Filter Filter);
}