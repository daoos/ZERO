package com.zeroyip.zero.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NotificationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NotificationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andNoticeNumIsNull() {
            addCriterion("notice_num is null");
            return (Criteria) this;
        }

        public Criteria andNoticeNumIsNotNull() {
            addCriterion("notice_num is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeNumEqualTo(Integer value) {
            addCriterion("notice_num =", value, "noticeNum");
            return (Criteria) this;
        }

        public Criteria andNoticeNumNotEqualTo(Integer value) {
            addCriterion("notice_num <>", value, "noticeNum");
            return (Criteria) this;
        }

        public Criteria andNoticeNumGreaterThan(Integer value) {
            addCriterion("notice_num >", value, "noticeNum");
            return (Criteria) this;
        }

        public Criteria andNoticeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("notice_num >=", value, "noticeNum");
            return (Criteria) this;
        }

        public Criteria andNoticeNumLessThan(Integer value) {
            addCriterion("notice_num <", value, "noticeNum");
            return (Criteria) this;
        }

        public Criteria andNoticeNumLessThanOrEqualTo(Integer value) {
            addCriterion("notice_num <=", value, "noticeNum");
            return (Criteria) this;
        }

        public Criteria andNoticeNumIn(List<Integer> values) {
            addCriterion("notice_num in", values, "noticeNum");
            return (Criteria) this;
        }

        public Criteria andNoticeNumNotIn(List<Integer> values) {
            addCriterion("notice_num not in", values, "noticeNum");
            return (Criteria) this;
        }

        public Criteria andNoticeNumBetween(Integer value1, Integer value2) {
            addCriterion("notice_num between", value1, value2, "noticeNum");
            return (Criteria) this;
        }

        public Criteria andNoticeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("notice_num not between", value1, value2, "noticeNum");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNull() {
            addCriterion("manager_id is null");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNotNull() {
            addCriterion("manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andManagerIdEqualTo(String value) {
            addCriterion("manager_id =", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotEqualTo(String value) {
            addCriterion("manager_id <>", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThan(String value) {
            addCriterion("manager_id >", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThanOrEqualTo(String value) {
            addCriterion("manager_id >=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThan(String value) {
            addCriterion("manager_id <", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThanOrEqualTo(String value) {
            addCriterion("manager_id <=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLike(String value) {
            addCriterion("manager_id like", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotLike(String value) {
            addCriterion("manager_id not like", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdIn(List<String> values) {
            addCriterion("manager_id in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotIn(List<String> values) {
            addCriterion("manager_id not in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdBetween(String value1, String value2) {
            addCriterion("manager_id between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotBetween(String value1, String value2) {
            addCriterion("manager_id not between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andNoticeSendTimeIsNull() {
            addCriterion("notice_send_time is null");
            return (Criteria) this;
        }

        public Criteria andNoticeSendTimeIsNotNull() {
            addCriterion("notice_send_time is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeSendTimeEqualTo(Date value) {
            addCriterionForJDBCDate("notice_send_time =", value, "noticeSendTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSendTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("notice_send_time <>", value, "noticeSendTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSendTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("notice_send_time >", value, "noticeSendTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("notice_send_time >=", value, "noticeSendTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSendTimeLessThan(Date value) {
            addCriterionForJDBCDate("notice_send_time <", value, "noticeSendTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSendTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("notice_send_time <=", value, "noticeSendTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSendTimeIn(List<Date> values) {
            addCriterionForJDBCDate("notice_send_time in", values, "noticeSendTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSendTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("notice_send_time not in", values, "noticeSendTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSendTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("notice_send_time between", value1, value2, "noticeSendTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSendTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("notice_send_time not between", value1, value2, "noticeSendTime");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleIsNull() {
            addCriterion("notice_title is null");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleIsNotNull() {
            addCriterion("notice_title is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleEqualTo(String value) {
            addCriterion("notice_title =", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotEqualTo(String value) {
            addCriterion("notice_title <>", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleGreaterThan(String value) {
            addCriterion("notice_title >", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleGreaterThanOrEqualTo(String value) {
            addCriterion("notice_title >=", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleLessThan(String value) {
            addCriterion("notice_title <", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleLessThanOrEqualTo(String value) {
            addCriterion("notice_title <=", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleLike(String value) {
            addCriterion("notice_title like", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotLike(String value) {
            addCriterion("notice_title not like", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleIn(List<String> values) {
            addCriterion("notice_title in", values, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotIn(List<String> values) {
            addCriterion("notice_title not in", values, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleBetween(String value1, String value2) {
            addCriterion("notice_title between", value1, value2, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotBetween(String value1, String value2) {
            addCriterion("notice_title not between", value1, value2, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeContentIsNull() {
            addCriterion("notice_content is null");
            return (Criteria) this;
        }

        public Criteria andNoticeContentIsNotNull() {
            addCriterion("notice_content is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeContentEqualTo(String value) {
            addCriterion("notice_content =", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotEqualTo(String value) {
            addCriterion("notice_content <>", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentGreaterThan(String value) {
            addCriterion("notice_content >", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentGreaterThanOrEqualTo(String value) {
            addCriterion("notice_content >=", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentLessThan(String value) {
            addCriterion("notice_content <", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentLessThanOrEqualTo(String value) {
            addCriterion("notice_content <=", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentLike(String value) {
            addCriterion("notice_content like", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotLike(String value) {
            addCriterion("notice_content not like", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentIn(List<String> values) {
            addCriterion("notice_content in", values, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotIn(List<String> values) {
            addCriterion("notice_content not in", values, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentBetween(String value1, String value2) {
            addCriterion("notice_content between", value1, value2, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotBetween(String value1, String value2) {
            addCriterion("notice_content not between", value1, value2, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverIsNull() {
            addCriterion("notice_receiver is null");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverIsNotNull() {
            addCriterion("notice_receiver is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverEqualTo(String value) {
            addCriterion("notice_receiver =", value, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverNotEqualTo(String value) {
            addCriterion("notice_receiver <>", value, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverGreaterThan(String value) {
            addCriterion("notice_receiver >", value, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("notice_receiver >=", value, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverLessThan(String value) {
            addCriterion("notice_receiver <", value, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverLessThanOrEqualTo(String value) {
            addCriterion("notice_receiver <=", value, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverLike(String value) {
            addCriterion("notice_receiver like", value, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverNotLike(String value) {
            addCriterion("notice_receiver not like", value, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverIn(List<String> values) {
            addCriterion("notice_receiver in", values, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverNotIn(List<String> values) {
            addCriterion("notice_receiver not in", values, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverBetween(String value1, String value2) {
            addCriterion("notice_receiver between", value1, value2, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverNotBetween(String value1, String value2) {
            addCriterion("notice_receiver not between", value1, value2, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReadIsNull() {
            addCriterion("notice_read is null");
            return (Criteria) this;
        }

        public Criteria andNoticeReadIsNotNull() {
            addCriterion("notice_read is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeReadEqualTo(String value) {
            addCriterion("notice_read =", value, "noticeRead");
            return (Criteria) this;
        }

        public Criteria andNoticeReadNotEqualTo(String value) {
            addCriterion("notice_read <>", value, "noticeRead");
            return (Criteria) this;
        }

        public Criteria andNoticeReadGreaterThan(String value) {
            addCriterion("notice_read >", value, "noticeRead");
            return (Criteria) this;
        }

        public Criteria andNoticeReadGreaterThanOrEqualTo(String value) {
            addCriterion("notice_read >=", value, "noticeRead");
            return (Criteria) this;
        }

        public Criteria andNoticeReadLessThan(String value) {
            addCriterion("notice_read <", value, "noticeRead");
            return (Criteria) this;
        }

        public Criteria andNoticeReadLessThanOrEqualTo(String value) {
            addCriterion("notice_read <=", value, "noticeRead");
            return (Criteria) this;
        }

        public Criteria andNoticeReadLike(String value) {
            addCriterion("notice_read like", value, "noticeRead");
            return (Criteria) this;
        }

        public Criteria andNoticeReadNotLike(String value) {
            addCriterion("notice_read not like", value, "noticeRead");
            return (Criteria) this;
        }

        public Criteria andNoticeReadIn(List<String> values) {
            addCriterion("notice_read in", values, "noticeRead");
            return (Criteria) this;
        }

        public Criteria andNoticeReadNotIn(List<String> values) {
            addCriterion("notice_read not in", values, "noticeRead");
            return (Criteria) this;
        }

        public Criteria andNoticeReadBetween(String value1, String value2) {
            addCriterion("notice_read between", value1, value2, "noticeRead");
            return (Criteria) this;
        }

        public Criteria andNoticeReadNotBetween(String value1, String value2) {
            addCriterion("notice_read not between", value1, value2, "noticeRead");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}