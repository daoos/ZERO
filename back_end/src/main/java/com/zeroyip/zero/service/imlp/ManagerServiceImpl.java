package com.zeroyip.zero.service.imlp;

import com.zeroyip.zero.mapper.*;
import com.zeroyip.zero.pojo.Filter;
import com.zeroyip.zero.pojo.Manager;
import com.zeroyip.zero.pojo.Notification;
import com.zeroyip.zero.pojo.User;
import com.zeroyip.zero.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

// @Rollback
@Transactional
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
    @Autowired(required = false)
    private ManagerMapper managerMapper;
    @Autowired(required = false)
    private NotificationMapper notificationMapper;
    @Autowired(required = false)
    private FilterMapper filterMapper;
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Override
    public Manager login(String managerId, String managerPsw) {
        return managerMapper.login(managerId, managerPsw);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public String deleteRedundancy() {
        if ( todoMapper.deleteRedundancy() != 0 ) {
            return "true";
        }
        else {
            return "false";
        }
    }

    @Override
    public void sendNotice(String managerId, Date noticeSendTime, String noticeReceiver, String noticeTitle, String noticeContent) {
        notificationMapper.sendNotice(managerId, noticeSendTime, noticeReceiver, noticeTitle, noticeContent);
    }

    @Override
    public void addFilter(String managerId, Filter filter) {
        filterMapper.addFilter(managerId, filter);
    }
}
