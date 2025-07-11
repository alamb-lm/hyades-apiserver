/*
 * This file is generated by jOOQ.
 */
package org.dependencytrack.persistence.jooq.generated.tables;


import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.dependencytrack.persistence.jooq.generated.DefaultSchema;
import org.dependencytrack.persistence.jooq.generated.Indexes;
import org.dependencytrack.persistence.jooq.generated.Keys;
import org.dependencytrack.persistence.jooq.generated.tables.Component.ComponentPath;
import org.dependencytrack.persistence.jooq.generated.tables.PolicyCondition.PolicyConditionPath;
import org.dependencytrack.persistence.jooq.generated.tables.Project.ProjectPath;
import org.dependencytrack.persistence.jooq.generated.tables.ViolationAnalysis.ViolationAnalysisPath;
import org.dependencytrack.persistence.jooq.generated.tables.records.PolicyViolationRecord;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class PolicyViolation extends TableImpl<PolicyViolationRecord> {

    private static final long serialVersionUID = -1085460468;

    /**
     * The reference instance of <code>POLICYVIOLATION</code>
     */
    public static final PolicyViolation POLICYVIOLATION = new PolicyViolation();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PolicyViolationRecord> getRecordType() {
        return PolicyViolationRecord.class;
    }

    /**
     * The column <code>POLICYVIOLATION.ID</code>.
     */
    public final TableField<PolicyViolationRecord, Long> id = createField(DSL.name("ID"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>POLICYVIOLATION.COMPONENT_ID</code>.
     */
    public final TableField<PolicyViolationRecord, Long> componentId = createField(DSL.name("COMPONENT_ID"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>POLICYVIOLATION.POLICYCONDITION_ID</code>.
     */
    public final TableField<PolicyViolationRecord, Long> policyConditionId = createField(DSL.name("POLICYCONDITION_ID"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>POLICYVIOLATION.PROJECT_ID</code>.
     */
    public final TableField<PolicyViolationRecord, Long> projectId = createField(DSL.name("PROJECT_ID"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>POLICYVIOLATION.TEXT</code>.
     */
    public final TableField<PolicyViolationRecord, String> text = createField(DSL.name("TEXT"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>POLICYVIOLATION.TIMESTAMP</code>.
     */
    public final TableField<PolicyViolationRecord, OffsetDateTime> timestamp = createField(DSL.name("TIMESTAMP"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "");

    /**
     * The column <code>POLICYVIOLATION.TYPE</code>.
     */
    public final TableField<PolicyViolationRecord, String> type = createField(DSL.name("TYPE"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>POLICYVIOLATION.UUID</code>.
     */
    public final TableField<PolicyViolationRecord, UUID> uuid = createField(DSL.name("UUID"), SQLDataType.UUID.nullable(false), this, "");

    private PolicyViolation(Name alias, Table<PolicyViolationRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private PolicyViolation(Name alias, Table<PolicyViolationRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>POLICYVIOLATION</code> table reference
     */
    public PolicyViolation(String alias) {
        this(DSL.name(alias), POLICYVIOLATION);
    }

    /**
     * Create an aliased <code>POLICYVIOLATION</code> table reference
     */
    public PolicyViolation(Name alias) {
        this(alias, POLICYVIOLATION);
    }

    /**
     * Create a <code>POLICYVIOLATION</code> table reference
     */
    public PolicyViolation() {
        this(DSL.name("POLICYVIOLATION"), null);
    }

    public <O extends Record> PolicyViolation(Table<O> path, ForeignKey<O, PolicyViolationRecord> childPath, InverseForeignKey<O, PolicyViolationRecord> parentPath) {
        super(path, childPath, parentPath, POLICYVIOLATION);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class PolicyViolationPath extends PolicyViolation implements Path<PolicyViolationRecord> {

        private static final long serialVersionUID = -1085460468;
        public <O extends Record> PolicyViolationPath(Table<O> path, ForeignKey<O, PolicyViolationRecord> childPath, InverseForeignKey<O, PolicyViolationRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private PolicyViolationPath(Name alias, Table<PolicyViolationRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public PolicyViolationPath as(String alias) {
            return new PolicyViolationPath(DSL.name(alias), this);
        }

        @Override
        public PolicyViolationPath as(Name alias) {
            return new PolicyViolationPath(alias, this);
        }

        @Override
        public PolicyViolationPath as(Table<?> alias) {
            return new PolicyViolationPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.POLICYVIOLATION_COMPONENT_IDX, Indexes.POLICYVIOLATION_POLICYCONDITION_ID_IDX, Indexes.POLICYVIOLATION_PROJECT_IDX);
    }

    @Override
    public Identity<PolicyViolationRecord, Long> getIdentity() {
        return (Identity<PolicyViolationRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<PolicyViolationRecord> getPrimaryKey() {
        return Keys.POLICYVIOLATION_PK;
    }

    @Override
    public List<UniqueKey<PolicyViolationRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.POLICYVIOLATION_UUID_IDX);
    }

    @Override
    public List<ForeignKey<PolicyViolationRecord, ?>> getReferences() {
        return Arrays.asList(Keys.POLICYVIOLATION_COMPONENT_FK, Keys.POLICYVIOLATION_POLICYCONDITION_FK, Keys.POLICYVIOLATION_PROJECT_FK);
    }

    private transient ComponentPath _component;

    /**
     * Get the implicit join path to the <code>COMPONENT</code> table.
     */
    public ComponentPath component() {
        if (_component == null)
            _component = new ComponentPath(this, Keys.POLICYVIOLATION_COMPONENT_FK, null);

        return _component;
    }

    private transient PolicyConditionPath _policyCondition;

    /**
     * Get the implicit join path to the <code>POLICYCONDITION</code> table.
     */
    public PolicyConditionPath policyCondition() {
        if (_policyCondition == null)
            _policyCondition = new PolicyConditionPath(this, Keys.POLICYVIOLATION_POLICYCONDITION_FK, null);

        return _policyCondition;
    }

    private transient ProjectPath _project;

    /**
     * Get the implicit join path to the <code>PROJECT</code> table.
     */
    public ProjectPath project() {
        if (_project == null)
            _project = new ProjectPath(this, Keys.POLICYVIOLATION_PROJECT_FK, null);

        return _project;
    }

    private transient ViolationAnalysisPath _violationAnalysis;

    /**
     * Get the implicit to-many join path to the <code>VIOLATIONANALYSIS</code>
     * table
     */
    public ViolationAnalysisPath violationAnalysis() {
        if (_violationAnalysis == null)
            _violationAnalysis = new ViolationAnalysisPath(this, null, Keys.VIOLATIONANALYSIS_POLICYVIOLATION_FK.getInverseKey());

        return _violationAnalysis;
    }

    @Override
    public PolicyViolation as(String alias) {
        return new PolicyViolation(DSL.name(alias), this);
    }

    @Override
    public PolicyViolation as(Name alias) {
        return new PolicyViolation(alias, this);
    }

    @Override
    public PolicyViolation as(Table<?> alias) {
        return new PolicyViolation(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public PolicyViolation rename(String name) {
        return new PolicyViolation(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PolicyViolation rename(Name name) {
        return new PolicyViolation(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public PolicyViolation rename(Table<?> name) {
        return new PolicyViolation(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PolicyViolation where(Condition condition) {
        return new PolicyViolation(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PolicyViolation where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PolicyViolation where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PolicyViolation where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PolicyViolation where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PolicyViolation where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PolicyViolation where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PolicyViolation where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PolicyViolation whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PolicyViolation whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
