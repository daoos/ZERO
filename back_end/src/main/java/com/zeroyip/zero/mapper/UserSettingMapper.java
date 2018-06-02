package com.zeroyip.zero.mapper;

import com.zeroyip.zero.pojo.UserSetting;
import com.zeroyip.zero.pojo.UserSettingExample;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserSettingMapper {
    UserSetting findUserSetting(String userEmail);

    int setUserSetting(@Param("userEmail") String userEmail, @Param("userNewSetting") UserSetting userNewSetting);
}