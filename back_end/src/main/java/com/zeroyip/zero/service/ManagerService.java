package com.zeroyip.zero.service;

import com.zeroyip.zero.pojo.Filter;
import com.zeroyip.zero.pojo.Manager;
import com.zeroyip.zero.pojo.Notification;
import com.zeroyip.zero.pojo.User;

import java.util.Date;
import java.util.List;

public interface ManagerService {
    Manager login(String managerId, String managerPsw);

    List<User> findAllUser();

    String deleteRedundancy();

    void sendNotice(String managerId,
                    Date noticeSendTime,
                    String noticeReceiver,
                    String noticeTitle,
                    String noticeContent);

    void addFilter(String managerId, Filter filter);
}
