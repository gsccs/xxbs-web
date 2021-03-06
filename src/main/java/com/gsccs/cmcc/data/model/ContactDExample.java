package com.gsccs.cmcc.data.model;

import java.util.ArrayList;
import java.util.List;

public class ContactDExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContactDExample() {
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

        public Criteria andAreanameIsNull() {
            addCriterion("areaname is null");
            return (Criteria) this;
        }

        public Criteria andAreanameIsNotNull() {
            addCriterion("areaname is not null");
            return (Criteria) this;
        }

        public Criteria andAreanameEqualTo(String value) {
            addCriterion("areaname =", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotEqualTo(String value) {
            addCriterion("areaname <>", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameGreaterThan(String value) {
            addCriterion("areaname >", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameGreaterThanOrEqualTo(String value) {
            addCriterion("areaname >=", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameLessThan(String value) {
            addCriterion("areaname <", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameLessThanOrEqualTo(String value) {
            addCriterion("areaname <=", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameLike(String value) {
            addCriterion("areaname like", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotLike(String value) {
            addCriterion("areaname not like", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameIn(List<String> values) {
            addCriterion("areaname in", values, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotIn(List<String> values) {
            addCriterion("areaname not in", values, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameBetween(String value1, String value2) {
            addCriterion("areaname between", value1, value2, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotBetween(String value1, String value2) {
            addCriterion("areaname not between", value1, value2, "areaname");
            return (Criteria) this;
        }

        public Criteria andIspnameIsNull() {
            addCriterion("ispname is null");
            return (Criteria) this;
        }

        public Criteria andIspnameIsNotNull() {
            addCriterion("ispname is not null");
            return (Criteria) this;
        }

        public Criteria andIspnameEqualTo(String value) {
            addCriterion("ispname =", value, "ispname");
            return (Criteria) this;
        }

        public Criteria andIspnameNotEqualTo(String value) {
            addCriterion("ispname <>", value, "ispname");
            return (Criteria) this;
        }

        public Criteria andIspnameGreaterThan(String value) {
            addCriterion("ispname >", value, "ispname");
            return (Criteria) this;
        }

        public Criteria andIspnameGreaterThanOrEqualTo(String value) {
            addCriterion("ispname >=", value, "ispname");
            return (Criteria) this;
        }

        public Criteria andIspnameLessThan(String value) {
            addCriterion("ispname <", value, "ispname");
            return (Criteria) this;
        }

        public Criteria andIspnameLessThanOrEqualTo(String value) {
            addCriterion("ispname <=", value, "ispname");
            return (Criteria) this;
        }

        public Criteria andIspnameLike(String value) {
            addCriterion("ispname like", value, "ispname");
            return (Criteria) this;
        }

        public Criteria andIspnameNotLike(String value) {
            addCriterion("ispname not like", value, "ispname");
            return (Criteria) this;
        }

        public Criteria andIspnameIn(List<String> values) {
            addCriterion("ispname in", values, "ispname");
            return (Criteria) this;
        }

        public Criteria andIspnameNotIn(List<String> values) {
            addCriterion("ispname not in", values, "ispname");
            return (Criteria) this;
        }

        public Criteria andIspnameBetween(String value1, String value2) {
            addCriterion("ispname between", value1, value2, "ispname");
            return (Criteria) this;
        }

        public Criteria andIspnameNotBetween(String value1, String value2) {
            addCriterion("ispname not between", value1, value2, "ispname");
            return (Criteria) this;
        }

        public Criteria andIspcodeIsNull() {
            addCriterion("ispcode is null");
            return (Criteria) this;
        }

        public Criteria andIspcodeIsNotNull() {
            addCriterion("ispcode is not null");
            return (Criteria) this;
        }

        public Criteria andIspcodeEqualTo(String value) {
            addCriterion("ispcode =", value, "ispcode");
            return (Criteria) this;
        }

        public Criteria andIspcodeNotEqualTo(String value) {
            addCriterion("ispcode <>", value, "ispcode");
            return (Criteria) this;
        }

        public Criteria andIspcodeGreaterThan(String value) {
            addCriterion("ispcode >", value, "ispcode");
            return (Criteria) this;
        }

        public Criteria andIspcodeGreaterThanOrEqualTo(String value) {
            addCriterion("ispcode >=", value, "ispcode");
            return (Criteria) this;
        }

        public Criteria andIspcodeLessThan(String value) {
            addCriterion("ispcode <", value, "ispcode");
            return (Criteria) this;
        }

        public Criteria andIspcodeLessThanOrEqualTo(String value) {
            addCriterion("ispcode <=", value, "ispcode");
            return (Criteria) this;
        }

        public Criteria andIspcodeLike(String value) {
            addCriterion("ispcode like", value, "ispcode");
            return (Criteria) this;
        }

        public Criteria andIspcodeNotLike(String value) {
            addCriterion("ispcode not like", value, "ispcode");
            return (Criteria) this;
        }

        public Criteria andIspcodeIn(List<String> values) {
            addCriterion("ispcode in", values, "ispcode");
            return (Criteria) this;
        }

        public Criteria andIspcodeNotIn(List<String> values) {
            addCriterion("ispcode not in", values, "ispcode");
            return (Criteria) this;
        }

        public Criteria andIspcodeBetween(String value1, String value2) {
            addCriterion("ispcode between", value1, value2, "ispcode");
            return (Criteria) this;
        }

        public Criteria andIspcodeNotBetween(String value1, String value2) {
            addCriterion("ispcode not between", value1, value2, "ispcode");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDutyIsNull() {
            addCriterion("duty is null");
            return (Criteria) this;
        }

        public Criteria andDutyIsNotNull() {
            addCriterion("duty is not null");
            return (Criteria) this;
        }

        public Criteria andDutyEqualTo(String value) {
            addCriterion("duty =", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotEqualTo(String value) {
            addCriterion("duty <>", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyGreaterThan(String value) {
            addCriterion("duty >", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyGreaterThanOrEqualTo(String value) {
            addCriterion("duty >=", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLessThan(String value) {
            addCriterion("duty <", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLessThanOrEqualTo(String value) {
            addCriterion("duty <=", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLike(String value) {
            addCriterion("duty like", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotLike(String value) {
            addCriterion("duty not like", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyIn(List<String> values) {
            addCriterion("duty in", values, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotIn(List<String> values) {
            addCriterion("duty not in", values, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyBetween(String value1, String value2) {
            addCriterion("duty between", value1, value2, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotBetween(String value1, String value2) {
            addCriterion("duty not between", value1, value2, "duty");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andIsptypeIsNull() {
            addCriterion("isptype is null");
            return (Criteria) this;
        }

        public Criteria andIsptypeIsNotNull() {
            addCriterion("isptype is not null");
            return (Criteria) this;
        }

        public Criteria andIsptypeEqualTo(String value) {
            addCriterion("isptype =", value, "isptype");
            return (Criteria) this;
        }

        public Criteria andIsptypeNotEqualTo(String value) {
            addCriterion("isptype <>", value, "isptype");
            return (Criteria) this;
        }

        public Criteria andIsptypeGreaterThan(String value) {
            addCriterion("isptype >", value, "isptype");
            return (Criteria) this;
        }

        public Criteria andIsptypeGreaterThanOrEqualTo(String value) {
            addCriterion("isptype >=", value, "isptype");
            return (Criteria) this;
        }

        public Criteria andIsptypeLessThan(String value) {
            addCriterion("isptype <", value, "isptype");
            return (Criteria) this;
        }

        public Criteria andIsptypeLessThanOrEqualTo(String value) {
            addCriterion("isptype <=", value, "isptype");
            return (Criteria) this;
        }

        public Criteria andIsptypeLike(String value) {
            addCriterion("isptype like", value, "isptype");
            return (Criteria) this;
        }

        public Criteria andIsptypeNotLike(String value) {
            addCriterion("isptype not like", value, "isptype");
            return (Criteria) this;
        }

        public Criteria andIsptypeIn(List<String> values) {
            addCriterion("isptype in", values, "isptype");
            return (Criteria) this;
        }

        public Criteria andIsptypeNotIn(List<String> values) {
            addCriterion("isptype not in", values, "isptype");
            return (Criteria) this;
        }

        public Criteria andIsptypeBetween(String value1, String value2) {
            addCriterion("isptype between", value1, value2, "isptype");
            return (Criteria) this;
        }

        public Criteria andIsptypeNotBetween(String value1, String value2) {
            addCriterion("isptype not between", value1, value2, "isptype");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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