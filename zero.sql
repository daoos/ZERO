/*
 Navicat MySQL Data Transfer

 Source Server         : ZeroYip
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : zero

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 02/06/2018 16:34:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for filter
-- ----------------------------
DROP TABLE IF EXISTS `filter`;
CREATE TABLE `filter`  (
  `manager_id` varchar(6) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '管理员工号',
  `filter_num` int(4) NOT NULL AUTO_INCREMENT COMMENT '过滤器序号',
  `filter_content` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '过滤器标题',
  PRIMARY KEY (`filter_num`) USING BTREE,
  INDEX `manager_filter`(`manager_id`) USING BTREE,
  INDEX `filter_content`(`filter_content`) USING BTREE,
  CONSTRAINT `manager_filter` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`manager_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '过滤器信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory`  (
  `user_email` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '个人用户邮箱地址',
  `inv_num` int(11) NOT NULL AUTO_INCREMENT COMMENT '清单编号',
  `inv_title` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '清单标题',
  PRIMARY KEY (`inv_num`) USING BTREE,
  INDEX `user_inv`(`user_email`) USING BTREE,
  INDEX `inv_title`(`inv_title`) USING BTREE,
  CONSTRAINT `user_inv` FOREIGN KEY (`user_email`) REFERENCES `user` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '清单信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `manager_id` varchar(6) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '管理员工号',
  `manager_psw` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '管理员密码',
  PRIMARY KEY (`manager_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '管理员信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for memorandum
-- ----------------------------
DROP TABLE IF EXISTS `memorandum`;
CREATE TABLE `memorandum`  (
  `user_email` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '个人用户邮箱地址',
  `mem_create_time` date NOT NULL COMMENT '备忘录创建时间',
  `mem_num` int(5) NOT NULL AUTO_INCREMENT COMMENT '备忘录序号',
  `mem_title` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '无标题' COMMENT '备忘录标题',
  `mem_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '内容为空' COMMENT '备忘录内容',
  PRIMARY KEY (`mem_num`) USING BTREE,
  INDEX `user_mem`(`user_email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '备忘录信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification`  (
  `manager_id` varchar(6) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '管理员工号',
  `notice_send_time` date NOT NULL COMMENT '通知发送时间',
  `notice_num` int(4) NOT NULL AUTO_INCREMENT COMMENT '通知编号',
  `notice_title` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '管理员' COMMENT '通知标题',
  `notice_content` varchar(150) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '通知内容',
  `notice_receiver` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '接收者账户',
  `notice_read` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'N' COMMENT '通知状态',
  PRIMARY KEY (`notice_num`) USING BTREE,
  INDEX `man_not`(`manager_id`) USING BTREE,
  CONSTRAINT `man_not` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`manager_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '通知信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for priority
-- ----------------------------
DROP TABLE IF EXISTS `priority`;
CREATE TABLE `priority`  (
  `priority_level` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'p0' COMMENT '优先级等级',
  PRIMARY KEY (`priority_level`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '优先级信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teamwork_group
-- ----------------------------
DROP TABLE IF EXISTS `teamwork_group`;
CREATE TABLE `teamwork_group`  (
  `group_create_time` date NOT NULL COMMENT '讨论组创建时间',
  `creator` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '讨论组创建者ID',
  `group_num` int(3) NOT NULL AUTO_INCREMENT COMMENT '讨论组ID',
  `group_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '讨论组' COMMENT '讨论组名称',
  PRIMARY KEY (`group_num`) USING BTREE,
  INDEX `user_group`(`creator`) USING BTREE,
  INDEX `group_name`(`group_name`) USING BTREE,
  CONSTRAINT `user_group` FOREIGN KEY (`creator`) REFERENCES `user` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '团队协作讨论组信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teamwork_member
-- ----------------------------
DROP TABLE IF EXISTS `teamwork_member`;
CREATE TABLE `teamwork_member`  (
  `group_num` int(3) NOT NULL COMMENT '讨论组ID',
  `group_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '讨论组名称',
  `member_num` int(4) NOT NULL AUTO_INCREMENT COMMENT '成员代号',
  `group_member` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '讨论组成员',
  `member_role` varchar(7) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'member' COMMENT '成员角色',
  `member_permission` varchar(5) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'view' COMMENT '成员权限',
  PRIMARY KEY (`member_num`) USING BTREE,
  INDEX `user_member`(`group_member`) USING BTREE,
  INDEX `group_member`(`group_num`) USING BTREE,
  INDEX `group_member_name`(`group_name`) USING BTREE,
  CONSTRAINT `group_member` FOREIGN KEY (`group_num`) REFERENCES `teamwork_group` (`group_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_member` FOREIGN KEY (`group_member`) REFERENCES `user` (`user_email`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '团队协作讨论组成员信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teamwork_message
-- ----------------------------
DROP TABLE IF EXISTS `teamwork_message`;
CREATE TABLE `teamwork_message`  (
  `group_num` int(3) NOT NULL COMMENT '讨论组ID',
  `mess_num` int(6) NOT NULL AUTO_INCREMENT COMMENT '消息编号',
  `mess_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '消息发起时间',
  `mess_initiator` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '消息发起者',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '消息内容',
  PRIMARY KEY (`mess_num`) USING BTREE,
  INDEX `group_message`(`group_num`) USING BTREE,
  INDEX `user_message`(`mess_initiator`) USING BTREE,
  CONSTRAINT `group_message` FOREIGN KEY (`group_num`) REFERENCES `teamwork_group` (`group_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_message` FOREIGN KEY (`mess_initiator`) REFERENCES `user` (`user_email`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '团队协作消息信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teamwork_schedule
-- ----------------------------
DROP TABLE IF EXISTS `teamwork_schedule`;
CREATE TABLE `teamwork_schedule`  (
  `group_num` int(5) NOT NULL COMMENT '讨论组ID',
  `sch_create_time` date DEFAULT NULL COMMENT '日程表创建时间',
  `sch_num` int(2) NOT NULL AUTO_INCREMENT COMMENT '日程表序号',
  `sch_content` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '日程表内容',
  `sch_time` date NOT NULL COMMENT '日程表时间',
  PRIMARY KEY (`sch_num`) USING BTREE,
  INDEX `group_num`(`group_num`) USING BTREE,
  CONSTRAINT `group_schedule` FOREIGN KEY (`group_num`) REFERENCES `teamwork_group` (`group_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '团队协作日程表信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teamwork_task
-- ----------------------------
DROP TABLE IF EXISTS `teamwork_task`;
CREATE TABLE `teamwork_task`  (
  `group_num` int(5) NOT NULL COMMENT '讨论组ID',
  `task_create_time` date NOT NULL COMMENT '任务创建时间',
  `task_num` int(4) NOT NULL AUTO_INCREMENT COMMENT '任务序号',
  `task_content` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '任务内容',
  `task_trustee` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '任务受托人',
  `task_finished_time` datetime(0) DEFAULT NULL COMMENT '任务完成时间',
  `task_finished` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'N' COMMENT '是否已完成',
  `task_expired` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'N' COMMENT '是否已过期',
  PRIMARY KEY (`task_num`) USING BTREE,
  INDEX `group_task`(`group_num`) USING BTREE,
  INDEX `user_task`(`task_trustee`) USING BTREE,
  CONSTRAINT `group_task` FOREIGN KEY (`group_num`) REFERENCES `teamwork_group` (`group_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_task` FOREIGN KEY (`task_trustee`) REFERENCES `user` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '团队协作任务分配信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for todo
-- ----------------------------
DROP TABLE IF EXISTS `todo`;
CREATE TABLE `todo`  (
  `user_email` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '个人用户邮箱地址',
  `todo_create_time` date DEFAULT '2018-05-22' COMMENT '待办事项创建时间',
  `todo_num` int(5) NOT NULL AUTO_INCREMENT COMMENT '待办事项序号',
  `todo_content` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '待办事项内容',
  `todo_reminder_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '待办事项提醒时间（年月时分）',
  `inv_title` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '无' COMMENT '待办事项清单归属',
  `filter_content` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '无' COMMENT '待办事项过滤器归属',
  `priority_level` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'p0' COMMENT '待办事项优先级',
  `todo_finished_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '待办事项完成时间',
  `todo_finished` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'N' COMMENT '是否已完成',
  `todo_expired` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'N' COMMENT '是否已过期',
  PRIMARY KEY (`todo_num`) USING BTREE,
  INDEX `user_todo`(`user_email`) USING BTREE,
  INDEX `prio_todo`(`priority_level`) USING BTREE,
  INDEX `inv_todo`(`inv_title`) USING BTREE,
  INDEX `fil_todo`(`filter_content`) USING BTREE,
  CONSTRAINT `fil_todo` FOREIGN KEY (`filter_content`) REFERENCES `filter` (`filter_content`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `inv_todo` FOREIGN KEY (`inv_title`) REFERENCES `inventory` (`inv_title`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `prio_todo` FOREIGN KEY (`priority_level`) REFERENCES `priority` (`priority_level`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `user_todo` FOREIGN KEY (`user_email`) REFERENCES `user` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 81 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '待办事项信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_create_time` date NOT NULL COMMENT '个人用户账号创建时间',
  `user_email` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '个人用户邮箱地址',
  `user_psw` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '个人用户密码',
  `user_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '个人用户手机号码',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '个人用户昵称',
  `user_avatar_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'http://image.evget.com/images/article/2016/Javascriptky-3.png' COMMENT '个人用户头像存储路径\r\n',
  PRIMARY KEY (`user_email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '个人用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_setting
-- ----------------------------
DROP TABLE IF EXISTS `user_setting`;
CREATE TABLE `user_setting`  (
  `user_email` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '个人用户邮箱地址',
  `last_change_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更改时间',
  `language` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '中文' COMMENT '系统语言',
  `strating_page` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '无' COMMENT '系统起始页',
  `date_recognise` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '是的，我需要' COMMENT '日期识别',
  `invite` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '是的，我需要' COMMENT '自动邀请',
  `date_format` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '24小时制' COMMENT '时间格式',
  `website_notice` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '是的，我需要' COMMENT '网页通知',
  `notice_rule` varchar(6) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '当天' COMMENT '提醒规则',
  PRIMARY KEY (`last_change_time`) USING BTREE,
  INDEX `user_setting`(`user_email`) USING BTREE,
  CONSTRAINT `user_setting` FOREIGN KEY (`user_email`) REFERENCES `user` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户个人设置信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Event structure for set_expired
-- ----------------------------
DROP EVENT IF EXISTS `set_expired`;
delimiter ;;
CREATE DEFINER = `ZeroYip`@`localhost` EVENT `set_expired`
ON SCHEDULE
EVERY '1' DAY STARTS '2018-05-17 00:00:00'
DO BEGIN
  UPDATE todo 
  SET todo_expired = 'Y'
  WHERE Date(todo_reminder_time) = Date(now());
	UPDATE teamwork_task 
  SET task_expired = 'Y'
  WHERE Date(todo_reminder_time) = Date(now());
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
