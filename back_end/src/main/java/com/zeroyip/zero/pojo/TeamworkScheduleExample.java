package com.zeroyip.zero.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TeamworkScheduleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeamworkScheduleExample() {
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

        public Criteria andSchNumIsNull() {
            addCriterion("sch_num is null");
            return (Criteria) this;
        }

        public Criteria andSchNumIsNotNull() {
            addCriterion("sch_num is not null");
            return (Criteria) this;
        }

        public Criteria andSchNumEqualTo(Integer value) {
            addCriterion("sch_num =", value, "schNum");
            return (Criteria) this;
        }

        public Criteria andSchNumNotEqualTo(Integer value) {
            addCriterion("sch_num <>", value, "schNum");
            return (Criteria) this;
        }

        public Criteria andSchNumGreaterThan(Integer value) {
            addCriterion("sch_num >", value, "schNum");
            return (Criteria) this;
        }

        public Criteria andSchNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sch_num >=", value, "schNum");
            return (Criteria) this;
        }

        public Criteria andSchNumLessThan(Integer value) {
            addCriterion("sch_num <", value, "schNum");
            return (Criteria) this;
        }

        public Criteria andSchNumLessThanOrEqualTo(Integer value) {
            addCriterion("sch_num <=", value, "schNum");
            return (Criteria) this;
        }

        public Criteria andSchNumIn(List<Integer> values) {
            addCriterion("sch_num in", values, "schNum");
            return (Criteria) this;
        }

        public Criteria andSchNumNotIn(List<Integer> values) {
            addCriterion("sch_num not in", values, "schNum");
            return (Criteria) this;
        }

        public Criteria andSchNumBetween(Integer value1, Integer value2) {
            addCriterion("sch_num between", value1, value2, "schNum");
            return (Criteria) this;
        }

        public Criteria andSchNumNotBetween(Integer value1, Integer value2) {
            addCriterion("sch_num not between", value1, value2, "schNum");
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

        public Criteria andSchCreateTimeIsNull() {
            addCriterion("sch_create_time is null");
            return (Criteria) this;
        }

        public Criteria andSchCreateTimeIsNotNull() {
            addCriterion("sch_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andSchCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("sch_create_time =", value, "schCreateTime");
            return (Criteria) this;
        }

        public Criteria andSchCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("sch_create_time <>", value, "schCreateTime");
            return (Criteria) this;
        }

        public Criteria andSchCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("sch_create_time >", value, "schCreateTime");
            return (Criteria) this;
        }

        public Criteria andSchCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sch_create_time >=", value, "schCreateTime");
            return (Criteria) this;
        }

        public Criteria andSchCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("sch_create_time <", value, "schCreateTime");
            return (Criteria) this;
        }

        public Criteria andSchCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sch_create_time <=", value, "schCreateTime");
            return (Criteria) this;
        }

        public Criteria andSchCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("sch_create_time in", values, "schCreateTime");
            return (Criteria) this;
        }

        public Criteria andSchCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("sch_create_time not in", values, "schCreateTime");
            return (Criteria) this;
        }

        public Criteria andSchCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sch_create_time between", value1, value2, "schCreateTime");
            return (Criteria) this;
        }

        public Criteria andSchCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sch_create_time not between", value1, value2, "schCreateTime");
            return (Criteria) this;
        }

        public Criteria andSchContentIsNull() {
            addCriterion("sch_content is null");
            return (Criteria) this;
        }

        public Criteria andSchContentIsNotNull() {
            addCriterion("sch_content is not null");
            return (Criteria) this;
        }

        public Criteria andSchContentEqualTo(String value) {
            addCriterion("sch_content =", value, "schContent");
            return (Criteria) this;
        }

        public Criteria andSchContentNotEqualTo(String value) {
            addCriterion("sch_content <>", value, "schContent");
            return (Criteria) this;
        }

        public Criteria andSchContentGreaterThan(String value) {
            addCriterion("sch_content >", value, "schContent");
            return (Criteria) this;
        }

        public Criteria andSchContentGreaterThanOrEqualTo(String value) {
            addCriterion("sch_content >=", value, "schContent");
            return (Criteria) this;
        }

        public Criteria andSchContentLessThan(String value) {
            addCriterion("sch_content <", value, "schContent");
            return (Criteria) this;
        }

        public Criteria andSchContentLessThanOrEqualTo(String value) {
            addCriterion("sch_content <=", value, "schContent");
            return (Criteria) this;
        }

        public Criteria andSchContentLike(String value) {
            addCriterion("sch_content like", value, "schContent");
            return (Criteria) this;
        }

        public Criteria andSchContentNotLike(String value) {
            addCriterion("sch_content not like", value, "schContent");
            return (Criteria) this;
        }

        public Criteria andSchContentIn(List<String> values) {
            addCriterion("sch_content in", values, "schContent");
            return (Criteria) this;
        }

        public Criteria andSchContentNotIn(List<String> values) {
            addCriterion("sch_content not in", values, "schContent");
            return (Criteria) this;
        }

        public Criteria andSchContentBetween(String value1, String value2) {
            addCriterion("sch_content between", value1, value2, "schContent");
            return (Criteria) this;
        }

        public Criteria andSchContentNotBetween(String value1, String value2) {
            addCriterion("sch_content not between", value1, value2, "schContent");
            return (Criteria) this;
        }

        public Criteria andSchTimeIsNull() {
            addCriterion("sch_time is null");
            return (Criteria) this;
        }

        public Criteria andSchTimeIsNotNull() {
            addCriterion("sch_time is not null");
            return (Criteria) this;
        }

        public Criteria andSchTimeEqualTo(Date value) {
            addCriterionForJDBCDate("sch_time =", value, "schTime");
            return (Criteria) this;
        }

        public Criteria andSchTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("sch_time <>", value, "schTime");
            return (Criteria) this;
        }

        public Criteria andSchTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("sch_time >", value, "schTime");
            return (Criteria) this;
        }

        public Criteria andSchTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sch_time >=", value, "schTime");
            return (Criteria) this;
        }

        public Criteria andSchTimeLessThan(Date value) {
            addCriterionForJDBCDate("sch_time <", value, "schTime");
            return (Criteria) this;
        }

        public Criteria andSchTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sch_time <=", value, "schTime");
            return (Criteria) this;
        }

        public Criteria andSchTimeIn(List<Date> values) {
            addCriterionForJDBCDate("sch_time in", values, "schTime");
            return (Criteria) this;
        }

        public Criteria andSchTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("sch_time not in", values, "schTime");
            return (Criteria) this;
        }

        public Criteria andSchTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sch_time between", value1, value2, "schTime");
            return (Criteria) this;
        }

        public Criteria andSchTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sch_time not between", value1, value2, "schTime");
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