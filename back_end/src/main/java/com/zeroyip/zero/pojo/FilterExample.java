package com.zeroyip.zero.pojo;

import java.util.ArrayList;
import java.util.List;

public class FilterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FilterExample() {
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

        public Criteria andFilterNumIsNull() {
            addCriterion("filter_num is null");
            return (Criteria) this;
        }

        public Criteria andFilterNumIsNotNull() {
            addCriterion("filter_num is not null");
            return (Criteria) this;
        }

        public Criteria andFilterNumEqualTo(Integer value) {
            addCriterion("filter_num =", value, "filterNum");
            return (Criteria) this;
        }

        public Criteria andFilterNumNotEqualTo(Integer value) {
            addCriterion("filter_num <>", value, "filterNum");
            return (Criteria) this;
        }

        public Criteria andFilterNumGreaterThan(Integer value) {
            addCriterion("filter_num >", value, "filterNum");
            return (Criteria) this;
        }

        public Criteria andFilterNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("filter_num >=", value, "filterNum");
            return (Criteria) this;
        }

        public Criteria andFilterNumLessThan(Integer value) {
            addCriterion("filter_num <", value, "filterNum");
            return (Criteria) this;
        }

        public Criteria andFilterNumLessThanOrEqualTo(Integer value) {
            addCriterion("filter_num <=", value, "filterNum");
            return (Criteria) this;
        }

        public Criteria andFilterNumIn(List<Integer> values) {
            addCriterion("filter_num in", values, "filterNum");
            return (Criteria) this;
        }

        public Criteria andFilterNumNotIn(List<Integer> values) {
            addCriterion("filter_num not in", values, "filterNum");
            return (Criteria) this;
        }

        public Criteria andFilterNumBetween(Integer value1, Integer value2) {
            addCriterion("filter_num between", value1, value2, "filterNum");
            return (Criteria) this;
        }

        public Criteria andFilterNumNotBetween(Integer value1, Integer value2) {
            addCriterion("filter_num not between", value1, value2, "filterNum");
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