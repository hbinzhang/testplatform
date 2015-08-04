package com.cpit.testplatform.modules.stat.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AlarmStatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlarmStatExample() {
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

        public Criteria andStatTimeIsNull() {
            addCriterion("stat_time is null");
            return (Criteria) this;
        }

        public Criteria andStatTimeIsNotNull() {
            addCriterion("stat_time is not null");
            return (Criteria) this;
        }

        public Criteria andStatTimeEqualTo(Date value) {
            addCriterionForJDBCDate("stat_time =", value, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("stat_time <>", value, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("stat_time >", value, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stat_time >=", value, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeLessThan(Date value) {
            addCriterionForJDBCDate("stat_time <", value, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stat_time <=", value, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeIn(List<Date> values) {
            addCriterionForJDBCDate("stat_time in", values, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("stat_time not in", values, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stat_time between", value1, value2, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stat_time not between", value1, value2, "statTime");
            return (Criteria) this;
        }

        public Criteria andNeIdIsNull() {
            addCriterion("ne_id is null");
            return (Criteria) this;
        }

        public Criteria andNeIdIsNotNull() {
            addCriterion("ne_id is not null");
            return (Criteria) this;
        }

        public Criteria andNeIdEqualTo(String value) {
            addCriterion("ne_id =", value, "neId");
            return (Criteria) this;
        }

        public Criteria andNeIdNotEqualTo(String value) {
            addCriterion("ne_id <>", value, "neId");
            return (Criteria) this;
        }

        public Criteria andNeIdGreaterThan(String value) {
            addCriterion("ne_id >", value, "neId");
            return (Criteria) this;
        }

        public Criteria andNeIdGreaterThanOrEqualTo(String value) {
            addCriterion("ne_id >=", value, "neId");
            return (Criteria) this;
        }

        public Criteria andNeIdLessThan(String value) {
            addCriterion("ne_id <", value, "neId");
            return (Criteria) this;
        }

        public Criteria andNeIdLessThanOrEqualTo(String value) {
            addCriterion("ne_id <=", value, "neId");
            return (Criteria) this;
        }

        public Criteria andNeIdLike(String value) {
            addCriterion("ne_id like", value, "neId");
            return (Criteria) this;
        }

        public Criteria andNeIdNotLike(String value) {
            addCriterion("ne_id not like", value, "neId");
            return (Criteria) this;
        }

        public Criteria andNeIdIn(List<String> values) {
            addCriterion("ne_id in", values, "neId");
            return (Criteria) this;
        }

        public Criteria andNeIdNotIn(List<String> values) {
            addCriterion("ne_id not in", values, "neId");
            return (Criteria) this;
        }

        public Criteria andNeIdBetween(String value1, String value2) {
            addCriterion("ne_id between", value1, value2, "neId");
            return (Criteria) this;
        }

        public Criteria andNeIdNotBetween(String value1, String value2) {
            addCriterion("ne_id not between", value1, value2, "neId");
            return (Criteria) this;
        }

        public Criteria andNeLabelIsNull() {
            addCriterion("ne_label is null");
            return (Criteria) this;
        }

        public Criteria andNeLabelIsNotNull() {
            addCriterion("ne_label is not null");
            return (Criteria) this;
        }

        public Criteria andNeLabelEqualTo(String value) {
            addCriterion("ne_label =", value, "neLabel");
            return (Criteria) this;
        }

        public Criteria andNeLabelNotEqualTo(String value) {
            addCriterion("ne_label <>", value, "neLabel");
            return (Criteria) this;
        }

        public Criteria andNeLabelGreaterThan(String value) {
            addCriterion("ne_label >", value, "neLabel");
            return (Criteria) this;
        }

        public Criteria andNeLabelGreaterThanOrEqualTo(String value) {
            addCriterion("ne_label >=", value, "neLabel");
            return (Criteria) this;
        }

        public Criteria andNeLabelLessThan(String value) {
            addCriterion("ne_label <", value, "neLabel");
            return (Criteria) this;
        }

        public Criteria andNeLabelLessThanOrEqualTo(String value) {
            addCriterion("ne_label <=", value, "neLabel");
            return (Criteria) this;
        }

        public Criteria andNeLabelLike(String value) {
            addCriterion("ne_label like", value, "neLabel");
            return (Criteria) this;
        }

        public Criteria andNeLabelNotLike(String value) {
            addCriterion("ne_label not like", value, "neLabel");
            return (Criteria) this;
        }

        public Criteria andNeLabelIn(List<String> values) {
            addCriterion("ne_label in", values, "neLabel");
            return (Criteria) this;
        }

        public Criteria andNeLabelNotIn(List<String> values) {
            addCriterion("ne_label not in", values, "neLabel");
            return (Criteria) this;
        }

        public Criteria andNeLabelBetween(String value1, String value2) {
            addCriterion("ne_label between", value1, value2, "neLabel");
            return (Criteria) this;
        }

        public Criteria andNeLabelNotBetween(String value1, String value2) {
            addCriterion("ne_label not between", value1, value2, "neLabel");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Integer value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Integer value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Integer value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Integer value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Integer value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Integer> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Integer> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Integer value1, Integer value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("duration not between", value1, value2, "duration");
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