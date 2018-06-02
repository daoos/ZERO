package com.zeroyip.zero.pojo;

import java.util.ArrayList;
import java.util.List;

public class TeamworkMemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeamworkMemberExample() {
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

        public Criteria andMemberNumIsNull() {
            addCriterion("member_num is null");
            return (Criteria) this;
        }

        public Criteria andMemberNumIsNotNull() {
            addCriterion("member_num is not null");
            return (Criteria) this;
        }

        public Criteria andMemberNumEqualTo(Integer value) {
            addCriterion("member_num =", value, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumNotEqualTo(Integer value) {
            addCriterion("member_num <>", value, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumGreaterThan(Integer value) {
            addCriterion("member_num >", value, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_num >=", value, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumLessThan(Integer value) {
            addCriterion("member_num <", value, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumLessThanOrEqualTo(Integer value) {
            addCriterion("member_num <=", value, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumIn(List<Integer> values) {
            addCriterion("member_num in", values, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumNotIn(List<Integer> values) {
            addCriterion("member_num not in", values, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumBetween(Integer value1, Integer value2) {
            addCriterion("member_num between", value1, value2, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumNotBetween(Integer value1, Integer value2) {
            addCriterion("member_num not between", value1, value2, "memberNum");
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

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupMemberIsNull() {
            addCriterion("group_member is null");
            return (Criteria) this;
        }

        public Criteria andGroupMemberIsNotNull() {
            addCriterion("group_member is not null");
            return (Criteria) this;
        }

        public Criteria andGroupMemberEqualTo(String value) {
            addCriterion("group_member =", value, "groupMember");
            return (Criteria) this;
        }

        public Criteria andGroupMemberNotEqualTo(String value) {
            addCriterion("group_member <>", value, "groupMember");
            return (Criteria) this;
        }

        public Criteria andGroupMemberGreaterThan(String value) {
            addCriterion("group_member >", value, "groupMember");
            return (Criteria) this;
        }

        public Criteria andGroupMemberGreaterThanOrEqualTo(String value) {
            addCriterion("group_member >=", value, "groupMember");
            return (Criteria) this;
        }

        public Criteria andGroupMemberLessThan(String value) {
            addCriterion("group_member <", value, "groupMember");
            return (Criteria) this;
        }

        public Criteria andGroupMemberLessThanOrEqualTo(String value) {
            addCriterion("group_member <=", value, "groupMember");
            return (Criteria) this;
        }

        public Criteria andGroupMemberLike(String value) {
            addCriterion("group_member like", value, "groupMember");
            return (Criteria) this;
        }

        public Criteria andGroupMemberNotLike(String value) {
            addCriterion("group_member not like", value, "groupMember");
            return (Criteria) this;
        }

        public Criteria andGroupMemberIn(List<String> values) {
            addCriterion("group_member in", values, "groupMember");
            return (Criteria) this;
        }

        public Criteria andGroupMemberNotIn(List<String> values) {
            addCriterion("group_member not in", values, "groupMember");
            return (Criteria) this;
        }

        public Criteria andGroupMemberBetween(String value1, String value2) {
            addCriterion("group_member between", value1, value2, "groupMember");
            return (Criteria) this;
        }

        public Criteria andGroupMemberNotBetween(String value1, String value2) {
            addCriterion("group_member not between", value1, value2, "groupMember");
            return (Criteria) this;
        }

        public Criteria andMemberRoleIsNull() {
            addCriterion("member_role is null");
            return (Criteria) this;
        }

        public Criteria andMemberRoleIsNotNull() {
            addCriterion("member_role is not null");
            return (Criteria) this;
        }

        public Criteria andMemberRoleEqualTo(String value) {
            addCriterion("member_role =", value, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNotEqualTo(String value) {
            addCriterion("member_role <>", value, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleGreaterThan(String value) {
            addCriterion("member_role >", value, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleGreaterThanOrEqualTo(String value) {
            addCriterion("member_role >=", value, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleLessThan(String value) {
            addCriterion("member_role <", value, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleLessThanOrEqualTo(String value) {
            addCriterion("member_role <=", value, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleLike(String value) {
            addCriterion("member_role like", value, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNotLike(String value) {
            addCriterion("member_role not like", value, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleIn(List<String> values) {
            addCriterion("member_role in", values, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNotIn(List<String> values) {
            addCriterion("member_role not in", values, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleBetween(String value1, String value2) {
            addCriterion("member_role between", value1, value2, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNotBetween(String value1, String value2) {
            addCriterion("member_role not between", value1, value2, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberPermissionIsNull() {
            addCriterion("member_permission is null");
            return (Criteria) this;
        }

        public Criteria andMemberPermissionIsNotNull() {
            addCriterion("member_permission is not null");
            return (Criteria) this;
        }

        public Criteria andMemberPermissionEqualTo(String value) {
            addCriterion("member_permission =", value, "memberPermission");
            return (Criteria) this;
        }

        public Criteria andMemberPermissionNotEqualTo(String value) {
            addCriterion("member_permission <>", value, "memberPermission");
            return (Criteria) this;
        }

        public Criteria andMemberPermissionGreaterThan(String value) {
            addCriterion("member_permission >", value, "memberPermission");
            return (Criteria) this;
        }

        public Criteria andMemberPermissionGreaterThanOrEqualTo(String value) {
            addCriterion("member_permission >=", value, "memberPermission");
            return (Criteria) this;
        }

        public Criteria andMemberPermissionLessThan(String value) {
            addCriterion("member_permission <", value, "memberPermission");
            return (Criteria) this;
        }

        public Criteria andMemberPermissionLessThanOrEqualTo(String value) {
            addCriterion("member_permission <=", value, "memberPermission");
            return (Criteria) this;
        }

        public Criteria andMemberPermissionLike(String value) {
            addCriterion("member_permission like", value, "memberPermission");
            return (Criteria) this;
        }

        public Criteria andMemberPermissionNotLike(String value) {
            addCriterion("member_permission not like", value, "memberPermission");
            return (Criteria) this;
        }

        public Criteria andMemberPermissionIn(List<String> values) {
            addCriterion("member_permission in", values, "memberPermission");
            return (Criteria) this;
        }

        public Criteria andMemberPermissionNotIn(List<String> values) {
            addCriterion("member_permission not in", values, "memberPermission");
            return (Criteria) this;
        }

        public Criteria andMemberPermissionBetween(String value1, String value2) {
            addCriterion("member_permission between", value1, value2, "memberPermission");
            return (Criteria) this;
        }

        public Criteria andMemberPermissionNotBetween(String value1, String value2) {
            addCriterion("member_permission not between", value1, value2, "memberPermission");
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