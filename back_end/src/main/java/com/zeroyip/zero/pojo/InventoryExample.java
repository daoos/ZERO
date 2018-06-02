package com.zeroyip.zero.pojo;

import java.util.ArrayList;
import java.util.List;

public class InventoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InventoryExample() {
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

        public Criteria andInvNumIsNull() {
            addCriterion("inv_num is null");
            return (Criteria) this;
        }

        public Criteria andInvNumIsNotNull() {
            addCriterion("inv_num is not null");
            return (Criteria) this;
        }

        public Criteria andInvNumEqualTo(Integer value) {
            addCriterion("inv_num =", value, "invNum");
            return (Criteria) this;
        }

        public Criteria andInvNumNotEqualTo(Integer value) {
            addCriterion("inv_num <>", value, "invNum");
            return (Criteria) this;
        }

        public Criteria andInvNumGreaterThan(Integer value) {
            addCriterion("inv_num >", value, "invNum");
            return (Criteria) this;
        }

        public Criteria andInvNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("inv_num >=", value, "invNum");
            return (Criteria) this;
        }

        public Criteria andInvNumLessThan(Integer value) {
            addCriterion("inv_num <", value, "invNum");
            return (Criteria) this;
        }

        public Criteria andInvNumLessThanOrEqualTo(Integer value) {
            addCriterion("inv_num <=", value, "invNum");
            return (Criteria) this;
        }

        public Criteria andInvNumIn(List<Integer> values) {
            addCriterion("inv_num in", values, "invNum");
            return (Criteria) this;
        }

        public Criteria andInvNumNotIn(List<Integer> values) {
            addCriterion("inv_num not in", values, "invNum");
            return (Criteria) this;
        }

        public Criteria andInvNumBetween(Integer value1, Integer value2) {
            addCriterion("inv_num between", value1, value2, "invNum");
            return (Criteria) this;
        }

        public Criteria andInvNumNotBetween(Integer value1, Integer value2) {
            addCriterion("inv_num not between", value1, value2, "invNum");
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