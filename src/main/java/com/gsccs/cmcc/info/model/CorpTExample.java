package com.gsccs.cmcc.info.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gsccs.plat.bass.BaseExample;

public class CorpTExample extends BaseExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public CorpTExample() {
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
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

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andOrgcodeIsNull() {
			addCriterion("orgcode is null");
			return (Criteria) this;
		}

		public Criteria andOrgcodeIsNotNull() {
			addCriterion("orgcode is not null");
			return (Criteria) this;
		}

		public Criteria andOrgcodeEqualTo(String value) {
			addCriterion("orgcode =", value, "orgcode");
			return (Criteria) this;
		}

		public Criteria andOrgcodeNotEqualTo(String value) {
			addCriterion("orgcode <>", value, "orgcode");
			return (Criteria) this;
		}

		public Criteria andOrgcodeGreaterThan(String value) {
			addCriterion("orgcode >", value, "orgcode");
			return (Criteria) this;
		}

		public Criteria andOrgcodeGreaterThanOrEqualTo(String value) {
			addCriterion("orgcode >=", value, "orgcode");
			return (Criteria) this;
		}

		public Criteria andOrgcodeLessThan(String value) {
			addCriterion("orgcode <", value, "orgcode");
			return (Criteria) this;
		}

		public Criteria andOrgcodeLessThanOrEqualTo(String value) {
			addCriterion("orgcode <=", value, "orgcode");
			return (Criteria) this;
		}

		public Criteria andOrgcodeLike(String value) {
			addCriterion("orgcode like", value, "orgcode");
			return (Criteria) this;
		}

		public Criteria andOrgcodeNotLike(String value) {
			addCriterion("orgcode not like", value, "orgcode");
			return (Criteria) this;
		}

		public Criteria andOrgcodeIn(List<String> values) {
			addCriterion("orgcode in", values, "orgcode");
			return (Criteria) this;
		}

		public Criteria andOrgcodeNotIn(List<String> values) {
			addCriterion("orgcode not in", values, "orgcode");
			return (Criteria) this;
		}

		public Criteria andOrgcodeBetween(String value1, String value2) {
			addCriterion("orgcode between", value1, value2, "orgcode");
			return (Criteria) this;
		}

		public Criteria andOrgcodeNotBetween(String value1, String value2) {
			addCriterion("orgcode not between", value1, value2, "orgcode");
			return (Criteria) this;
		}

		public Criteria andRegcodeIsNull() {
			addCriterion("regcode is null");
			return (Criteria) this;
		}

		public Criteria andRegcodeIsNotNull() {
			addCriterion("regcode is not null");
			return (Criteria) this;
		}

		public Criteria andRegcodeEqualTo(String value) {
			addCriterion("regcode =", value, "regcode");
			return (Criteria) this;
		}

		public Criteria andRegcodeNotEqualTo(String value) {
			addCriterion("regcode <>", value, "regcode");
			return (Criteria) this;
		}

		public Criteria andRegcodeGreaterThan(String value) {
			addCriterion("regcode >", value, "regcode");
			return (Criteria) this;
		}

		public Criteria andRegcodeGreaterThanOrEqualTo(String value) {
			addCriterion("regcode >=", value, "regcode");
			return (Criteria) this;
		}

		public Criteria andRegcodeLessThan(String value) {
			addCriterion("regcode <", value, "regcode");
			return (Criteria) this;
		}

		public Criteria andRegcodeLessThanOrEqualTo(String value) {
			addCriterion("regcode <=", value, "regcode");
			return (Criteria) this;
		}

		public Criteria andRegcodeLike(String value) {
			addCriterion("regcode like", value, "regcode");
			return (Criteria) this;
		}

		public Criteria andRegcodeNotLike(String value) {
			addCriterion("regcode not like", value, "regcode");
			return (Criteria) this;
		}

		public Criteria andRegcodeIn(List<String> values) {
			addCriterion("regcode in", values, "regcode");
			return (Criteria) this;
		}

		public Criteria andRegcodeNotIn(List<String> values) {
			addCriterion("regcode not in", values, "regcode");
			return (Criteria) this;
		}

		public Criteria andRegcodeBetween(String value1, String value2) {
			addCriterion("regcode between", value1, value2, "regcode");
			return (Criteria) this;
		}

		public Criteria andRegcodeNotBetween(String value1, String value2) {
			addCriterion("regcode not between", value1, value2, "regcode");
			return (Criteria) this;
		}

		public Criteria andRegtypeIsNull() {
			addCriterion("regtype is null");
			return (Criteria) this;
		}

		public Criteria andRegtypeIsNotNull() {
			addCriterion("regtype is not null");
			return (Criteria) this;
		}

		public Criteria andRegtypeEqualTo(String value) {
			addCriterion("regtype =", value, "regtype");
			return (Criteria) this;
		}

		public Criteria andRegtypeNotEqualTo(String value) {
			addCriterion("regtype <>", value, "regtype");
			return (Criteria) this;
		}

		public Criteria andRegtypeGreaterThan(String value) {
			addCriterion("regtype >", value, "regtype");
			return (Criteria) this;
		}

		public Criteria andRegtypeGreaterThanOrEqualTo(String value) {
			addCriterion("regtype >=", value, "regtype");
			return (Criteria) this;
		}

		public Criteria andRegtypeLessThan(String value) {
			addCriterion("regtype <", value, "regtype");
			return (Criteria) this;
		}

		public Criteria andRegtypeLessThanOrEqualTo(String value) {
			addCriterion("regtype <=", value, "regtype");
			return (Criteria) this;
		}

		public Criteria andRegtypeLike(String value) {
			addCriterion("regtype like", value, "regtype");
			return (Criteria) this;
		}

		public Criteria andRegtypeNotLike(String value) {
			addCriterion("regtype not like", value, "regtype");
			return (Criteria) this;
		}

		public Criteria andRegtypeIn(List<String> values) {
			addCriterion("regtype in", values, "regtype");
			return (Criteria) this;
		}

		public Criteria andRegtypeNotIn(List<String> values) {
			addCriterion("regtype not in", values, "regtype");
			return (Criteria) this;
		}

		public Criteria andRegtypeBetween(String value1, String value2) {
			addCriterion("regtype between", value1, value2, "regtype");
			return (Criteria) this;
		}

		public Criteria andRegtypeNotBetween(String value1, String value2) {
			addCriterion("regtype not between", value1, value2, "regtype");
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

		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("email is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("email in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("email not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andDomainIsNull() {
			addCriterion("domain is null");
			return (Criteria) this;
		}

		public Criteria andDomainIsNotNull() {
			addCriterion("domain is not null");
			return (Criteria) this;
		}

		public Criteria andDomainEqualTo(String value) {
			addCriterion("domain =", value, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainNotEqualTo(String value) {
			addCriterion("domain <>", value, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainGreaterThan(String value) {
			addCriterion("domain >", value, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainGreaterThanOrEqualTo(String value) {
			addCriterion("domain >=", value, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainLessThan(String value) {
			addCriterion("domain <", value, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainLessThanOrEqualTo(String value) {
			addCriterion("domain <=", value, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainLike(String value) {
			addCriterion("domain like", value, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainNotLike(String value) {
			addCriterion("domain not like", value, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainIn(List<String> values) {
			addCriterion("domain in", values, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainNotIn(List<String> values) {
			addCriterion("domain not in", values, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainBetween(String value1, String value2) {
			addCriterion("domain between", value1, value2, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainNotBetween(String value1, String value2) {
			addCriterion("domain not between", value1, value2, "domain");
			return (Criteria) this;
		}

		public Criteria andNatureIsNull() {
			addCriterion("nature is null");
			return (Criteria) this;
		}

		public Criteria andNatureIsNotNull() {
			addCriterion("nature is not null");
			return (Criteria) this;
		}

		public Criteria andNatureEqualTo(String value) {
			addCriterion("nature =", value, "nature");
			return (Criteria) this;
		}

		public Criteria andNatureNotEqualTo(String value) {
			addCriterion("nature <>", value, "nature");
			return (Criteria) this;
		}

		public Criteria andNatureGreaterThan(String value) {
			addCriterion("nature >", value, "nature");
			return (Criteria) this;
		}

		public Criteria andNatureGreaterThanOrEqualTo(String value) {
			addCriterion("nature >=", value, "nature");
			return (Criteria) this;
		}

		public Criteria andNatureLessThan(String value) {
			addCriterion("nature <", value, "nature");
			return (Criteria) this;
		}

		public Criteria andNatureLessThanOrEqualTo(String value) {
			addCriterion("nature <=", value, "nature");
			return (Criteria) this;
		}

		public Criteria andNatureLike(String value) {
			addCriterion("nature like", value, "nature");
			return (Criteria) this;
		}

		public Criteria andNatureNotLike(String value) {
			addCriterion("nature not like", value, "nature");
			return (Criteria) this;
		}

		public Criteria andNatureIn(List<String> values) {
			addCriterion("nature in", values, "nature");
			return (Criteria) this;
		}

		public Criteria andNatureNotIn(List<String> values) {
			addCriterion("nature not in", values, "nature");
			return (Criteria) this;
		}

		public Criteria andNatureBetween(String value1, String value2) {
			addCriterion("nature between", value1, value2, "nature");
			return (Criteria) this;
		}

		public Criteria andNatureNotBetween(String value1, String value2) {
			addCriterion("nature not between", value1, value2, "nature");
			return (Criteria) this;
		}

		public Criteria andLegalerIsNull() {
			addCriterion("legaler is null");
			return (Criteria) this;
		}

		public Criteria andLegalerIsNotNull() {
			addCriterion("legaler is not null");
			return (Criteria) this;
		}

		public Criteria andLegalerEqualTo(String value) {
			addCriterion("legaler =", value, "legaler");
			return (Criteria) this;
		}

		public Criteria andLegalerNotEqualTo(String value) {
			addCriterion("legaler <>", value, "legaler");
			return (Criteria) this;
		}

		public Criteria andLegalerGreaterThan(String value) {
			addCriterion("legaler >", value, "legaler");
			return (Criteria) this;
		}

		public Criteria andLegalerGreaterThanOrEqualTo(String value) {
			addCriterion("legaler >=", value, "legaler");
			return (Criteria) this;
		}

		public Criteria andLegalerLessThan(String value) {
			addCriterion("legaler <", value, "legaler");
			return (Criteria) this;
		}

		public Criteria andLegalerLessThanOrEqualTo(String value) {
			addCriterion("legaler <=", value, "legaler");
			return (Criteria) this;
		}

		public Criteria andLegalerLike(String value) {
			addCriterion("legaler like", value, "legaler");
			return (Criteria) this;
		}

		public Criteria andLegalerNotLike(String value) {
			addCriterion("legaler not like", value, "legaler");
			return (Criteria) this;
		}

		public Criteria andLegalerIn(List<String> values) {
			addCriterion("legaler in", values, "legaler");
			return (Criteria) this;
		}

		public Criteria andLegalerNotIn(List<String> values) {
			addCriterion("legaler not in", values, "legaler");
			return (Criteria) this;
		}

		public Criteria andLegalerBetween(String value1, String value2) {
			addCriterion("legaler between", value1, value2, "legaler");
			return (Criteria) this;
		}

		public Criteria andLegalerNotBetween(String value1, String value2) {
			addCriterion("legaler not between", value1, value2, "legaler");
			return (Criteria) this;
		}

		public Criteria andLinkerIsNull() {
			addCriterion("linker is null");
			return (Criteria) this;
		}

		public Criteria andLinkerIsNotNull() {
			addCriterion("linker is not null");
			return (Criteria) this;
		}

		public Criteria andLinkerEqualTo(String value) {
			addCriterion("linker =", value, "linker");
			return (Criteria) this;
		}

		public Criteria andLinkerNotEqualTo(String value) {
			addCriterion("linker <>", value, "linker");
			return (Criteria) this;
		}

		public Criteria andLinkerGreaterThan(String value) {
			addCriterion("linker >", value, "linker");
			return (Criteria) this;
		}

		public Criteria andLinkerGreaterThanOrEqualTo(String value) {
			addCriterion("linker >=", value, "linker");
			return (Criteria) this;
		}

		public Criteria andLinkerLessThan(String value) {
			addCriterion("linker <", value, "linker");
			return (Criteria) this;
		}

		public Criteria andLinkerLessThanOrEqualTo(String value) {
			addCriterion("linker <=", value, "linker");
			return (Criteria) this;
		}

		public Criteria andLinkerLike(String value) {
			addCriterion("linker like", value, "linker");
			return (Criteria) this;
		}

		public Criteria andLinkerNotLike(String value) {
			addCriterion("linker not like", value, "linker");
			return (Criteria) this;
		}

		public Criteria andLinkerIn(List<String> values) {
			addCriterion("linker in", values, "linker");
			return (Criteria) this;
		}

		public Criteria andLinkerNotIn(List<String> values) {
			addCriterion("linker not in", values, "linker");
			return (Criteria) this;
		}

		public Criteria andLinkerBetween(String value1, String value2) {
			addCriterion("linker between", value1, value2, "linker");
			return (Criteria) this;
		}

		public Criteria andLinkerNotBetween(String value1, String value2) {
			addCriterion("linker not between", value1, value2, "linker");
			return (Criteria) this;
		}

		public Criteria andAcodeIsNull() {
			addCriterion("acode is null");
			return (Criteria) this;
		}

		public Criteria andAcodeIsNotNull() {
			addCriterion("acode is not null");
			return (Criteria) this;
		}

		public Criteria andAcodeEqualTo(Integer value) {
			addCriterion("acode =", value, "acode");
			return (Criteria) this;
		}

		public Criteria andAcodeNotEqualTo(String value) {
			addCriterion("acode <>", value, "acode");
			return (Criteria) this;
		}

		
		public Criteria andAcodeIn(List<String> values) {
			addCriterion("acode in", values, "acode");
			return (Criteria) this;
		}

		public Criteria andAcodeIn(String ids) {
			addCriterion("acode in (" + ids + ")");
			return (Criteria) this;
		}

		public Criteria andAcodeNotIn(List<String> values) {
			addCriterion("acode not in", values, "acode");
			return (Criteria) this;
		}

		public Criteria andAcodeBetween(String value1, String value2) {
			addCriterion("acode between", value1, value2, "acode");
			return (Criteria) this;
		}

		public Criteria andAcodeNotBetween(String value1, String value2) {
			addCriterion("acode not between", value1, value2, "acode");
			return (Criteria) this;
		}

		public Criteria andAddressIsNull() {
			addCriterion("address is null");
			return (Criteria) this;
		}

		public Criteria andAddressIsNotNull() {
			addCriterion("address is not null");
			return (Criteria) this;
		}

		public Criteria andAddressEqualTo(String value) {
			addCriterion("address =", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotEqualTo(String value) {
			addCriterion("address <>", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThan(String value) {
			addCriterion("address >", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThanOrEqualTo(String value) {
			addCriterion("address >=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThan(String value) {
			addCriterion("address <", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThanOrEqualTo(String value) {
			addCriterion("address <=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLike(String value) {
			addCriterion("address like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotLike(String value) {
			addCriterion("address not like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressIn(List<String> values) {
			addCriterion("address in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotIn(List<String> values) {
			addCriterion("address not in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressBetween(String value1, String value2) {
			addCriterion("address between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotBetween(String value1, String value2) {
			addCriterion("address not between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andZipcodeIsNull() {
			addCriterion("zipcode is null");
			return (Criteria) this;
		}

		public Criteria andZipcodeIsNotNull() {
			addCriterion("zipcode is not null");
			return (Criteria) this;
		}

		public Criteria andZipcodeEqualTo(String value) {
			addCriterion("zipcode =", value, "zipcode");
			return (Criteria) this;
		}

		public Criteria andZipcodeNotEqualTo(String value) {
			addCriterion("zipcode <>", value, "zipcode");
			return (Criteria) this;
		}

		public Criteria andZipcodeGreaterThan(String value) {
			addCriterion("zipcode >", value, "zipcode");
			return (Criteria) this;
		}

		public Criteria andZipcodeGreaterThanOrEqualTo(String value) {
			addCriterion("zipcode >=", value, "zipcode");
			return (Criteria) this;
		}

		public Criteria andZipcodeLessThan(String value) {
			addCriterion("zipcode <", value, "zipcode");
			return (Criteria) this;
		}

		public Criteria andZipcodeLessThanOrEqualTo(String value) {
			addCriterion("zipcode <=", value, "zipcode");
			return (Criteria) this;
		}

		public Criteria andZipcodeLike(String value) {
			addCriterion("zipcode like", value, "zipcode");
			return (Criteria) this;
		}

		public Criteria andZipcodeNotLike(String value) {
			addCriterion("zipcode not like", value, "zipcode");
			return (Criteria) this;
		}

		public Criteria andZipcodeIn(List<String> values) {
			addCriterion("zipcode in", values, "zipcode");
			return (Criteria) this;
		}

		public Criteria andZipcodeNotIn(List<String> values) {
			addCriterion("zipcode not in", values, "zipcode");
			return (Criteria) this;
		}

		public Criteria andZipcodeBetween(String value1, String value2) {
			addCriterion("zipcode between", value1, value2, "zipcode");
			return (Criteria) this;
		}

		public Criteria andZipcodeNotBetween(String value1, String value2) {
			addCriterion("zipcode not between", value1, value2, "zipcode");
			return (Criteria) this;
		}

		public Criteria andQqcodeIsNull() {
			addCriterion("qqcode is null");
			return (Criteria) this;
		}

		public Criteria andQqcodeIsNotNull() {
			addCriterion("qqcode is not null");
			return (Criteria) this;
		}

		public Criteria andQqcodeEqualTo(String value) {
			addCriterion("qqcode =", value, "qqcode");
			return (Criteria) this;
		}

		public Criteria andQqcodeNotEqualTo(String value) {
			addCriterion("qqcode <>", value, "qqcode");
			return (Criteria) this;
		}

		public Criteria andQqcodeGreaterThan(String value) {
			addCriterion("qqcode >", value, "qqcode");
			return (Criteria) this;
		}

		public Criteria andQqcodeGreaterThanOrEqualTo(String value) {
			addCriterion("qqcode >=", value, "qqcode");
			return (Criteria) this;
		}

		public Criteria andQqcodeLessThan(String value) {
			addCriterion("qqcode <", value, "qqcode");
			return (Criteria) this;
		}

		public Criteria andQqcodeLessThanOrEqualTo(String value) {
			addCriterion("qqcode <=", value, "qqcode");
			return (Criteria) this;
		}

		public Criteria andQqcodeLike(String value) {
			addCriterion("qqcode like", value, "qqcode");
			return (Criteria) this;
		}

		public Criteria andQqcodeNotLike(String value) {
			addCriterion("qqcode not like", value, "qqcode");
			return (Criteria) this;
		}

		public Criteria andQqcodeIn(List<String> values) {
			addCriterion("qqcode in", values, "qqcode");
			return (Criteria) this;
		}

		public Criteria andQqcodeNotIn(List<String> values) {
			addCriterion("qqcode not in", values, "qqcode");
			return (Criteria) this;
		}

		public Criteria andQqcodeBetween(String value1, String value2) {
			addCriterion("qqcode between", value1, value2, "qqcode");
			return (Criteria) this;
		}

		public Criteria andQqcodeNotBetween(String value1, String value2) {
			addCriterion("qqcode not between", value1, value2, "qqcode");
			return (Criteria) this;
		}

		public Criteria andCreatedIsNull() {
			addCriterion("created is null");
			return (Criteria) this;
		}

		public Criteria andCreatedIsNotNull() {
			addCriterion("created is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedEqualTo(String value) {
			addCriterion("created =", value, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedNotEqualTo(String value) {
			addCriterion("created <>", value, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedGreaterThan(String value) {
			addCriterion("created >", value, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedGreaterThanOrEqualTo(String value) {
			addCriterion("created >=", value, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedLessThan(String value) {
			addCriterion("created <", value, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedLessThanOrEqualTo(String value) {
			addCriterion("created <=", value, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedLike(String value) {
			addCriterion("created like", value, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedNotLike(String value) {
			addCriterion("created not like", value, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedIn(List<String> values) {
			addCriterion("created in", values, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedNotIn(List<String> values) {
			addCriterion("created not in", values, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedBetween(String value1, String value2) {
			addCriterion("created between", value1, value2, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedNotBetween(String value1, String value2) {
			addCriterion("created not between", value1, value2, "created");
			return (Criteria) this;
		}

		public Criteria andLogoIsNull() {
			addCriterion("logo is null");
			return (Criteria) this;
		}

		public Criteria andLogoIsNotNull() {
			addCriterion("logo is not null");
			return (Criteria) this;
		}

		public Criteria andLogoEqualTo(String value) {
			addCriterion("logo =", value, "logo");
			return (Criteria) this;
		}

		public Criteria andLogoNotEqualTo(String value) {
			addCriterion("logo <>", value, "logo");
			return (Criteria) this;
		}

		public Criteria andLogoGreaterThan(String value) {
			addCriterion("logo >", value, "logo");
			return (Criteria) this;
		}

		public Criteria andLogoGreaterThanOrEqualTo(String value) {
			addCriterion("logo >=", value, "logo");
			return (Criteria) this;
		}

		public Criteria andLogoLessThan(String value) {
			addCriterion("logo <", value, "logo");
			return (Criteria) this;
		}

		public Criteria andLogoLessThanOrEqualTo(String value) {
			addCriterion("logo <=", value, "logo");
			return (Criteria) this;
		}

		public Criteria andLogoLike(String value) {
			addCriterion("logo like", value, "logo");
			return (Criteria) this;
		}

		public Criteria andLogoNotLike(String value) {
			addCriterion("logo not like", value, "logo");
			return (Criteria) this;
		}

		public Criteria andLogoIn(List<String> values) {
			addCriterion("logo in", values, "logo");
			return (Criteria) this;
		}

		public Criteria andLogoNotIn(List<String> values) {
			addCriterion("logo not in", values, "logo");
			return (Criteria) this;
		}

		public Criteria andLogoBetween(String value1, String value2) {
			addCriterion("logo between", value1, value2, "logo");
			return (Criteria) this;
		}

		public Criteria andLogoNotBetween(String value1, String value2) {
			addCriterion("logo not between", value1, value2, "logo");
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

		public Criteria andAddtimeIsNull() {
			addCriterion("addtime is null");
			return (Criteria) this;
		}

		public Criteria andAddtimeIsNotNull() {
			addCriterion("addtime is not null");
			return (Criteria) this;
		}

		public Criteria andAddtimeEqualTo(Date value) {
			addCriterion("addtime =", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotEqualTo(Date value) {
			addCriterion("addtime <>", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeGreaterThan(Date value) {
			addCriterion("addtime >", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
			addCriterion("addtime >=", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeLessThan(Date value) {
			addCriterion("addtime <", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeLessThanOrEqualTo(Date value) {
			addCriterion("addtime <=", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeIn(List<Date> values) {
			addCriterion("addtime in", values, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotIn(List<Date> values) {
			addCriterion("addtime not in", values, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeBetween(Date value1, Date value2) {
			addCriterion("addtime between", value1, value2, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotBetween(Date value1, Date value2) {
			addCriterion("addtime not between", value1, value2, "addtime");
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

		public Criteria andAmuseridEqualTo(Long value) {
			addCriterion("amuserid =", value, "amuserid");
			return (Criteria) this;
		}

		public Criteria andAmuseridNotEqualTo(Long value) {
			addCriterion("amuserid <>", value, "amuserid");
			return (Criteria) this;
		}

		public Criteria andAmuseridGreaterThan(Long value) {
			addCriterion("amuserid >", value, "amuserid");
			return (Criteria) this;
		}

		public Criteria andAmuseridGreaterThanOrEqualTo(Long value) {
			addCriterion("amuserid >=", value, "amuserid");
			return (Criteria) this;
		}

		public Criteria andAmuseridLessThan(Long value) {
			addCriterion("amuserid <", value, "amuserid");
			return (Criteria) this;
		}

		public Criteria andAmuseridLessThanOrEqualTo(Long value) {
			addCriterion("amuserid <=", value, "amuserid");
			return (Criteria) this;
		}

		public Criteria andAmuseridIn(List<Long> values) {
			addCriterion("amuserid in", values, "amuserid");
			return (Criteria) this;
		}

		public Criteria andAmuseridNotIn(List<Long> values) {
			addCriterion("amuserid not in", values, "amuserid");
			return (Criteria) this;
		}

		public Criteria andAmuseridBetween(Long value1, Long value2) {
			addCriterion("amuserid between", value1, value2, "amuserid");
			return (Criteria) this;
		}

		public Criteria andAmuseridNotBetween(Long value1, Long value2) {
			addCriterion("amuserid not between", value1, value2, "amuserid");
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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