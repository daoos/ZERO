package com.zeroyip.zero.service;

import com.zeroyip.zero.pojo.UserSetting;

public interface UserSettingService {
    UserSetting findUserSetting(String userEmail);

    String setUserSetting(String userEmail, UserSetting userNewSetting);
}
