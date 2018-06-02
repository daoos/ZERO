package com.zeroyip.zero.service;

import com.zeroyip.zero.pojo.Notification;
import com.zeroyip.zero.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userService")
public interface UserService {
    User login(String userEmail, String userPsw);

    void createUser(User user);

    User findUser(String userEmail);

    User findUserInfo(String userEmail);

    User findUsername(String userName);

    String modifyPsw(String userEmail, String userPsw);

    String resetPsw(String userEmail, String userPsw);

    String modify(String userEmail, User user);

    String deleteUser(String userEmail);

    List<Notification> getNotice(String userEmail);

    List<Notification> getNoticeUnread(String userEmail);

    void readNotice(String userEmail, Integer noticeNum);

    void readAllNotification(String userEmail);
}
