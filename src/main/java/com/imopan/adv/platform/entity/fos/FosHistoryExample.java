package com.imopan.adv.platform.entity.fos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FosHistoryExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    protected Integer limitStart;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    protected Integer limitEnd;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    public FosHistoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    public Integer getLimitStart() {
        return limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    public Integer getLimitEnd() {
        return limitEnd;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table fos_history
     *
     * @mbggenerated
     */
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDirectorCooperateProductIsNull() {
            addCriterion("DIRECTOR_COOPERATE_PRODUCT is null");
            return (Criteria) this;
        }

        public Criteria andDirectorCooperateProductIsNotNull() {
            addCriterion("DIRECTOR_COOPERATE_PRODUCT is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorCooperateProductEqualTo(String value) {
            addCriterion("DIRECTOR_COOPERATE_PRODUCT =", value, "directorCooperateProduct");
            return (Criteria) this;
        }

        public Criteria andDirectorCooperateProductNotEqualTo(String value) {
            addCriterion("DIRECTOR_COOPERATE_PRODUCT <>", value, "directorCooperateProduct");
            return (Criteria) this;
        }

        public Criteria andDirectorCooperateProductGreaterThan(String value) {
            addCriterion("DIRECTOR_COOPERATE_PRODUCT >", value, "directorCooperateProduct");
            return (Criteria) this;
        }

        public Criteria andDirectorCooperateProductGreaterThanOrEqualTo(String value) {
            addCriterion("DIRECTOR_COOPERATE_PRODUCT >=", value, "directorCooperateProduct");
            return (Criteria) this;
        }

        public Criteria andDirectorCooperateProductLessThan(String value) {
            addCriterion("DIRECTOR_COOPERATE_PRODUCT <", value, "directorCooperateProduct");
            return (Criteria) this;
        }

        public Criteria andDirectorCooperateProductLessThanOrEqualTo(String value) {
            addCriterion("DIRECTOR_COOPERATE_PRODUCT <=", value, "directorCooperateProduct");
            return (Criteria) this;
        }

        public Criteria andDirectorCooperateProductLike(String value) {
            addCriterion("DIRECTOR_COOPERATE_PRODUCT like", value, "directorCooperateProduct");
            return (Criteria) this;
        }

        public Criteria andDirectorCooperateProductNotLike(String value) {
            addCriterion("DIRECTOR_COOPERATE_PRODUCT not like", value, "directorCooperateProduct");
            return (Criteria) this;
        }

        public Criteria andDirectorCooperateProductIn(List<String> values) {
            addCriterion("DIRECTOR_COOPERATE_PRODUCT in", values, "directorCooperateProduct");
            return (Criteria) this;
        }

        public Criteria andDirectorCooperateProductNotIn(List<String> values) {
            addCriterion("DIRECTOR_COOPERATE_PRODUCT not in", values, "directorCooperateProduct");
            return (Criteria) this;
        }

        public Criteria andDirectorCooperateProductBetween(String value1, String value2) {
            addCriterion("DIRECTOR_COOPERATE_PRODUCT between", value1, value2, "directorCooperateProduct");
            return (Criteria) this;
        }

        public Criteria andDirectorCooperateProductNotBetween(String value1, String value2) {
            addCriterion("DIRECTOR_COOPERATE_PRODUCT not between", value1, value2, "directorCooperateProduct");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("`TIME` is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("`TIME` is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("`TIME` =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("`TIME` <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("`TIME` >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("`TIME` >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("`TIME` <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("`TIME` <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("`TIME` like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("`TIME` not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("`TIME` in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("`TIME` not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("`TIME` between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("`TIME` not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("UNIT is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(BigDecimal value) {
            addCriterion("UNIT =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(BigDecimal value) {
            addCriterion("UNIT <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(BigDecimal value) {
            addCriterion("UNIT >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UNIT >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(BigDecimal value) {
            addCriterion("UNIT <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UNIT <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<BigDecimal> values) {
            addCriterion("UNIT in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<BigDecimal> values) {
            addCriterion("UNIT not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UNIT between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UNIT not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andClickIsNull() {
            addCriterion("CLICK is null");
            return (Criteria) this;
        }

        public Criteria andClickIsNotNull() {
            addCriterion("CLICK is not null");
            return (Criteria) this;
        }

        public Criteria andClickEqualTo(Integer value) {
            addCriterion("CLICK =", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickNotEqualTo(Integer value) {
            addCriterion("CLICK <>", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickGreaterThan(Integer value) {
            addCriterion("CLICK >", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickGreaterThanOrEqualTo(Integer value) {
            addCriterion("CLICK >=", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickLessThan(Integer value) {
            addCriterion("CLICK <", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickLessThanOrEqualTo(Integer value) {
            addCriterion("CLICK <=", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickIn(List<Integer> values) {
            addCriterion("CLICK in", values, "click");
            return (Criteria) this;
        }

        public Criteria andClickNotIn(List<Integer> values) {
            addCriterion("CLICK not in", values, "click");
            return (Criteria) this;
        }

        public Criteria andClickBetween(Integer value1, Integer value2) {
            addCriterion("CLICK between", value1, value2, "click");
            return (Criteria) this;
        }

        public Criteria andClickNotBetween(Integer value1, Integer value2) {
            addCriterion("CLICK not between", value1, value2, "click");
            return (Criteria) this;
        }

        public Criteria andShouldAmountIsNull() {
            addCriterion("SHOULD_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andShouldAmountIsNotNull() {
            addCriterion("SHOULD_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andShouldAmountEqualTo(BigDecimal value) {
            addCriterion("SHOULD_AMOUNT =", value, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andShouldAmountNotEqualTo(BigDecimal value) {
            addCriterion("SHOULD_AMOUNT <>", value, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andShouldAmountGreaterThan(BigDecimal value) {
            addCriterion("SHOULD_AMOUNT >", value, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andShouldAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SHOULD_AMOUNT >=", value, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andShouldAmountLessThan(BigDecimal value) {
            addCriterion("SHOULD_AMOUNT <", value, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andShouldAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SHOULD_AMOUNT <=", value, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andShouldAmountIn(List<BigDecimal> values) {
            addCriterion("SHOULD_AMOUNT in", values, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andShouldAmountNotIn(List<BigDecimal> values) {
            addCriterion("SHOULD_AMOUNT not in", values, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andShouldAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SHOULD_AMOUNT between", value1, value2, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andShouldAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SHOULD_AMOUNT not between", value1, value2, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andCpCountIsNull() {
            addCriterion("CP_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andCpCountIsNotNull() {
            addCriterion("CP_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCpCountEqualTo(Integer value) {
            addCriterion("CP_COUNT =", value, "cpCount");
            return (Criteria) this;
        }

        public Criteria andCpCountNotEqualTo(Integer value) {
            addCriterion("CP_COUNT <>", value, "cpCount");
            return (Criteria) this;
        }

        public Criteria andCpCountGreaterThan(Integer value) {
            addCriterion("CP_COUNT >", value, "cpCount");
            return (Criteria) this;
        }

        public Criteria andCpCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("CP_COUNT >=", value, "cpCount");
            return (Criteria) this;
        }

        public Criteria andCpCountLessThan(Integer value) {
            addCriterion("CP_COUNT <", value, "cpCount");
            return (Criteria) this;
        }

        public Criteria andCpCountLessThanOrEqualTo(Integer value) {
            addCriterion("CP_COUNT <=", value, "cpCount");
            return (Criteria) this;
        }

        public Criteria andCpCountIn(List<Integer> values) {
            addCriterion("CP_COUNT in", values, "cpCount");
            return (Criteria) this;
        }

        public Criteria andCpCountNotIn(List<Integer> values) {
            addCriterion("CP_COUNT not in", values, "cpCount");
            return (Criteria) this;
        }

        public Criteria andCpCountBetween(Integer value1, Integer value2) {
            addCriterion("CP_COUNT between", value1, value2, "cpCount");
            return (Criteria) this;
        }

        public Criteria andCpCountNotBetween(Integer value1, Integer value2) {
            addCriterion("CP_COUNT not between", value1, value2, "cpCount");
            return (Criteria) this;
        }

        public Criteria andDrawAmountIsNull() {
            addCriterion("DRAW_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andDrawAmountIsNotNull() {
            addCriterion("DRAW_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andDrawAmountEqualTo(BigDecimal value) {
            addCriterion("DRAW_AMOUNT =", value, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andDrawAmountNotEqualTo(BigDecimal value) {
            addCriterion("DRAW_AMOUNT <>", value, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andDrawAmountGreaterThan(BigDecimal value) {
            addCriterion("DRAW_AMOUNT >", value, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andDrawAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DRAW_AMOUNT >=", value, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andDrawAmountLessThan(BigDecimal value) {
            addCriterion("DRAW_AMOUNT <", value, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andDrawAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DRAW_AMOUNT <=", value, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andDrawAmountIn(List<BigDecimal> values) {
            addCriterion("DRAW_AMOUNT in", values, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andDrawAmountNotIn(List<BigDecimal> values) {
            addCriterion("DRAW_AMOUNT not in", values, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andDrawAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DRAW_AMOUNT between", value1, value2, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andDrawAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DRAW_AMOUNT not between", value1, value2, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andCutIsNull() {
            addCriterion("CUT is null");
            return (Criteria) this;
        }

        public Criteria andCutIsNotNull() {
            addCriterion("CUT is not null");
            return (Criteria) this;
        }

        public Criteria andCutEqualTo(BigDecimal value) {
            addCriterion("CUT =", value, "cut");
            return (Criteria) this;
        }

        public Criteria andCutNotEqualTo(BigDecimal value) {
            addCriterion("CUT <>", value, "cut");
            return (Criteria) this;
        }

        public Criteria andCutGreaterThan(BigDecimal value) {
            addCriterion("CUT >", value, "cut");
            return (Criteria) this;
        }

        public Criteria andCutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CUT >=", value, "cut");
            return (Criteria) this;
        }

        public Criteria andCutLessThan(BigDecimal value) {
            addCriterion("CUT <", value, "cut");
            return (Criteria) this;
        }

        public Criteria andCutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CUT <=", value, "cut");
            return (Criteria) this;
        }

        public Criteria andCutIn(List<BigDecimal> values) {
            addCriterion("CUT in", values, "cut");
            return (Criteria) this;
        }

        public Criteria andCutNotIn(List<BigDecimal> values) {
            addCriterion("CUT not in", values, "cut");
            return (Criteria) this;
        }

        public Criteria andCutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CUT between", value1, value2, "cut");
            return (Criteria) this;
        }

        public Criteria andCutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CUT not between", value1, value2, "cut");
            return (Criteria) this;
        }

        public Criteria andExpendIsNull() {
            addCriterion("EXPEND is null");
            return (Criteria) this;
        }

        public Criteria andExpendIsNotNull() {
            addCriterion("EXPEND is not null");
            return (Criteria) this;
        }

        public Criteria andExpendEqualTo(BigDecimal value) {
            addCriterion("EXPEND =", value, "expend");
            return (Criteria) this;
        }

        public Criteria andExpendNotEqualTo(BigDecimal value) {
            addCriterion("EXPEND <>", value, "expend");
            return (Criteria) this;
        }

        public Criteria andExpendGreaterThan(BigDecimal value) {
            addCriterion("EXPEND >", value, "expend");
            return (Criteria) this;
        }

        public Criteria andExpendGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EXPEND >=", value, "expend");
            return (Criteria) this;
        }

        public Criteria andExpendLessThan(BigDecimal value) {
            addCriterion("EXPEND <", value, "expend");
            return (Criteria) this;
        }

        public Criteria andExpendLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EXPEND <=", value, "expend");
            return (Criteria) this;
        }

        public Criteria andExpendIn(List<BigDecimal> values) {
            addCriterion("EXPEND in", values, "expend");
            return (Criteria) this;
        }

        public Criteria andExpendNotIn(List<BigDecimal> values) {
            addCriterion("EXPEND not in", values, "expend");
            return (Criteria) this;
        }

        public Criteria andExpendBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXPEND between", value1, value2, "expend");
            return (Criteria) this;
        }

        public Criteria andExpendNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXPEND not between", value1, value2, "expend");
            return (Criteria) this;
        }

        public Criteria andActualExpendIsNull() {
            addCriterion("ACTUAL_EXPEND is null");
            return (Criteria) this;
        }

        public Criteria andActualExpendIsNotNull() {
            addCriterion("ACTUAL_EXPEND is not null");
            return (Criteria) this;
        }

        public Criteria andActualExpendEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_EXPEND =", value, "actualExpend");
            return (Criteria) this;
        }

        public Criteria andActualExpendNotEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_EXPEND <>", value, "actualExpend");
            return (Criteria) this;
        }

        public Criteria andActualExpendGreaterThan(BigDecimal value) {
            addCriterion("ACTUAL_EXPEND >", value, "actualExpend");
            return (Criteria) this;
        }

        public Criteria andActualExpendGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_EXPEND >=", value, "actualExpend");
            return (Criteria) this;
        }

        public Criteria andActualExpendLessThan(BigDecimal value) {
            addCriterion("ACTUAL_EXPEND <", value, "actualExpend");
            return (Criteria) this;
        }

        public Criteria andActualExpendLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_EXPEND <=", value, "actualExpend");
            return (Criteria) this;
        }

        public Criteria andActualExpendIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_EXPEND in", values, "actualExpend");
            return (Criteria) this;
        }

        public Criteria andActualExpendNotIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_EXPEND not in", values, "actualExpend");
            return (Criteria) this;
        }

        public Criteria andActualExpendBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_EXPEND between", value1, value2, "actualExpend");
            return (Criteria) this;
        }

        public Criteria andActualExpendNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_EXPEND not between", value1, value2, "actualExpend");
            return (Criteria) this;
        }

        public Criteria andProfitIsNull() {
            addCriterion("PROFIT is null");
            return (Criteria) this;
        }

        public Criteria andProfitIsNotNull() {
            addCriterion("PROFIT is not null");
            return (Criteria) this;
        }

        public Criteria andProfitEqualTo(String value) {
            addCriterion("PROFIT =", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotEqualTo(String value) {
            addCriterion("PROFIT <>", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitGreaterThan(String value) {
            addCriterion("PROFIT >", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitGreaterThanOrEqualTo(String value) {
            addCriterion("PROFIT >=", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitLessThan(String value) {
            addCriterion("PROFIT <", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitLessThanOrEqualTo(String value) {
            addCriterion("PROFIT <=", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitLike(String value) {
            addCriterion("PROFIT like", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotLike(String value) {
            addCriterion("PROFIT not like", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitIn(List<String> values) {
            addCriterion("PROFIT in", values, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotIn(List<String> values) {
            addCriterion("PROFIT not in", values, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitBetween(String value1, String value2) {
            addCriterion("PROFIT between", value1, value2, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotBetween(String value1, String value2) {
            addCriterion("PROFIT not between", value1, value2, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitMarginIsNull() {
            addCriterion("PROFIT_MARGIN is null");
            return (Criteria) this;
        }

        public Criteria andProfitMarginIsNotNull() {
            addCriterion("PROFIT_MARGIN is not null");
            return (Criteria) this;
        }

        public Criteria andProfitMarginEqualTo(String value) {
            addCriterion("PROFIT_MARGIN =", value, "profitMargin");
            return (Criteria) this;
        }

        public Criteria andProfitMarginNotEqualTo(String value) {
            addCriterion("PROFIT_MARGIN <>", value, "profitMargin");
            return (Criteria) this;
        }

        public Criteria andProfitMarginGreaterThan(String value) {
            addCriterion("PROFIT_MARGIN >", value, "profitMargin");
            return (Criteria) this;
        }

        public Criteria andProfitMarginGreaterThanOrEqualTo(String value) {
            addCriterion("PROFIT_MARGIN >=", value, "profitMargin");
            return (Criteria) this;
        }

        public Criteria andProfitMarginLessThan(String value) {
            addCriterion("PROFIT_MARGIN <", value, "profitMargin");
            return (Criteria) this;
        }

        public Criteria andProfitMarginLessThanOrEqualTo(String value) {
            addCriterion("PROFIT_MARGIN <=", value, "profitMargin");
            return (Criteria) this;
        }

        public Criteria andProfitMarginLike(String value) {
            addCriterion("PROFIT_MARGIN like", value, "profitMargin");
            return (Criteria) this;
        }

        public Criteria andProfitMarginNotLike(String value) {
            addCriterion("PROFIT_MARGIN not like", value, "profitMargin");
            return (Criteria) this;
        }

        public Criteria andProfitMarginIn(List<String> values) {
            addCriterion("PROFIT_MARGIN in", values, "profitMargin");
            return (Criteria) this;
        }

        public Criteria andProfitMarginNotIn(List<String> values) {
            addCriterion("PROFIT_MARGIN not in", values, "profitMargin");
            return (Criteria) this;
        }

        public Criteria andProfitMarginBetween(String value1, String value2) {
            addCriterion("PROFIT_MARGIN between", value1, value2, "profitMargin");
            return (Criteria) this;
        }

        public Criteria andProfitMarginNotBetween(String value1, String value2) {
            addCriterion("PROFIT_MARGIN not between", value1, value2, "profitMargin");
            return (Criteria) this;
        }

        public Criteria andDirectorCooperateProductLikeInsensitive(String value) {
            addCriterion("upper(DIRECTOR_COOPERATE_PRODUCT) like", value.toUpperCase(), "directorCooperateProduct");
            return (Criteria) this;
        }

        public Criteria andTimeLikeInsensitive(String value) {
            addCriterion("upper(`TIME`) like", value.toUpperCase(), "time");
            return (Criteria) this;
        }

        public Criteria andProfitLikeInsensitive(String value) {
            addCriterion("upper(PROFIT) like", value.toUpperCase(), "profit");
            return (Criteria) this;
        }

        public Criteria andProfitMarginLikeInsensitive(String value) {
            addCriterion("upper(PROFIT_MARGIN) like", value.toUpperCase(), "profitMargin");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table fos_history
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table fos_history
     *
     * @mbggenerated
     */
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