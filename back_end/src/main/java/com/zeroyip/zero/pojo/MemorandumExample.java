package com.zeroyip.zero.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MemorandumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemorandumExample() {
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

        public Criteria andMemNumIsNull() {
            addCriterion("mem_num is null");
            return (Criteria) this;
        }

        public Criteria andMemNumIsNotNull() {
            addCriterion("mem_num is not null");
            return (Criteria) this;
        }

        public Criteria andMemNumEqualTo(Integer value) {
            addCriterion("mem_num =", value, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumNotEqualTo(Integer value) {
            addCriterion("mem_num <>", value, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumGreaterThan(Integer value) {
            addCriterion("mem_num >", value, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("mem_num >=", value, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumLessThan(Integer value) {
            addCriterion("mem_num <", value, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumLessThanOrEqualTo(Integer value) {
            addCriterion("mem_num <=", value, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumIn(List<Integer> values) {
            addCriterion("mem_num in", values, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumNotIn(List<Integer> values) {
            addCriterion("mem_num not in", values, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumBetween(Integer value1, Integer value2) {
            addCriterion("mem_num between", value1, value2, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumNotBetween(Integer value1, Integer value2) {
            addCriterion("mem_num not between", value1, value2, "memNum");
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

        public Criteria andMemCreateTimeIsNull() {
            addCriterion("mem_create_time is null");
            return (Criteria) this;
        }

        public Criteria andMemCreateTimeIsNotNull() {
            addCriterion("mem_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andMemCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("mem_create_time =", value, "memCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("mem_create_time <>", value, "memCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("mem_create_time >", value, "memCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mem_create_time >=", value, "memCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("mem_create_time <", value, "memCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mem_create_time <=", value, "memCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("mem_create_time in", values, "memCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("mem_create_time not in", values, "memCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mem_create_time between", value1, value2, "memCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mem_create_time not between", value1, value2, "memCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemTitleIsNull() {
            addCriterion("mem_title is null");
            return (Criteria) this;
        }

        public Criteria andMemTitleIsNotNull() {
            addCriterion("mem_title is not null");
            return (Criteria) this;
        }

        public Criteria andMemTitleEqualTo(String value) {
            addCriterion("mem_title =", value, "memTitle");
            return (Criteria) this;
        }

        public Criteria andMemTitleNotEqualTo(String value) {
            addCriterion("mem_title <>", value, "memTitle");
            return (Criteria) this;
        }

        public Criteria andMemTitleGreaterThan(String value) {
            addCriterion("mem_title >", value, "memTitle");
            return (Criteria) this;
        }

        public Criteria andMemTitleGreaterThanOrEqualTo(String value) {
            addCriterion("mem_title >=", value, "memTitle");
            return (Criteria) this;
        }

        public Criteria andMemTitleLessThan(String value) {
            addCriterion("mem_title <", value, "memTitle");
            return (Criteria) this;
        }

        public Criteria andMemTitleLessThanOrEqualTo(String value) {
            addCriterion("mem_title <=", value, "memTitle");
            return (Criteria) this;
        }

        public Criteria andMemTitleLike(String value) {
            addCriterion("mem_title like", value, "memTitle");
            return (Criteria) this;
        }

        public Criteria andMemTitleNotLike(String value) {
            addCriterion("mem_title not like", value, "memTitle");
            return (Criteria) this;
        }

        public Criteria andMemTitleIn(List<String> values) {
            addCriterion("mem_title in", values, "memTitle");
            return (Criteria) this;
        }

        public Criteria andMemTitleNotIn(List<String> values) {
            addCriterion("mem_title not in", values, "memTitle");
            return (Criteria) this;
        }

        public Criteria andMemTitleBetween(String value1, String value2) {
            addCriterion("mem_title between", value1, value2, "memTitle");
            return (Criteria) this;
        }

        public Criteria andMemTitleNotBetween(String value1, String value2) {
            addCriterion("mem_title not between", value1, value2, "memTitle");
            return (Criteria) this;
        }

        public Criteria andMemContentIsNull() {
            addCriterion("mem_content is null");
            return (Criteria) this;
        }

        public Criteria andMemContentIsNotNull() {
            addCriterion("mem_content is not null");
            return (Criteria) this;
        }

        public Criteria andMemContentEqualTo(String value) {
            addCriterion("mem_content =", value, "memContent");
            return (Criteria) this;
        }

        public Criteria andMemContentNotEqualTo(String value) {
            addCriterion("mem_content <>", value, "memContent");
            return (Criteria) this;
        }

        public Criteria andMemContentGreaterThan(String value) {
            addCriterion("mem_content >", value, "memContent");
            return (Criteria) this;
        }

        public Criteria andMemContentGreaterThanOrEqualTo(String value) {
            addCriterion("mem_content >=", value, "memContent");
            return (Criteria) this;
        }

        public Criteria andMemContentLessThan(String value) {
            addCriterion("mem_content <", value, "memContent");
            return (Criteria) this;
        }

        public Criteria andMemContentLessThanOrEqualTo(String value) {
            addCriterion("mem_content <=", value, "memContent");
            return (Criteria) this;
        }

        public Criteria andMemContentLike(String value) {
            addCriterion("mem_content like", value, "memContent");
            return (Criteria) this;
        }

        public Criteria andMemContentNotLike(String value) {
            addCriterion("mem_content not like", value, "memContent");
            return (Criteria) this;
        }

        public Criteria andMemContentIn(List<String> values) {
            addCriterion("mem_content in", values, "memContent");
            return (Criteria) this;
        }

        public Criteria andMemContentNotIn(List<String> values) {
            addCriterion("mem_content not in", values, "memContent");
            return (Criteria) this;
        }

        public Criteria andMemContentBetween(String value1, String value2) {
            addCriterion("mem_content between", value1, value2, "memContent");
            return (Criteria) this;
        }

        public Criteria andMemContentNotBetween(String value1, String value2) {
            addCriterion("mem_content not between", value1, value2, "memContent");
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