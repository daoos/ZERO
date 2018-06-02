package com.zeroyip.zero.mapper;

import com.zeroyip.zero.pojo.User;

import com.zeroyip.zero.pojo.UserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User login(@Param("userEmail") String userEmail, @Param("userPsw") String userPsw);

    void createUser(User user);

    User findUser(String userEmail);

    User findUserInfo(String userEmail);

    List<User> findAllUser();

    User findUsername(String userName);

    int modifyPsw(@Param("userEmail") String userEmail, @Param("userPsw") String userPsw);

    int resetPsw(@Param("userEmail") String userEmail, @Param("userPsw") String userPsw);

    int modify(@Param("userEmail") String userEmail, @Param("user") User user);

    int deleteUser(String userEmail);
}