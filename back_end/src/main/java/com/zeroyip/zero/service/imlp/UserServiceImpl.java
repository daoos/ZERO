package com.zeroyip.zero.service.imlp;

import com.zeroyip.zero.mapper.NotificationMapper;
import com.zeroyip.zero.mapper.UserMapper;
import com.zeroyip.zero.pojo.Notification;
import com.zeroyip.zero.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeroyip.zero.service.UserService;

import java.util.List;

// @Rollback
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private NotificationMapper notificationMapper;

    @Override
    public User login(String userEmail, String userPsw) {
        return userMapper.login(userEmail, userPsw);
    }

    @Override
    public void createUser(User user) {
        userMapper.createUser(user);
    }

    @Override
    public User findUser(String userEmail) {
        return userMapper.findUser(userEmail);
    }

    @Override
    public User findUserInfo(String userEmail) {
        return userMapper.findUserInfo(userEmail);
    }

    @Override
    public User findUsername(String userName) {
        return userMapper.findUsername(userName);
    }

    @Override
    public String modifyPsw(String userEmail, String userPsw) {
        if ( userMapper.modifyPsw(userEmail, userPsw) != 0 ) {
            return "true";
        }
        else {
            return "false";
        }
    }

    @Override
    public String resetPsw(String userEmail, String userPsw) {
        if ( userMapper.resetPsw(userEmail, userPsw) != 0 ) {
            return "true";
        }
        else {
            return "false";
        }
    }

    @Override
    public String modify(String userEmail, User user) {
        if ( userMapper.modify(userEmail, user) != 0 ) {
            return "true";
        }
        else {
            return "false";
        }
    }

    @Override
    public String deleteUser(String userEmail) {
        if ( userMapper.deleteUser(userEmail) != 0  ) {
            return "true";
        }
        else {
            return "false";
        }
    }

    @Override
    public List<Notification> getNotice(String userEmail) {
        return notificationMapper.getNotice(userEmail);
    }

    @Override
    public List<Notification> getNoticeUnread(String userEmail) {
        return notificationMapper.getNoticeUnread(userEmail);
    }

    @Override
    public void readNotice(String userEmail, Integer noticeNum) {
        notificationMapper.readNotice(userEmail, noticeNum);
    }

    @Override
    public void readAllNotification(String userEmail) {
        notificationMapper.readAllNotification(userEmail);
    }
}
