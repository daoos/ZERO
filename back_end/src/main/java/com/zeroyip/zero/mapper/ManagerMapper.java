package com.zeroyip.zero.mapper;

import com.zeroyip.zero.pojo.Manager;
import com.zeroyip.zero.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManagerMapper {
    Manager login(@Param("managerId") String managerId, @Param("managerPsw") String managerPsw);
}