package com.zeroyip.zero.service.imlp;

import com.zeroyip.zero.mapper.UserSettingMapper;
import com.zeroyip.zero.pojo.UserSetting;
import com.zeroyip.zero.service.UserSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// @Rollback
@Transactional
@Service("userSettingService")
public class UserSettingServiceImpl implements UserSettingService {
    @Autowired(required = false)
    private UserSettingMapper userSettingMapper;

    @Override
    public UserSetting findUserSetting(String userEmail) {
        UserSetting settings = userSettingMapper.findUserSetting(userEmail);
        return settings;
    }

    @Override
    public String setUserSetting(String userEmail, UserSetting userNewSetting) {
        if ( userSettingMapper.setUserSetting(userEmail, userNewSetting) != 0 ) {
            return "true";
        }
        else {
            return "false";
        }
    }
}
