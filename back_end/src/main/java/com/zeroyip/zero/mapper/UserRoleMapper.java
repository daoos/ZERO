package com.zeroyip.zero.mapper;

import com.zeroyip.zero.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper {
    UserRole identification(String userEmail);
}
