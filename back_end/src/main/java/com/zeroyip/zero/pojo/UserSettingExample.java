package com.zeroyip.zero.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserSettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserSettingExample() {
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

        public Criteria andLastChangeTimeIsNull() {
            addCriterion("last_change_time is null");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeIsNotNull() {
            addCriterion("last_change_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeEqualTo(Date value) {
            addCriterion("last_change_time =", value, "lastChangeTime");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeNotEqualTo(Date value) {
            addCriterion("last_change_time <>", value, "lastChangeTime");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeGreaterThan(Date value) {
            addCriterion("last_change_time >", value, "lastChangeTime");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_change_time >=", value, "lastChangeTime");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeLessThan(Date value) {
            addCriterion("last_change_time <", value, "lastChangeTime");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_change_time <=", value, "lastChangeTime");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeIn(List<Date> values) {
            addCriterion("last_change_time in", values, "lastChangeTime");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeNotIn(List<Date> values) {
            addCriterion("last_change_time not in", values, "lastChangeTime");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeBetween(Date value1, Date value2) {
            addCriterion("last_change_time between", value1, value2, "lastChangeTime");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_change_time not between", value1, value2, "lastChangeTime");
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

        public Criteria andLanguageIsNull() {
            addCriterion("language is null");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNotNull() {
            addCriterion("language is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageEqualTo(String value) {
            addCriterion("language =", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotEqualTo(String value) {
            addCriterion("language <>", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThan(String value) {
            addCriterion("language >", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("language >=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThan(String value) {
            addCriterion("language <", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThanOrEqualTo(String value) {
            addCriterion("language <=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLike(String value) {
            addCriterion("language like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotLike(String value) {
            addCriterion("language not like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageIn(List<String> values) {
            addCriterion("language in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotIn(List<String> values) {
            addCriterion("language not in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageBetween(String value1, String value2) {
            addCriterion("language between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotBetween(String value1, String value2) {
            addCriterion("language not between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andStratingPageIsNull() {
            addCriterion("strating_page is null");
            return (Criteria) this;
        }

        public Criteria andStratingPageIsNotNull() {
            addCriterion("strating_page is not null");
            return (Criteria) this;
        }

        public Criteria andStratingPageEqualTo(String value) {
            addCriterion("strating_page =", value, "stratingPage");
            return (Criteria) this;
        }

        public Criteria andStratingPageNotEqualTo(String value) {
            addCriterion("strating_page <>", value, "stratingPage");
            return (Criteria) this;
        }

        public Criteria andStratingPageGreaterThan(String value) {
            addCriterion("strating_page >", value, "stratingPage");
            return (Criteria) this;
        }

        public Criteria andStratingPageGreaterThanOrEqualTo(String value) {
            addCriterion("strating_page >=", value, "stratingPage");
            return (Criteria) this;
        }

        public Criteria andStratingPageLessThan(String value) {
            addCriterion("strating_page <", value, "stratingPage");
            return (Criteria) this;
        }

        public Criteria andStratingPageLessThanOrEqualTo(String value) {
            addCriterion("strating_page <=", value, "stratingPage");
            return (Criteria) this;
        }

        public Criteria andStratingPageLike(String value) {
            addCriterion("strating_page like", value, "stratingPage");
            return (Criteria) this;
        }

        public Criteria andStratingPageNotLike(String value) {
            addCriterion("strating_page not like", value, "stratingPage");
            return (Criteria) this;
        }

        public Criteria andStratingPageIn(List<String> values) {
            addCriterion("strating_page in", values, "stratingPage");
            return (Criteria) this;
        }

        public Criteria andStratingPageNotIn(List<String> values) {
            addCriterion("strating_page not in", values, "stratingPage");
            return (Criteria) this;
        }

        public Criteria andStratingPageBetween(String value1, String value2) {
            addCriterion("strating_page between", value1, value2, "stratingPage");
            return (Criteria) this;
        }

        public Criteria andStratingPageNotBetween(String value1, String value2) {
            addCriterion("strating_page not between", value1, value2, "stratingPage");
            return (Criteria) this;
        }

        public Criteria andDateRecogniseIsNull() {
            addCriterion("date_recognise is null");
            return (Criteria) this;
        }

        public Criteria andDateRecogniseIsNotNull() {
            addCriterion("date_recognise is not null");
            return (Criteria) this;
        }

        public Criteria andDateRecogniseEqualTo(String value) {
            addCriterion("date_recognise =", value, "dateRecognise");
            return (Criteria) this;
        }

        public Criteria andDateRecogniseNotEqualTo(String value) {
            addCriterion("date_recognise <>", value, "dateRecognise");
            return (Criteria) this;
        }

        public Criteria andDateRecogniseGreaterThan(String value) {
            addCriterion("date_recognise >", value, "dateRecognise");
            return (Criteria) this;
        }

        public Criteria andDateRecogniseGreaterThanOrEqualTo(String value) {
            addCriterion("date_recognise >=", value, "dateRecognise");
            return (Criteria) this;
        }

        public Criteria andDateRecogniseLessThan(String value) {
            addCriterion("date_recognise <", value, "dateRecognise");
            return (Criteria) this;
        }

        public Criteria andDateRecogniseLessThanOrEqualTo(String value) {
            addCriterion("date_recognise <=", value, "dateRecognise");
            return (Criteria) this;
        }

        public Criteria andDateRecogniseLike(String value) {
            addCriterion("date_recognise like", value, "dateRecognise");
            return (Criteria) this;
        }

        public Criteria andDateRecogniseNotLike(String value) {
            addCriterion("date_recognise not like", value, "dateRecognise");
            return (Criteria) this;
        }

        public Criteria andDateRecogniseIn(List<String> values) {
            addCriterion("date_recognise in", values, "dateRecognise");
            return (Criteria) this;
        }

        public Criteria andDateRecogniseNotIn(List<String> values) {
            addCriterion("date_recognise not in", values, "dateRecognise");
            return (Criteria) this;
        }

        public Criteria andDateRecogniseBetween(String value1, String value2) {
            addCriterion("date_recognise between", value1, value2, "dateRecognise");
            return (Criteria) this;
        }

        public Criteria andDateRecogniseNotBetween(String value1, String value2) {
            addCriterion("date_recognise not between", value1, value2, "dateRecognise");
            return (Criteria) this;
        }

        public Criteria andInviteIsNull() {
            addCriterion("invite is null");
            return (Criteria) this;
        }

        public Criteria andInviteIsNotNull() {
            addCriterion("invite is not null");
            return (Criteria) this;
        }

        public Criteria andInviteEqualTo(String value) {
            addCriterion("invite =", value, "invite");
            return (Criteria) this;
        }

        public Criteria andInviteNotEqualTo(String value) {
            addCriterion("invite <>", value, "invite");
            return (Criteria) this;
        }

        public Criteria andInviteGreaterThan(String value) {
            addCriterion("invite >", value, "invite");
            return (Criteria) this;
        }

        public Criteria andInviteGreaterThanOrEqualTo(String value) {
            addCriterion("invite >=", value, "invite");
            return (Criteria) this;
        }

        public Criteria andInviteLessThan(String value) {
            addCriterion("invite <", value, "invite");
            return (Criteria) this;
        }

        public Criteria andInviteLessThanOrEqualTo(String value) {
            addCriterion("invite <=", value, "invite");
            return (Criteria) this;
        }

        public Criteria andInviteLike(String value) {
            addCriterion("invite like", value, "invite");
            return (Criteria) this;
        }

        public Criteria andInviteNotLike(String value) {
            addCriterion("invite not like", value, "invite");
            return (Criteria) this;
        }

        public Criteria andInviteIn(List<String> values) {
            addCriterion("invite in", values, "invite");
            return (Criteria) this;
        }

        public Criteria andInviteNotIn(List<String> values) {
            addCriterion("invite not in", values, "invite");
            return (Criteria) this;
        }

        public Criteria andInviteBetween(String value1, String value2) {
            addCriterion("invite between", value1, value2, "invite");
            return (Criteria) this;
        }

        public Criteria andInviteNotBetween(String value1, String value2) {
            addCriterion("invite not between", value1, value2, "invite");
            return (Criteria) this;
        }

        public Criteria andDateFormatIsNull() {
            addCriterion("date_format is null");
            return (Criteria) this;
        }

        public Criteria andDateFormatIsNotNull() {
            addCriterion("date_format is not null");
            return (Criteria) this;
        }

        public Criteria andDateFormatEqualTo(String value) {
            addCriterion("date_format =", value, "dateFormat");
            return (Criteria) this;
        }

        public Criteria andDateFormatNotEqualTo(String value) {
            addCriterion("date_format <>", value, "dateFormat");
            return (Criteria) this;
        }

        public Criteria andDateFormatGreaterThan(String value) {
            addCriterion("date_format >", value, "dateFormat");
            return (Criteria) this;
        }

        public Criteria andDateFormatGreaterThanOrEqualTo(String value) {
            addCriterion("date_format >=", value, "dateFormat");
            return (Criteria) this;
        }

        public Criteria andDateFormatLessThan(String value) {
            addCriterion("date_format <", value, "dateFormat");
            return (Criteria) this;
        }

        public Criteria andDateFormatLessThanOrEqualTo(String value) {
            addCriterion("date_format <=", value, "dateFormat");
            return (Criteria) this;
        }

        public Criteria andDateFormatLike(String value) {
            addCriterion("date_format like", value, "dateFormat");
            return (Criteria) this;
        }

        public Criteria andDateFormatNotLike(String value) {
            addCriterion("date_format not like", value, "dateFormat");
            return (Criteria) this;
        }

        public Criteria andDateFormatIn(List<String> values) {
            addCriterion("date_format in", values, "dateFormat");
            return (Criteria) this;
        }

        public Criteria andDateFormatNotIn(List<String> values) {
            addCriterion("date_format not in", values, "dateFormat");
            return (Criteria) this;
        }

        public Criteria andDateFormatBetween(String value1, String value2) {
            addCriterion("date_format between", value1, value2, "dateFormat");
            return (Criteria) this;
        }

        public Criteria andDateFormatNotBetween(String value1, String value2) {
            addCriterion("date_format not between", value1, value2, "dateFormat");
            return (Criteria) this;
        }

        public Criteria andWebsiteNoticeIsNull() {
            addCriterion("website_notice is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteNoticeIsNotNull() {
            addCriterion("website_notice is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteNoticeEqualTo(String value) {
            addCriterion("website_notice =", value, "websiteNotice");
            return (Criteria) this;
        }

        public Criteria andWebsiteNoticeNotEqualTo(String value) {
            addCriterion("website_notice <>", value, "websiteNotice");
            return (Criteria) this;
        }

        public Criteria andWebsiteNoticeGreaterThan(String value) {
            addCriterion("website_notice >", value, "websiteNotice");
            return (Criteria) this;
        }

        public Criteria andWebsiteNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("website_notice >=", value, "websiteNotice");
            return (Criteria) this;
        }

        public Criteria andWebsiteNoticeLessThan(String value) {
            addCriterion("website_notice <", value, "websiteNotice");
            return (Criteria) this;
        }

        public Criteria andWebsiteNoticeLessThanOrEqualTo(String value) {
            addCriterion("website_notice <=", value, "websiteNotice");
            return (Criteria) this;
        }

        public Criteria andWebsiteNoticeLike(String value) {
            addCriterion("website_notice like", value, "websiteNotice");
            return (Criteria) this;
        }

        public Criteria andWebsiteNoticeNotLike(String value) {
            addCriterion("website_notice not like", value, "websiteNotice");
            return (Criteria) this;
        }

        public Criteria andWebsiteNoticeIn(List<String> values) {
            addCriterion("website_notice in", values, "websiteNotice");
            return (Criteria) this;
        }

        public Criteria andWebsiteNoticeNotIn(List<String> values) {
            addCriterion("website_notice not in", values, "websiteNotice");
            return (Criteria) this;
        }

        public Criteria andWebsiteNoticeBetween(String value1, String value2) {
            addCriterion("website_notice between", value1, value2, "websiteNotice");
            return (Criteria) this;
        }

        public Criteria andWebsiteNoticeNotBetween(String value1, String value2) {
            addCriterion("website_notice not between", value1, value2, "websiteNotice");
            return (Criteria) this;
        }

        public Criteria andNoticeRuleIsNull() {
            addCriterion("notice_rule is null");
            return (Criteria) this;
        }

        public Criteria andNoticeRuleIsNotNull() {
            addCriterion("notice_rule is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeRuleEqualTo(String value) {
            addCriterion("notice_rule =", value, "noticeRule");
            return (Criteria) this;
        }

        public Criteria andNoticeRuleNotEqualTo(String value) {
            addCriterion("notice_rule <>", value, "noticeRule");
            return (Criteria) this;
        }

        public Criteria andNoticeRuleGreaterThan(String value) {
            addCriterion("notice_rule >", value, "noticeRule");
            return (Criteria) this;
        }

        public Criteria andNoticeRuleGreaterThanOrEqualTo(String value) {
            addCriterion("notice_rule >=", value, "noticeRule");
            return (Criteria) this;
        }

        public Criteria andNoticeRuleLessThan(String value) {
            addCriterion("notice_rule <", value, "noticeRule");
            return (Criteria) this;
        }

        public Criteria andNoticeRuleLessThanOrEqualTo(String value) {
            addCriterion("notice_rule <=", value, "noticeRule");
            return (Criteria) this;
        }

        public Criteria andNoticeRuleLike(String value) {
            addCriterion("notice_rule like", value, "noticeRule");
            return (Criteria) this;
        }

        public Criteria andNoticeRuleNotLike(String value) {
            addCriterion("notice_rule not like", value, "noticeRule");
            return (Criteria) this;
        }

        public Criteria andNoticeRuleIn(List<String> values) {
            addCriterion("notice_rule in", values, "noticeRule");
            return (Criteria) this;
        }

        public Criteria andNoticeRuleNotIn(List<String> values) {
            addCriterion("notice_rule not in", values, "noticeRule");
            return (Criteria) this;
        }

        public Criteria andNoticeRuleBetween(String value1, String value2) {
            addCriterion("notice_rule between", value1, value2, "noticeRule");
            return (Criteria) this;
        }

        public Criteria andNoticeRuleNotBetween(String value1, String value2) {
            addCriterion("notice_rule not between", value1, value2, "noticeRule");
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