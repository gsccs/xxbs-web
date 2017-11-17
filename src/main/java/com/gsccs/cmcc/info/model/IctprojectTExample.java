package com.gsccs.cmcc.info.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gsccs.plat.bass.BaseExample;

public class IctprojectTExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IctprojectTExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCorpnameIsNull() {
            addCriterion("corpname is null");
            return (Criteria) this;
        }

        public Criteria andCorpnameIsNotNull() {
            addCriterion("corpname is not null");
            return (Criteria) this;
        }

        public Criteria andCorpnameEqualTo(String value) {
            addCriterion("corpname =", value, "corpname");
            return (Criteria) this;
        }

        public Criteria andCorpnameNotEqualTo(String value) {
            addCriterion("corpname <>", value, "corpname");
            return (Criteria) this;
        }

        public Criteria andCorpnameGreaterThan(String value) {
            addCriterion("corpname >", value, "corpname");
            return (Criteria) this;
        }

        public Criteria andCorpnameGreaterThanOrEqualTo(String value) {
            addCriterion("corpname >=", value, "corpname");
            return (Criteria) this;
        }

        public Criteria andCorpnameLessThan(String value) {
            addCriterion("corpname <", value, "corpname");
            return (Criteria) this;
        }

        public Criteria andCorpnameLessThanOrEqualTo(String value) {
            addCriterion("corpname <=", value, "corpname");
            return (Criteria) this;
        }

        public Criteria andCorpnameLike(String value) {
            addCriterion("corpname like", value, "corpname");
            return (Criteria) this;
        }

        public Criteria andCorpnameNotLike(String value) {
            addCriterion("corpname not like", value, "corpname");
            return (Criteria) this;
        }

        public Criteria andCorpnameIn(List<String> values) {
            addCriterion("corpname in", values, "corpname");
            return (Criteria) this;
        }

        public Criteria andCorpnameNotIn(List<String> values) {
            addCriterion("corpname not in", values, "corpname");
            return (Criteria) this;
        }

        public Criteria andCorpnameBetween(String value1, String value2) {
            addCriterion("corpname between", value1, value2, "corpname");
            return (Criteria) this;
        }

        public Criteria andCorpnameNotBetween(String value1, String value2) {
            addCriterion("corpname not between", value1, value2, "corpname");
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

        public Criteria andBriefIsNull() {
            addCriterion("brief is null");
            return (Criteria) this;
        }

        public Criteria andBriefIsNotNull() {
            addCriterion("brief is not null");
            return (Criteria) this;
        }

        public Criteria andBriefEqualTo(String value) {
            addCriterion("brief =", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotEqualTo(String value) {
            addCriterion("brief <>", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThan(String value) {
            addCriterion("brief >", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThanOrEqualTo(String value) {
            addCriterion("brief >=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThan(String value) {
            addCriterion("brief <", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThanOrEqualTo(String value) {
            addCriterion("brief <=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLike(String value) {
            addCriterion("brief like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotLike(String value) {
            addCriterion("brief not like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefIn(List<String> values) {
            addCriterion("brief in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotIn(List<String> values) {
            addCriterion("brief not in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefBetween(String value1, String value2) {
            addCriterion("brief between", value1, value2, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotBetween(String value1, String value2) {
            addCriterion("brief not between", value1, value2, "brief");
            return (Criteria) this;
        }

        public Criteria andBuildcontentIsNull() {
            addCriterion("buildcontent is null");
            return (Criteria) this;
        }

        public Criteria andBuildcontentIsNotNull() {
            addCriterion("buildcontent is not null");
            return (Criteria) this;
        }

        public Criteria andBuildcontentEqualTo(String value) {
            addCriterion("buildcontent =", value, "buildcontent");
            return (Criteria) this;
        }

        public Criteria andBuildcontentNotEqualTo(String value) {
            addCriterion("buildcontent <>", value, "buildcontent");
            return (Criteria) this;
        }

        public Criteria andBuildcontentGreaterThan(String value) {
            addCriterion("buildcontent >", value, "buildcontent");
            return (Criteria) this;
        }

        public Criteria andBuildcontentGreaterThanOrEqualTo(String value) {
            addCriterion("buildcontent >=", value, "buildcontent");
            return (Criteria) this;
        }

        public Criteria andBuildcontentLessThan(String value) {
            addCriterion("buildcontent <", value, "buildcontent");
            return (Criteria) this;
        }

        public Criteria andBuildcontentLessThanOrEqualTo(String value) {
            addCriterion("buildcontent <=", value, "buildcontent");
            return (Criteria) this;
        }

        public Criteria andBuildcontentLike(String value) {
            addCriterion("buildcontent like", value, "buildcontent");
            return (Criteria) this;
        }

        public Criteria andBuildcontentNotLike(String value) {
            addCriterion("buildcontent not like", value, "buildcontent");
            return (Criteria) this;
        }

        public Criteria andBuildcontentIn(List<String> values) {
            addCriterion("buildcontent in", values, "buildcontent");
            return (Criteria) this;
        }

        public Criteria andBuildcontentNotIn(List<String> values) {
            addCriterion("buildcontent not in", values, "buildcontent");
            return (Criteria) this;
        }

        public Criteria andBuildcontentBetween(String value1, String value2) {
            addCriterion("buildcontent between", value1, value2, "buildcontent");
            return (Criteria) this;
        }

        public Criteria andBuildcontentNotBetween(String value1, String value2) {
            addCriterion("buildcontent not between", value1, value2, "buildcontent");
            return (Criteria) this;
        }

        public Criteria andUssmIsNull() {
            addCriterion("ussm is null");
            return (Criteria) this;
        }

        public Criteria andUssmIsNotNull() {
            addCriterion("ussm is not null");
            return (Criteria) this;
        }

        public Criteria andUssmEqualTo(Float value) {
            addCriterion("ussm =", value, "ussm");
            return (Criteria) this;
        }

        public Criteria andUssmNotEqualTo(Float value) {
            addCriterion("ussm <>", value, "ussm");
            return (Criteria) this;
        }

        public Criteria andUssmGreaterThan(Float value) {
            addCriterion("ussm >", value, "ussm");
            return (Criteria) this;
        }

        public Criteria andUssmGreaterThanOrEqualTo(Float value) {
            addCriterion("ussm >=", value, "ussm");
            return (Criteria) this;
        }

        public Criteria andUssmLessThan(Float value) {
            addCriterion("ussm <", value, "ussm");
            return (Criteria) this;
        }

        public Criteria andUssmLessThanOrEqualTo(Float value) {
            addCriterion("ussm <=", value, "ussm");
            return (Criteria) this;
        }

        public Criteria andUssmIn(List<Float> values) {
            addCriterion("ussm in", values, "ussm");
            return (Criteria) this;
        }

        public Criteria andUssmNotIn(List<Float> values) {
            addCriterion("ussm not in", values, "ussm");
            return (Criteria) this;
        }

        public Criteria andUssmBetween(Float value1, Float value2) {
            addCriterion("ussm between", value1, value2, "ussm");
            return (Criteria) this;
        }

        public Criteria andUssmNotBetween(Float value1, Float value2) {
            addCriterion("ussm not between", value1, value2, "ussm");
            return (Criteria) this;
        }

        public Criteria andWinnindateIsNull() {
            addCriterion("winnindate is null");
            return (Criteria) this;
        }

        public Criteria andWinnindateIsNotNull() {
            addCriterion("winnindate is not null");
            return (Criteria) this;
        }

        public Criteria andWinnindateEqualTo(Date value) {
            addCriterion("winnindate =", value, "winnindate");
            return (Criteria) this;
        }

        public Criteria andWinnindateNotEqualTo(Date value) {
            addCriterion("winnindate <>", value, "winnindate");
            return (Criteria) this;
        }

        public Criteria andWinnindateGreaterThan(Date value) {
            addCriterion("winnindate >", value, "winnindate");
            return (Criteria) this;
        }

        public Criteria andWinnindateGreaterThanOrEqualTo(Date value) {
            addCriterion("winnindate >=", value, "winnindate");
            return (Criteria) this;
        }

        public Criteria andWinnindateLessThan(Date value) {
            addCriterion("winnindate <", value, "winnindate");
            return (Criteria) this;
        }

        public Criteria andWinnindateLessThanOrEqualTo(Date value) {
            addCriterion("winnindate <=", value, "winnindate");
            return (Criteria) this;
        }

        public Criteria andWinnindateIn(List<Date> values) {
            addCriterion("winnindate in", values, "winnindate");
            return (Criteria) this;
        }

        public Criteria andWinnindateNotIn(List<Date> values) {
            addCriterion("winnindate not in", values, "winnindate");
            return (Criteria) this;
        }

        public Criteria andWinnindateBetween(Date value1, Date value2) {
            addCriterion("winnindate between", value1, value2, "winnindate");
            return (Criteria) this;
        }

        public Criteria andWinnindateNotBetween(Date value1, Date value2) {
            addCriterion("winnindate not between", value1, value2, "winnindate");
            return (Criteria) this;
        }

        public Criteria andSigndateIsNull() {
            addCriterion("signdate is null");
            return (Criteria) this;
        }

        public Criteria andSigndateIsNotNull() {
            addCriterion("signdate is not null");
            return (Criteria) this;
        }

        public Criteria andSigndateEqualTo(Date value) {
            addCriterion("signdate =", value, "signdate");
            return (Criteria) this;
        }

        public Criteria andSigndateNotEqualTo(Date value) {
            addCriterion("signdate <>", value, "signdate");
            return (Criteria) this;
        }

        public Criteria andSigndateGreaterThan(Date value) {
            addCriterion("signdate >", value, "signdate");
            return (Criteria) this;
        }

        public Criteria andSigndateGreaterThanOrEqualTo(Date value) {
            addCriterion("signdate >=", value, "signdate");
            return (Criteria) this;
        }

        public Criteria andSigndateLessThan(Date value) {
            addCriterion("signdate <", value, "signdate");
            return (Criteria) this;
        }

        public Criteria andSigndateLessThanOrEqualTo(Date value) {
            addCriterion("signdate <=", value, "signdate");
            return (Criteria) this;
        }

        public Criteria andSigndateIn(List<Date> values) {
            addCriterion("signdate in", values, "signdate");
            return (Criteria) this;
        }

        public Criteria andSigndateNotIn(List<Date> values) {
            addCriterion("signdate not in", values, "signdate");
            return (Criteria) this;
        }

        public Criteria andSigndateBetween(Date value1, Date value2) {
            addCriterion("signdate between", value1, value2, "signdate");
            return (Criteria) this;
        }

        public Criteria andSigndateNotBetween(Date value1, Date value2) {
            addCriterion("signdate not between", value1, value2, "signdate");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateIsNull() {
            addCriterion("planstartdate is null");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateIsNotNull() {
            addCriterion("planstartdate is not null");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateEqualTo(Date value) {
            addCriterion("planstartdate =", value, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateNotEqualTo(Date value) {
            addCriterion("planstartdate <>", value, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateGreaterThan(Date value) {
            addCriterion("planstartdate >", value, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateGreaterThanOrEqualTo(Date value) {
            addCriterion("planstartdate >=", value, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateLessThan(Date value) {
            addCriterion("planstartdate <", value, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateLessThanOrEqualTo(Date value) {
            addCriterion("planstartdate <=", value, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateIn(List<Date> values) {
            addCriterion("planstartdate in", values, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateNotIn(List<Date> values) {
            addCriterion("planstartdate not in", values, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateBetween(Date value1, Date value2) {
            addCriterion("planstartdate between", value1, value2, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateNotBetween(Date value1, Date value2) {
            addCriterion("planstartdate not between", value1, value2, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateIsNull() {
            addCriterion("planenddate is null");
            return (Criteria) this;
        }

        public Criteria andPlanenddateIsNotNull() {
            addCriterion("planenddate is not null");
            return (Criteria) this;
        }

        public Criteria andPlanenddateEqualTo(Date value) {
            addCriterion("planenddate =", value, "planenddate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateNotEqualTo(Date value) {
            addCriterion("planenddate <>", value, "planenddate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateGreaterThan(Date value) {
            addCriterion("planenddate >", value, "planenddate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("planenddate >=", value, "planenddate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateLessThan(Date value) {
            addCriterion("planenddate <", value, "planenddate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateLessThanOrEqualTo(Date value) {
            addCriterion("planenddate <=", value, "planenddate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateIn(List<Date> values) {
            addCriterion("planenddate in", values, "planenddate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateNotIn(List<Date> values) {
            addCriterion("planenddate not in", values, "planenddate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateBetween(Date value1, Date value2) {
            addCriterion("planenddate between", value1, value2, "planenddate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateNotBetween(Date value1, Date value2) {
            addCriterion("planenddate not between", value1, value2, "planenddate");
            return (Criteria) this;
        }

        public Criteria andRealstartdateIsNull() {
            addCriterion("realstartdate is null");
            return (Criteria) this;
        }

        public Criteria andRealstartdateIsNotNull() {
            addCriterion("realstartdate is not null");
            return (Criteria) this;
        }

        public Criteria andRealstartdateEqualTo(Date value) {
            addCriterion("realstartdate =", value, "realstartdate");
            return (Criteria) this;
        }

        public Criteria andRealstartdateNotEqualTo(Date value) {
            addCriterion("realstartdate <>", value, "realstartdate");
            return (Criteria) this;
        }

        public Criteria andRealstartdateGreaterThan(Date value) {
            addCriterion("realstartdate >", value, "realstartdate");
            return (Criteria) this;
        }

        public Criteria andRealstartdateGreaterThanOrEqualTo(Date value) {
            addCriterion("realstartdate >=", value, "realstartdate");
            return (Criteria) this;
        }

        public Criteria andRealstartdateLessThan(Date value) {
            addCriterion("realstartdate <", value, "realstartdate");
            return (Criteria) this;
        }

        public Criteria andRealstartdateLessThanOrEqualTo(Date value) {
            addCriterion("realstartdate <=", value, "realstartdate");
            return (Criteria) this;
        }

        public Criteria andRealstartdateIn(List<Date> values) {
            addCriterion("realstartdate in", values, "realstartdate");
            return (Criteria) this;
        }

        public Criteria andRealstartdateNotIn(List<Date> values) {
            addCriterion("realstartdate not in", values, "realstartdate");
            return (Criteria) this;
        }

        public Criteria andRealstartdateBetween(Date value1, Date value2) {
            addCriterion("realstartdate between", value1, value2, "realstartdate");
            return (Criteria) this;
        }

        public Criteria andRealstartdateNotBetween(Date value1, Date value2) {
            addCriterion("realstartdate not between", value1, value2, "realstartdate");
            return (Criteria) this;
        }

        public Criteria andRealenddateIsNull() {
            addCriterion("realenddate is null");
            return (Criteria) this;
        }

        public Criteria andRealenddateIsNotNull() {
            addCriterion("realenddate is not null");
            return (Criteria) this;
        }

        public Criteria andRealenddateEqualTo(Date value) {
            addCriterion("realenddate =", value, "realenddate");
            return (Criteria) this;
        }

        public Criteria andRealenddateNotEqualTo(Date value) {
            addCriterion("realenddate <>", value, "realenddate");
            return (Criteria) this;
        }

        public Criteria andRealenddateGreaterThan(Date value) {
            addCriterion("realenddate >", value, "realenddate");
            return (Criteria) this;
        }

        public Criteria andRealenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("realenddate >=", value, "realenddate");
            return (Criteria) this;
        }

        public Criteria andRealenddateLessThan(Date value) {
            addCriterion("realenddate <", value, "realenddate");
            return (Criteria) this;
        }

        public Criteria andRealenddateLessThanOrEqualTo(Date value) {
            addCriterion("realenddate <=", value, "realenddate");
            return (Criteria) this;
        }

        public Criteria andRealenddateIn(List<Date> values) {
            addCriterion("realenddate in", values, "realenddate");
            return (Criteria) this;
        }

        public Criteria andRealenddateNotIn(List<Date> values) {
            addCriterion("realenddate not in", values, "realenddate");
            return (Criteria) this;
        }

        public Criteria andRealenddateBetween(Date value1, Date value2) {
            addCriterion("realenddate between", value1, value2, "realenddate");
            return (Criteria) this;
        }

        public Criteria andRealenddateNotBetween(Date value1, Date value2) {
            addCriterion("realenddate not between", value1, value2, "realenddate");
            return (Criteria) this;
        }

        public Criteria andBuilddaysIsNull() {
            addCriterion("builddays is null");
            return (Criteria) this;
        }

        public Criteria andBuilddaysIsNotNull() {
            addCriterion("builddays is not null");
            return (Criteria) this;
        }

        public Criteria andBuilddaysEqualTo(Integer value) {
            addCriterion("builddays =", value, "builddays");
            return (Criteria) this;
        }

        public Criteria andBuilddaysNotEqualTo(Integer value) {
            addCriterion("builddays <>", value, "builddays");
            return (Criteria) this;
        }

        public Criteria andBuilddaysGreaterThan(Integer value) {
            addCriterion("builddays >", value, "builddays");
            return (Criteria) this;
        }

        public Criteria andBuilddaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("builddays >=", value, "builddays");
            return (Criteria) this;
        }

        public Criteria andBuilddaysLessThan(Integer value) {
            addCriterion("builddays <", value, "builddays");
            return (Criteria) this;
        }

        public Criteria andBuilddaysLessThanOrEqualTo(Integer value) {
            addCriterion("builddays <=", value, "builddays");
            return (Criteria) this;
        }

        public Criteria andBuilddaysIn(List<Integer> values) {
            addCriterion("builddays in", values, "builddays");
            return (Criteria) this;
        }

        public Criteria andBuilddaysNotIn(List<Integer> values) {
            addCriterion("builddays not in", values, "builddays");
            return (Criteria) this;
        }

        public Criteria andBuilddaysBetween(Integer value1, Integer value2) {
            addCriterion("builddays between", value1, value2, "builddays");
            return (Criteria) this;
        }

        public Criteria andBuilddaysNotBetween(Integer value1, Integer value2) {
            addCriterion("builddays not between", value1, value2, "builddays");
            return (Criteria) this;
        }

        public Criteria andConstructionIsNull() {
            addCriterion("construction is null");
            return (Criteria) this;
        }

        public Criteria andConstructionIsNotNull() {
            addCriterion("construction is not null");
            return (Criteria) this;
        }

        public Criteria andConstructionEqualTo(String value) {
            addCriterion("construction =", value, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionNotEqualTo(String value) {
            addCriterion("construction <>", value, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionGreaterThan(String value) {
            addCriterion("construction >", value, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionGreaterThanOrEqualTo(String value) {
            addCriterion("construction >=", value, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionLessThan(String value) {
            addCriterion("construction <", value, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionLessThanOrEqualTo(String value) {
            addCriterion("construction <=", value, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionLike(String value) {
            addCriterion("construction like", value, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionNotLike(String value) {
            addCriterion("construction not like", value, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionIn(List<String> values) {
            addCriterion("construction in", values, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionNotIn(List<String> values) {
            addCriterion("construction not in", values, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionBetween(String value1, String value2) {
            addCriterion("construction between", value1, value2, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionNotBetween(String value1, String value2) {
            addCriterion("construction not between", value1, value2, "construction");
            return (Criteria) this;
        }

        public Criteria andPlanlandussmIsNull() {
            addCriterion("planlandussm is null");
            return (Criteria) this;
        }

        public Criteria andPlanlandussmIsNotNull() {
            addCriterion("planlandussm is not null");
            return (Criteria) this;
        }

        public Criteria andPlanlandussmEqualTo(Float value) {
            addCriterion("planlandussm =", value, "planlandussm");
            return (Criteria) this;
        }

        public Criteria andPlanlandussmNotEqualTo(Float value) {
            addCriterion("planlandussm <>", value, "planlandussm");
            return (Criteria) this;
        }

        public Criteria andPlanlandussmGreaterThan(Float value) {
            addCriterion("planlandussm >", value, "planlandussm");
            return (Criteria) this;
        }

        public Criteria andPlanlandussmGreaterThanOrEqualTo(Float value) {
            addCriterion("planlandussm >=", value, "planlandussm");
            return (Criteria) this;
        }

        public Criteria andPlanlandussmLessThan(Float value) {
            addCriterion("planlandussm <", value, "planlandussm");
            return (Criteria) this;
        }

        public Criteria andPlanlandussmLessThanOrEqualTo(Float value) {
            addCriterion("planlandussm <=", value, "planlandussm");
            return (Criteria) this;
        }

        public Criteria andPlanlandussmIn(List<Float> values) {
            addCriterion("planlandussm in", values, "planlandussm");
            return (Criteria) this;
        }

        public Criteria andPlanlandussmNotIn(List<Float> values) {
            addCriterion("planlandussm not in", values, "planlandussm");
            return (Criteria) this;
        }

        public Criteria andPlanlandussmBetween(Float value1, Float value2) {
            addCriterion("planlandussm between", value1, value2, "planlandussm");
            return (Criteria) this;
        }

        public Criteria andPlanlandussmNotBetween(Float value1, Float value2) {
            addCriterion("planlandussm not between", value1, value2, "planlandussm");
            return (Criteria) this;
        }

        public Criteria andPlanlanddateIsNull() {
            addCriterion("planlanddate is null");
            return (Criteria) this;
        }

        public Criteria andPlanlanddateIsNotNull() {
            addCriterion("planlanddate is not null");
            return (Criteria) this;
        }

        public Criteria andPlanlanddateEqualTo(Date value) {
            addCriterion("planlanddate =", value, "planlanddate");
            return (Criteria) this;
        }

        public Criteria andPlanlanddateNotEqualTo(Date value) {
            addCriterion("planlanddate <>", value, "planlanddate");
            return (Criteria) this;
        }

        public Criteria andPlanlanddateGreaterThan(Date value) {
            addCriterion("planlanddate >", value, "planlanddate");
            return (Criteria) this;
        }

        public Criteria andPlanlanddateGreaterThanOrEqualTo(Date value) {
            addCriterion("planlanddate >=", value, "planlanddate");
            return (Criteria) this;
        }

        public Criteria andPlanlanddateLessThan(Date value) {
            addCriterion("planlanddate <", value, "planlanddate");
            return (Criteria) this;
        }

        public Criteria andPlanlanddateLessThanOrEqualTo(Date value) {
            addCriterion("planlanddate <=", value, "planlanddate");
            return (Criteria) this;
        }

        public Criteria andPlanlanddateIn(List<Date> values) {
            addCriterion("planlanddate in", values, "planlanddate");
            return (Criteria) this;
        }

        public Criteria andPlanlanddateNotIn(List<Date> values) {
            addCriterion("planlanddate not in", values, "planlanddate");
            return (Criteria) this;
        }

        public Criteria andPlanlanddateBetween(Date value1, Date value2) {
            addCriterion("planlanddate between", value1, value2, "planlanddate");
            return (Criteria) this;
        }

        public Criteria andPlanlanddateNotBetween(Date value1, Date value2) {
            addCriterion("planlanddate not between", value1, value2, "planlanddate");
            return (Criteria) this;
        }

        public Criteria andAmuseridIsNull() {
            addCriterion("amuserid is null");
            return (Criteria) this;
        }

        public Criteria andAmuseridIsNotNull() {
            addCriterion("amuserid is not null");
            return (Criteria) this;
        }

        public Criteria andAmuseridEqualTo(String value) {
            addCriterion("amuserid =", value, "amuserid");
            return (Criteria) this;
        }

        public Criteria andAmuseridNotEqualTo(String value) {
            addCriterion("amuserid <>", value, "amuserid");
            return (Criteria) this;
        }

        public Criteria andAmuseridGreaterThan(String value) {
            addCriterion("amuserid >", value, "amuserid");
            return (Criteria) this;
        }

        public Criteria andAmuseridGreaterThanOrEqualTo(String value) {
            addCriterion("amuserid >=", value, "amuserid");
            return (Criteria) this;
        }

        public Criteria andAmuseridLessThan(String value) {
            addCriterion("amuserid <", value, "amuserid");
            return (Criteria) this;
        }

        public Criteria andAmuseridLessThanOrEqualTo(String value) {
            addCriterion("amuserid <=", value, "amuserid");
            return (Criteria) this;
        }

        public Criteria andAmuseridLike(String value) {
            addCriterion("amuserid like", value, "amuserid");
            return (Criteria) this;
        }

        public Criteria andAmuseridNotLike(String value) {
            addCriterion("amuserid not like", value, "amuserid");
            return (Criteria) this;
        }

        public Criteria andAmuseridIn(List<String> values) {
            addCriterion("amuserid in", values, "amuserid");
            return (Criteria) this;
        }

        public Criteria andAmuseridNotIn(List<String> values) {
            addCriterion("amuserid not in", values, "amuserid");
            return (Criteria) this;
        }

        public Criteria andAmuseridBetween(String value1, String value2) {
            addCriterion("amuserid between", value1, value2, "amuserid");
            return (Criteria) this;
        }

        public Criteria andAmuseridNotBetween(String value1, String value2) {
            addCriterion("amuserid not between", value1, value2, "amuserid");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
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

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCooperIsNull() {
            addCriterion("cooper is null");
            return (Criteria) this;
        }

        public Criteria andCooperIsNotNull() {
            addCriterion("cooper is not null");
            return (Criteria) this;
        }

        public Criteria andCooperEqualTo(String value) {
            addCriterion("cooper =", value, "cooper");
            return (Criteria) this;
        }

        public Criteria andCooperNotEqualTo(String value) {
            addCriterion("cooper <>", value, "cooper");
            return (Criteria) this;
        }

        public Criteria andCooperGreaterThan(String value) {
            addCriterion("cooper >", value, "cooper");
            return (Criteria) this;
        }

        public Criteria andCooperGreaterThanOrEqualTo(String value) {
            addCriterion("cooper >=", value, "cooper");
            return (Criteria) this;
        }

        public Criteria andCooperLessThan(String value) {
            addCriterion("cooper <", value, "cooper");
            return (Criteria) this;
        }

        public Criteria andCooperLessThanOrEqualTo(String value) {
            addCriterion("cooper <=", value, "cooper");
            return (Criteria) this;
        }

        public Criteria andCooperLike(String value) {
            addCriterion("cooper like", value, "cooper");
            return (Criteria) this;
        }

        public Criteria andCooperNotLike(String value) {
            addCriterion("cooper not like", value, "cooper");
            return (Criteria) this;
        }

        public Criteria andCooperIn(List<String> values) {
            addCriterion("cooper in", values, "cooper");
            return (Criteria) this;
        }

        public Criteria andCooperNotIn(List<String> values) {
            addCriterion("cooper not in", values, "cooper");
            return (Criteria) this;
        }

        public Criteria andCooperBetween(String value1, String value2) {
            addCriterion("cooper between", value1, value2, "cooper");
            return (Criteria) this;
        }

        public Criteria andCooperNotBetween(String value1, String value2) {
            addCriterion("cooper not between", value1, value2, "cooper");
            return (Criteria) this;
        }

        public Criteria andOrdernumIsNull() {
            addCriterion("ordernum is null");
            return (Criteria) this;
        }

        public Criteria andOrdernumIsNotNull() {
            addCriterion("ordernum is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernumEqualTo(Integer value) {
            addCriterion("ordernum =", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotEqualTo(Integer value) {
            addCriterion("ordernum <>", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThan(Integer value) {
            addCriterion("ordernum >", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ordernum >=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThan(Integer value) {
            addCriterion("ordernum <", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThanOrEqualTo(Integer value) {
            addCriterion("ordernum <=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumIn(List<Integer> values) {
            addCriterion("ordernum in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotIn(List<Integer> values) {
            addCriterion("ordernum not in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumBetween(Integer value1, Integer value2) {
            addCriterion("ordernum between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotBetween(Integer value1, Integer value2) {
            addCriterion("ordernum not between", value1, value2, "ordernum");
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