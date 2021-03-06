package com.zeroyip.zero.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeamworkMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeamworkMessageExample() {
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

        public Criteria andMessNumIsNull() {
            addCriterion("mess_num is null");
            return (Criteria) this;
        }

        public Criteria andMessNumIsNotNull() {
            addCriterion("mess_num is not null");
            return (Criteria) this;
        }

        public Criteria andMessNumEqualTo(Integer value) {
            addCriterion("mess_num =", value, "messNum");
            return (Criteria) this;
        }

        public Criteria andMessNumNotEqualTo(Integer value) {
            addCriterion("mess_num <>", value, "messNum");
            return (Criteria) this;
        }

        public Criteria andMessNumGreaterThan(Integer value) {
            addCriterion("mess_num >", value, "messNum");
            return (Criteria) this;
        }

        public Criteria andMessNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("mess_num >=", value, "messNum");
            return (Criteria) this;
        }

        public Criteria andMessNumLessThan(Integer value) {
            addCriterion("mess_num <", value, "messNum");
            return (Criteria) this;
        }

        public Criteria andMessNumLessThanOrEqualTo(Integer value) {
            addCriterion("mess_num <=", value, "messNum");
            return (Criteria) this;
        }

        public Criteria andMessNumIn(List<Integer> values) {
            addCriterion("mess_num in", values, "messNum");
            return (Criteria) this;
        }

        public Criteria andMessNumNotIn(List<Integer> values) {
            addCriterion("mess_num not in", values, "messNum");
            return (Criteria) this;
        }

        public Criteria andMessNumBetween(Integer value1, Integer value2) {
            addCriterion("mess_num between", value1, value2, "messNum");
            return (Criteria) this;
        }

        public Criteria andMessNumNotBetween(Integer value1, Integer value2) {
            addCriterion("mess_num not between", value1, value2, "messNum");
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

        public Criteria andMessTimeIsNull() {
            addCriterion("mess_time is null");
            return (Criteria) this;
        }

        public Criteria andMessTimeIsNotNull() {
            addCriterion("mess_time is not null");
            return (Criteria) this;
        }

        public Criteria andMessTimeEqualTo(Date value) {
            addCriterion("mess_time =", value, "messTime");
            return (Criteria) this;
        }

        public Criteria andMessTimeNotEqualTo(Date value) {
            addCriterion("mess_time <>", value, "messTime");
            return (Criteria) this;
        }

        public Criteria andMessTimeGreaterThan(Date value) {
            addCriterion("mess_time >", value, "messTime");
            return (Criteria) this;
        }

        public Criteria andMessTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mess_time >=", value, "messTime");
            return (Criteria) this;
        }

        public Criteria andMessTimeLessThan(Date value) {
            addCriterion("mess_time <", value, "messTime");
            return (Criteria) this;
        }

        public Criteria andMessTimeLessThanOrEqualTo(Date value) {
            addCriterion("mess_time <=", value, "messTime");
            return (Criteria) this;
        }

        public Criteria andMessTimeIn(List<Date> values) {
            addCriterion("mess_time in", values, "messTime");
            return (Criteria) this;
        }

        public Criteria andMessTimeNotIn(List<Date> values) {
            addCriterion("mess_time not in", values, "messTime");
            return (Criteria) this;
        }

        public Criteria andMessTimeBetween(Date value1, Date value2) {
            addCriterion("mess_time between", value1, value2, "messTime");
            return (Criteria) this;
        }

        public Criteria andMessTimeNotBetween(Date value1, Date value2) {
            addCriterion("mess_time not between", value1, value2, "messTime");
            return (Criteria) this;
        }

        public Criteria andMessInitiatorIsNull() {
            addCriterion("mess_initiator is null");
            return (Criteria) this;
        }

        public Criteria andMessInitiatorIsNotNull() {
            addCriterion("mess_initiator is not null");
            return (Criteria) this;
        }

        public Criteria andMessInitiatorEqualTo(String value) {
            addCriterion("mess_initiator =", value, "messInitiator");
            return (Criteria) this;
        }

        public Criteria andMessInitiatorNotEqualTo(String value) {
            addCriterion("mess_initiator <>", value, "messInitiator");
            return (Criteria) this;
        }

        public Criteria andMessInitiatorGreaterThan(String value) {
            addCriterion("mess_initiator >", value, "messInitiator");
            return (Criteria) this;
        }

        public Criteria andMessInitiatorGreaterThanOrEqualTo(String value) {
            addCriterion("mess_initiator >=", value, "messInitiator");
            return (Criteria) this;
        }

        public Criteria andMessInitiatorLessThan(String value) {
            addCriterion("mess_initiator <", value, "messInitiator");
            return (Criteria) this;
        }

        public Criteria andMessInitiatorLessThanOrEqualTo(String value) {
            addCriterion("mess_initiator <=", value, "messInitiator");
            return (Criteria) this;
        }

        public Criteria andMessInitiatorLike(String value) {
            addCriterion("mess_initiator like", value, "messInitiator");
            return (Criteria) this;
        }

        public Criteria andMessInitiatorNotLike(String value) {
            addCriterion("mess_initiator not like", value, "messInitiator");
            return (Criteria) this;
        }

        public Criteria andMessInitiatorIn(List<String> values) {
            addCriterion("mess_initiator in", values, "messInitiator");
            return (Criteria) this;
        }

        public Criteria andMessInitiatorNotIn(List<String> values) {
            addCriterion("mess_initiator not in", values, "messInitiator");
            return (Criteria) this;
        }

        public Criteria andMessInitiatorBetween(String value1, String value2) {
            addCriterion("mess_initiator between", value1, value2, "messInitiator");
            return (Criteria) this;
        }

        public Criteria andMessInitiatorNotBetween(String value1, String value2) {
            addCriterion("mess_initiator not between", value1, value2, "messInitiator");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
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