package com.zeroyip.zero.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeamworkTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeamworkTaskExample() {
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

        public Criteria andTaskNumIsNull() {
            addCriterion("task_num is null");
            return (Criteria) this;
        }

        public Criteria andTaskNumIsNotNull() {
            addCriterion("task_num is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNumEqualTo(Integer value) {
            addCriterion("task_num =", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumNotEqualTo(Integer value) {
            addCriterion("task_num <>", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumGreaterThan(Integer value) {
            addCriterion("task_num >", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_num >=", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumLessThan(Integer value) {
            addCriterion("task_num <", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumLessThanOrEqualTo(Integer value) {
            addCriterion("task_num <=", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumIn(List<Integer> values) {
            addCriterion("task_num in", values, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumNotIn(List<Integer> values) {
            addCriterion("task_num not in", values, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumBetween(Integer value1, Integer value2) {
            addCriterion("task_num between", value1, value2, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumNotBetween(Integer value1, Integer value2) {
            addCriterion("task_num not between", value1, value2, "taskNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumIsNull() {
            addCriterion("group_num is null");
            return (Criteria) this;
        }

        public Criteria andGroupNumIsNotNull() {
            addCriterion("group_num is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNumEqualTo(Integer value) {
            addCriterion("group_num =", value, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumNotEqualTo(Integer value) {
            addCriterion("group_num <>", value, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumGreaterThan(Integer value) {
            addCriterion("group_num >", value, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_num >=", value, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumLessThan(Integer value) {
            addCriterion("group_num <", value, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumLessThanOrEqualTo(Integer value) {
            addCriterion("group_num <=", value, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumIn(List<Integer> values) {
            addCriterion("group_num in", values, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumNotIn(List<Integer> values) {
            addCriterion("group_num not in", values, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumBetween(Integer value1, Integer value2) {
            addCriterion("group_num between", value1, value2, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumNotBetween(Integer value1, Integer value2) {
            addCriterion("group_num not between", value1, value2, "groupNum");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeIsNull() {
            addCriterion("task_create_time is null");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeIsNotNull() {
            addCriterion("task_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeEqualTo(Date value) {
            addCriterion("task_create_time =", value, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeNotEqualTo(Date value) {
            addCriterion("task_create_time <>", value, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeGreaterThan(Date value) {
            addCriterion("task_create_time >", value, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_create_time >=", value, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeLessThan(Date value) {
            addCriterion("task_create_time <", value, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("task_create_time <=", value, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeIn(List<Date> values) {
            addCriterion("task_create_time in", values, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeNotIn(List<Date> values) {
            addCriterion("task_create_time not in", values, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeBetween(Date value1, Date value2) {
            addCriterion("task_create_time between", value1, value2, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("task_create_time not between", value1, value2, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNull() {
            addCriterion("task_content is null");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNotNull() {
            addCriterion("task_content is not null");
            return (Criteria) this;
        }

        public Criteria andTaskContentEqualTo(String value) {
            addCriterion("task_content =", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotEqualTo(String value) {
            addCriterion("task_content <>", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThan(String value) {
            addCriterion("task_content >", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThanOrEqualTo(String value) {
            addCriterion("task_content >=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThan(String value) {
            addCriterion("task_content <", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThanOrEqualTo(String value) {
            addCriterion("task_content <=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLike(String value) {
            addCriterion("task_content like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotLike(String value) {
            addCriterion("task_content not like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentIn(List<String> values) {
            addCriterion("task_content in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotIn(List<String> values) {
            addCriterion("task_content not in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentBetween(String value1, String value2) {
            addCriterion("task_content between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotBetween(String value1, String value2) {
            addCriterion("task_content not between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskTrusteeIsNull() {
            addCriterion("task_trustee is null");
            return (Criteria) this;
        }

        public Criteria andTaskTrusteeIsNotNull() {
            addCriterion("task_trustee is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTrusteeEqualTo(String value) {
            addCriterion("task_trustee =", value, "taskTrustee");
            return (Criteria) this;
        }

        public Criteria andTaskTrusteeNotEqualTo(String value) {
            addCriterion("task_trustee <>", value, "taskTrustee");
            return (Criteria) this;
        }

        public Criteria andTaskTrusteeGreaterThan(String value) {
            addCriterion("task_trustee >", value, "taskTrustee");
            return (Criteria) this;
        }

        public Criteria andTaskTrusteeGreaterThanOrEqualTo(String value) {
            addCriterion("task_trustee >=", value, "taskTrustee");
            return (Criteria) this;
        }

        public Criteria andTaskTrusteeLessThan(String value) {
            addCriterion("task_trustee <", value, "taskTrustee");
            return (Criteria) this;
        }

        public Criteria andTaskTrusteeLessThanOrEqualTo(String value) {
            addCriterion("task_trustee <=", value, "taskTrustee");
            return (Criteria) this;
        }

        public Criteria andTaskTrusteeLike(String value) {
            addCriterion("task_trustee like", value, "taskTrustee");
            return (Criteria) this;
        }

        public Criteria andTaskTrusteeNotLike(String value) {
            addCriterion("task_trustee not like", value, "taskTrustee");
            return (Criteria) this;
        }

        public Criteria andTaskTrusteeIn(List<String> values) {
            addCriterion("task_trustee in", values, "taskTrustee");
            return (Criteria) this;
        }

        public Criteria andTaskTrusteeNotIn(List<String> values) {
            addCriterion("task_trustee not in", values, "taskTrustee");
            return (Criteria) this;
        }

        public Criteria andTaskTrusteeBetween(String value1, String value2) {
            addCriterion("task_trustee between", value1, value2, "taskTrustee");
            return (Criteria) this;
        }

        public Criteria andTaskTrusteeNotBetween(String value1, String value2) {
            addCriterion("task_trustee not between", value1, value2, "taskTrustee");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedTimeIsNull() {
            addCriterion("task_finished_time is null");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedTimeIsNotNull() {
            addCriterion("task_finished_time is not null");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedTimeEqualTo(Date value) {
            addCriterion("task_finished_time =", value, "taskFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedTimeNotEqualTo(Date value) {
            addCriterion("task_finished_time <>", value, "taskFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedTimeGreaterThan(Date value) {
            addCriterion("task_finished_time >", value, "taskFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_finished_time >=", value, "taskFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedTimeLessThan(Date value) {
            addCriterion("task_finished_time <", value, "taskFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedTimeLessThanOrEqualTo(Date value) {
            addCriterion("task_finished_time <=", value, "taskFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedTimeIn(List<Date> values) {
            addCriterion("task_finished_time in", values, "taskFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedTimeNotIn(List<Date> values) {
            addCriterion("task_finished_time not in", values, "taskFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedTimeBetween(Date value1, Date value2) {
            addCriterion("task_finished_time between", value1, value2, "taskFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedTimeNotBetween(Date value1, Date value2) {
            addCriterion("task_finished_time not between", value1, value2, "taskFinishedTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedIsNull() {
            addCriterion("task_finished is null");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedIsNotNull() {
            addCriterion("task_finished is not null");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedEqualTo(String value) {
            addCriterion("task_finished =", value, "taskFinished");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedNotEqualTo(String value) {
            addCriterion("task_finished <>", value, "taskFinished");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedGreaterThan(String value) {
            addCriterion("task_finished >", value, "taskFinished");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedGreaterThanOrEqualTo(String value) {
            addCriterion("task_finished >=", value, "taskFinished");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedLessThan(String value) {
            addCriterion("task_finished <", value, "taskFinished");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedLessThanOrEqualTo(String value) {
            addCriterion("task_finished <=", value, "taskFinished");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedLike(String value) {
            addCriterion("task_finished like", value, "taskFinished");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedNotLike(String value) {
            addCriterion("task_finished not like", value, "taskFinished");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedIn(List<String> values) {
            addCriterion("task_finished in", values, "taskFinished");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedNotIn(List<String> values) {
            addCriterion("task_finished not in", values, "taskFinished");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedBetween(String value1, String value2) {
            addCriterion("task_finished between", value1, value2, "taskFinished");
            return (Criteria) this;
        }

        public Criteria andTaskFinishedNotBetween(String value1, String value2) {
            addCriterion("task_finished not between", value1, value2, "taskFinished");
            return (Criteria) this;
        }

        public Criteria andTaskExpiredIsNull() {
            addCriterion("task_expired is null");
            return (Criteria) this;
        }

        public Criteria andTaskExpiredIsNotNull() {
            addCriterion("task_expired is not null");
            return (Criteria) this;
        }

        public Criteria andTaskExpiredEqualTo(String value) {
            addCriterion("task_expired =", value, "taskExpired");
            return (Criteria) this;
        }

        public Criteria andTaskExpiredNotEqualTo(String value) {
            addCriterion("task_expired <>", value, "taskExpired");
            return (Criteria) this;
        }

        public Criteria andTaskExpiredGreaterThan(String value) {
            addCriterion("task_expired >", value, "taskExpired");
            return (Criteria) this;
        }

        public Criteria andTaskExpiredGreaterThanOrEqualTo(String value) {
            addCriterion("task_expired >=", value, "taskExpired");
            return (Criteria) this;
        }

        public Criteria andTaskExpiredLessThan(String value) {
            addCriterion("task_expired <", value, "taskExpired");
            return (Criteria) this;
        }

        public Criteria andTaskExpiredLessThanOrEqualTo(String value) {
            addCriterion("task_expired <=", value, "taskExpired");
            return (Criteria) this;
        }

        public Criteria andTaskExpiredLike(String value) {
            addCriterion("task_expired like", value, "taskExpired");
            return (Criteria) this;
        }

        public Criteria andTaskExpiredNotLike(String value) {
            addCriterion("task_expired not like", value, "taskExpired");
            return (Criteria) this;
        }

        public Criteria andTaskExpiredIn(List<String> values) {
            addCriterion("task_expired in", values, "taskExpired");
            return (Criteria) this;
        }

        public Criteria andTaskExpiredNotIn(List<String> values) {
            addCriterion("task_expired not in", values, "taskExpired");
            return (Criteria) this;
        }

        public Criteria andTaskExpiredBetween(String value1, String value2) {
            addCriterion("task_expired between", value1, value2, "taskExpired");
            return (Criteria) this;
        }

        public Criteria andTaskExpiredNotBetween(String value1, String value2) {
            addCriterion("task_expired not between", value1, value2, "taskExpired");
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