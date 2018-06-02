package com.zeroyip.zero.mapper;

import com.zeroyip.zero.pojo.Notification;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface NotificationMapper {
    void sendNotice(@Param("managerId") String managerId,
                    @Param("noticeSendTime") Date noticeSendTime,
                    @Param("noticeReceiver") String noticeReceiver,
                    @Param("noticeTitle") String noticeTitle,
                    @Param("noticeContent") String noticeContent);

    List<Notification> getNotice(String userEmail);

    List<Notification> getNoticeUnread(String userEmail);

    void readNotice(@Param("userEmail") String userEmail,
                    @Param("noticeNum") Integer noticeNum);

    void readAllNotification(String userEmail);
}