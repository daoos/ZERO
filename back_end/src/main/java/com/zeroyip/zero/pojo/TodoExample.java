package com.zeroyip.zero.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TodoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TodoExample() {
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

        public Criteria andTodoNumIsNull() {
            addCriterion("todo_num is null");
            return (Criteria) this;
        }

        public Criteria andTodoNumIsNotNull() {
            addCriterion("todo_num is not null");
            return (Criteria) this;
        }

        public Criteria andTodoNumEqualTo(Integer value) {
            addCriterion("todo_num =", value, "todoNum");
            return (Criteria) this;
        }

        public Criteria andTodoNumNotEqualTo(Integer value) {
            addCriterion("todo_num <>", value, "todoNum");
            return (Criteria) this;
        }

        public Criteria andTodoNumGreaterThan(Integer value) {
            addCriterion("todo_num >", value, "todoNum");
            return (Criteria) this;
        }

        public Criteria andTodoNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("todo_num >=", value, "todoNum");
            return (Criteria) this;
        }

        public Criteria andTodoNumLessThan(Integer value) {
            addCriterion("todo_num <", value, "todoNum");
            return (Criteria) this;
        }

        public Criteria andTodoNumLessThanOrEqualTo(Integer value) {
            addCriterion("todo_num <=", value, "todoNum");
            return (Criteria) this;
        }

        public Criteria andTodoNumIn(List<Integer> values) {
            addCriterion("todo_num in", values, "todoNum");
            return (Criteria) this;
        }

        public Criteria andTodoNumNotIn(List<Integer> values) {
            addCriterion("todo_num not in", values, "todoNum");
            return (Criteria) this;
        }

        public Criteria andTodoNumBetween(Integer value1, Integer value2) {
            addCriterion("todo_num between", value1, value2, "todoNum");
            return (Criteria) this;
        }

        public Criteria andTodoNumNotBetween(Integer value1, Integer value2) {
            addCriterion("todo_num not between", value1, value2, "todoNum");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("user_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("user_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("user_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("user_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("user_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("user_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("user_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("user_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("user_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("user_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("user_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("user_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("user_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andTodoCreateTimeIsNull() {
            addCriterion("todo_create_time is null");
            return (Criteria) this;
        }

        public Criteria andTodoCreateTimeIsNotNull() {
            addCriterion("todo_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andTodoCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("todo_create_time =", value, "todoCreateTime");
            return (Criteria) this;
        }

        public Criteria andTodoCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("todo_create_time <>", value, "todoCreateTime");
            return (Criteria) this;
        }

        public Criteria andTodoCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("todo_create_time >", value, "todoCreateTime");
            return (Criteria) this;
        }

        public Criteria andTodoCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("todo_create_time >=", value, "todoCreateTime");
            return (Criteria) this;
        }

        public Criteria andTodoCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("todo_create_time <", value, "todoCreateTime");
            return (Criteria) this;
        }

        public Criteria andTodoCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("todo_create_time <=", value, "todoCreateTime");
            return (Criteria) this;
        }

        public Criteria andTodoCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("todo_create_time in", values, "todoCreateTime");
            return (Criteria) this;
        }

        public Criteria andTodoCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("todo_create_time not in", values, "todoCreateTime");
            return (Criteria) this;
        }

        public Criteria andTodoCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("todo_create_time between", value1, value2, "todoCreateTime");
            return (Criteria) this;
        }

        public Criteria andTodoCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("todo_create_time not between", value1, value2, "todoCreateTime");
            return (Criteria) this;
        }

        public Criteria andTodoContentIsNull() {
            addCriterion("todo_content is null");
            return (Criteria) this;
        }

        public Criteria andTodoContentIsNotNull() {
            addCriterion("todo_content is not null");
            return (Criteria) this;
        }

        public Criteria andTodoContentEqualTo(String value) {
            addCriterion("todo_content =", value, "todoContent");
            return (Criteria) this;
        }

        public Criteria andTodoContentNotEqualTo(String value) {
            addCriterion("todo_content <>", value, "todoContent");
            return (Criteria) this;
        }

        public Criteria andTodoContentGreaterThan(String value) {
            addCriterion("todo_content >", value, "todoContent");
            return (Criteria) this;
        }

        public Criteria andTodoContentGreaterThanOrEqualTo(String value) {
            addCriterion("todo_content >=", value, "todoContent");
            return (Criteria) this;
        }

        public Criteria andTodoContentLessThan(String value) {
            addCriterion("todo_content <", value, "todoContent");
            return (Criteria) this;
        }

        public Criteria andTodoContentLessThanOrEqualTo(String value) {
            addCriterion("todo_content <=", value, "todoContent");
            return (Criteria) this;
        }

        public Criteria andTodoContentLike(String value) {
            addCriterion("todo_content like", value, "todoContent");
            return (Criteria) this;
        }

        public Criteria andTodoContentNotLike(String value) {
            addCriterion("todo_content not like", value, "todoContent");
            return (Criteria) this;
        }

        public Criteria andTodoContentIn(List<String> values) {
            addCriterion("todo_content in", values, "todoContent");
            return (Criteria) this;
        }

        public Criteria andTodoContentNotIn(List<String> values) {
            addCriterion("todo_content not in", values, "todoContent");
            return (Criteria) this;
        }

        public Criteria andTodoContentBetween(String value1, String value2) {
            addCriterion("todo_content between", value1, value2, "todoContent");
            return (Criteria) this;
        }

        public Criteria andTodoContentNotBetween(String value1, String value2) {
            addCriterion("todo_content not between", value1, value2, "todoContent");
            return (Criteria) this;
        }

        public Criteria andTodoReminderTimeIsNull() {
            addCriterion("todo_reminder_time is null");
            return (Criteria) this;
        }

        public Criteria andTodoReminderTimeIsNotNull() {
            addCriterion("todo_reminder_time is not null");
            return (Criteria) this;
        }

        public Criteria andTodoReminderTimeEqualTo(Date value) {
            addCriterion("todo_reminder_time =", value, "todoReminderTime");
            return (Criteria) this;
        }

        public Criteria andTodoReminderTimeNotEqualTo(Date value) {
            addCriterion("todo_reminder_time <>", value, "todoReminderTime");
            return (Criteria) this;
        }

        public Criteria andTodoReminderTimeGreaterThan(Date value) {
            addCriterion("todo_reminder_time >", value, "todoReminderTime");
            return (Criteria) this;
        }

        public Criteria andTodoReminderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("todo_reminder_time >=", value, "todoReminderTime");
            return (Criteria) this;
        }

        public Criteria andTodoReminderTimeLessThan(Date value) {
            addCriterion("todo_reminder_time <", value, "todoReminderTime");
            return (Criteria) this;
        }

        public Criteria andTodoReminderTimeLessThanOrEqualTo(Date value) {
            addCriterion("todo_reminder_time <=", value, "todoReminderTime");
            return (Criteria) this;
        }

        public Criteria andTodoReminderTimeIn(List<Date> values) {
            addCriterion("todo_reminder_time in", values, "todoReminderTime");
            return (Criteria) this;
        }

        public Criteria andTodoReminderTimeNotIn(List<Date> values) {
            addCriterion("todo_reminder_time not in", values, "todoReminderTime");
            return (Criteria) this;
        }

        public Criteria andTodoReminderTimeBetween(Date value1, Date value2) {
            addCriterion("todo_reminder_time between", value1, value2, "todoReminderTime");
            return (Criteria) this;
        }

        public Criteria andTodoReminderTimeNotBetween(Date value1, Date value2) {
            addCriterion("todo_reminder_time not between", value1, value2, "todoReminderTime");
            return (Criteria) this;
        }

        public Criteria andInvTitleIsNull() {
            addCriterion("inv_title is null");
            return (Criteria) this;
        }

        public Criteria andInvTitleIsNotNull() {
            addCriterion("inv_title is not null");
            return (Criteria) this;
        }

        public Criteria andInvTitleEqualTo(String value) {
            addCriterion("inv_title =", value, "invTitle");
            return (Criteria) this;
        }

        public Criteria andInvTitleNotEqualTo(String value) {
            addCriterion("inv_title <>", value, "invTitle");
            return (Criteria) this;
        }

        public Criteria andInvTitleGreaterThan(String value) {
            addCriterion("inv_title >", value, "invTitle");
            return (Criteria) this;
        }

        public Criteria andInvTitleGreaterThanOrEqualTo(String value) {
            addCriterion("inv_title >=", value, "invTitle");
            return (Criteria) this;
        }

        public Criteria andInvTitleLessThan(String value) {
            addCriterion("inv_title <", value, "invTitle");
            return (Criteria) this;
        }

        public Criteria andInvTitleLessThanOrEqualTo(String value) {
            addCriterion("inv_title <=", value, "invTitle");
            return (Criteria) this;
        }

        public Criteria andInvTitleLike(String value) {
            addCriterion("inv_title like", value, "invTitle");
            return (Criteria) this;
        }

        public Criteria andInvTitleNotLike(String value) {
            addCriterion("inv_title not like", value, "invTitle");
            return (Criteria) this;
        }

        public Criteria andInvTitleIn(List<String> values) {
            addCriterion("inv_title in", values, "invTitle");
            return (Criteria) this;
        }

        public Criteria andInvTitleNotIn(List<String> values) {
            addCriterion("inv_title not in", values, "invTitle");
            return (Criteria) this;
        }

        public Criteria andInvTitleBetween(String value1, String value2) {
            addCriterion("inv_title between", value1, value2, "invTitle");
            return (Criteria) this;
        }

        public Criteria andInvTitleNotBetween(String value1, String value2) {
            addCriterion("inv_title not between", value1, value2, "invTitle");
            return (Criteria) this;
        }

        public Criteria andFilterContentIsNull() {
            addCriterion("filter_content is null");
            return (Criteria) this;
        }

        public Criteria andFilterContentIsNotNull() {
            addCriterion("filter_content is not null");
            return (Criteria) this;
        }

        public Criteria andFilterContentEqualTo(String value) {
            addCriterion("filter_content =", value, "filterContent");
            return (Criteria) this;
        }

        public Criteria andFilterContentNotEqualTo(String value) {
            addCriterion("filter_content <>", value, "filterContent");
            return (Criteria) this;
        }

        public Criteria andFilterContentGreaterThan(String value) {
            addCriterion("filter_content >", value, "filterContent");
            return (Criteria) this;
        }

        public Criteria andFilterContentGreaterThanOrEqualTo(String value) {
            addCriterion("filter_content >=", value, "filterContent");
            return (Criteria) this;
        }

        public Criteria andFilterContentLessThan(String value) {
            addCriterion("filter_content <", value, "filterContent");
            return (Criteria) this;
        }

        public Criteria andFilterContentLessThanOrEqualTo(String value) {
            addCriterion("filter_content <=", value, "filterContent");
            return (Criteria) this;
        }

        public Criteria andFilterContentLike(String value) {
            addCriterion("filter_content like", value, "filterContent");
            return (Criteria) this;
        }

        public Criteria andFilterContentNotLike(String value) {
            addCriterion("filter_content not like", value, "filterContent");
            return (Criteria) this;
        }

        public Criteria andFilterContentIn(List<String> values) {
            addCriterion("filter_content in", values, "filterContent");
            return (Criteria) this;
        }

        public Criteria andFilterContentNotIn(List<String> values) {
            addCriterion("filter_content not in", values, "filterContent");
            return (Criteria) this;
        }

        public Criteria andFilterContentBetween(String value1, String value2) {
            addCriterion("filter_content between", value1, value2, "filterContent");
            return (Criteria) this;
        }

        public Criteria andFilterContentNotBetween(String value1, String value2) {
            addCriterion("filter_content not between", value1, value2, "filterContent");
            return (Criteria) this;
        }

        public Criteria andPriorityLevelIsNull() {
            addCriterion("priority_level is null");
            return (Criteria) this;
        }

        public Criteria andPriorityLevelIsNotNull() {
            addCriterion("priority_level is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityLevelEqualTo(String value) {
            addCriterion("priority_level =", value, "priorityLevel");
            return (Criteria) this;
        }

        public Criteria andPriorityLevelNotEqualTo(String value) {
            addCriterion("priority_level <>", value, "priorityLevel");
            return (Criteria) this;
        }

        public Criteria andPriorityLevelGreaterThan(String value) {
            addCriterion("priority_level >", value, "priorityLevel");
            return (Criteria) this;
        }

        public Criteria andPriorityLevelGreaterThanOrEqualTo(String value) {
            addCriterion("priority_level >=", value, "priorityLevel");
            return (Criteria) this;
        }

        public Criteria andPriorityLevelLessThan(String value) {
            addCriterion("priority_level <", value, "priorityLevel");
            return (Criteria) this;
        }

        public Criteria andPriorityLevelLessThanOrEqualTo(String value) {
            addCriterion("priority_level <=", value, "priorityLevel");
            return (Criteria) this;
        }

        public Criteria andPriorityLevelLike(String value) {
            addCriterion("priority_level like", value, "priorityLevel");
            return (Criteria) this;
        }

        public Criteria andPriorityLevelNotLike(String value) {
            addCriterion("priority_level not like", value, "priorityLevel");
            return (Criteria) this;
        }

        public Criteria andPriorityLevelIn(List<String> values) {
            addCriterion("priority_level in", values, "priorityLevel");
            return (Criteria) this;
        }

        public Criteria andPriorityLevelNotIn(List<String> values) {
            addCriterion("priority_level not in", values, "priorityLevel");
            return (Criteria) this;
        }

        public Criteria andPriorityLevelBetween(String value1, String value2) {
            addCriterion("priority_level between", value1, value2, "priorityLevel");
            return (Criteria) this;
        }

        public Criteria andPriorityLevelNotBetween(String value1, String value2) {
            addCriterion("priority_level not between", value1, value2, "priorityLevel");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedTimeIsNull() {
            addCriterion("todo_finished_time is null");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedTimeIsNotNull() {
            addCriterion("todo_finished_time is not null");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedTimeEqualTo(Date value) {
            addCriterion("todo_finished_time =", value, "todoFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedTimeNotEqualTo(Date value) {
            addCriterion("todo_finished_time <>", value, "todoFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedTimeGreaterThan(Date value) {
            addCriterion("todo_finished_time >", value, "todoFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("todo_finished_time >=", value, "todoFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedTimeLessThan(Date value) {
            addCriterion("todo_finished_time <", value, "todoFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedTimeLessThanOrEqualTo(Date value) {
            addCriterion("todo_finished_time <=", value, "todoFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedTimeIn(List<Date> values) {
            addCriterion("todo_finished_time in", values, "todoFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedTimeNotIn(List<Date> values) {
            addCriterion("todo_finished_time not in", values, "todoFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedTimeBetween(Date value1, Date value2) {
            addCriterion("todo_finished_time between", value1, value2, "todoFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedTimeNotBetween(Date value1, Date value2) {
            addCriterion("todo_finished_time not between", value1, value2, "todoFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedIsNull() {
            addCriterion("todo_finished is null");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedIsNotNull() {
            addCriterion("todo_finished is not null");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedEqualTo(String value) {
            addCriterion("todo_finished =", value, "todoFinished");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedNotEqualTo(String value) {
            addCriterion("todo_finished <>", value, "todoFinished");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedGreaterThan(String value) {
            addCriterion("todo_finished >", value, "todoFinished");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedGreaterThanOrEqualTo(String value) {
            addCriterion("todo_finished >=", value, "todoFinished");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedLessThan(String value) {
            addCriterion("todo_finished <", value, "todoFinished");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedLessThanOrEqualTo(String value) {
            addCriterion("todo_finished <=", value, "todoFinished");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedLike(String value) {
            addCriterion("todo_finished like", value, "todoFinished");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedNotLike(String value) {
            addCriterion("todo_finished not like", value, "todoFinished");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedIn(List<String> values) {
            addCriterion("todo_finished in", values, "todoFinished");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedNotIn(List<String> values) {
            addCriterion("todo_finished not in", values, "todoFinished");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedBetween(String value1, String value2) {
            addCriterion("todo_finished between", value1, value2, "todoFinished");
            return (Criteria) this;
        }

        public Criteria andTodoFinishedNotBetween(String value1, String value2) {
            addCriterion("todo_finished not between", value1, value2, "todoFinished");
            return (Criteria) this;
        }

        public Criteria andTodoExpiredIsNull() {
            addCriterion("todo_expired is null");
            return (Criteria) this;
        }

        public Criteria andTodoExpiredIsNotNull() {
            addCriterion("todo_expired is not null");
            return (Criteria) this;
        }

        public Criteria andTodoExpiredEqualTo(String value) {
            addCriterion("todo_expired =", value, "todoExpired");
            return (Criteria) this;
        }

        public Criteria andTodoExpiredNotEqualTo(String value) {
            addCriterion("todo_expired <>", value, "todoExpired");
            return (Criteria) this;
        }

        public Criteria andTodoExpiredGreaterThan(String value) {
            addCriterion("todo_expired >", value, "todoExpired");
            return (Criteria) this;
        }

        public Criteria andTodoExpiredGreaterThanOrEqualTo(String value) {
            addCriterion("todo_expired >=", value, "todoExpired");
            return (Criteria) this;
        }

        public Criteria andTodoExpiredLessThan(String value) {
            addCriterion("todo_expired <", value, "todoExpired");
            return (Criteria) this;
        }

        public Criteria andTodoExpiredLessThanOrEqualTo(String value) {
            addCriterion("todo_expired <=", value, "todoExpired");
            return (Criteria) this;
        }

        public Criteria andTodoExpiredLike(String value) {
            addCriterion("todo_expired like", value, "todoExpired");
            return (Criteria) this;
        }

        public Criteria andTodoExpiredNotLike(String value) {
            addCriterion("todo_expired not like", value, "todoExpired");
            return (Criteria) this;
        }

        public Criteria andTodoExpiredIn(List<String> values) {
            addCriterion("todo_expired in", values, "todoExpired");
            return (Criteria) this;
        }

        public Criteria andTodoExpiredNotIn(List<String> values) {
            addCriterion("todo_expired not in", values, "todoExpired");
            return (Criteria) this;
        }

        public Criteria andTodoExpiredBetween(String value1, String value2) {
            addCriterion("todo_expired between", value1, value2, "todoExpired");
            return (Criteria) this;
        }

        public Criteria andTodoExpiredNotBetween(String value1, String value2) {
            addCriterion("todo_expired not between", value1, value2, "todoExpired");
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