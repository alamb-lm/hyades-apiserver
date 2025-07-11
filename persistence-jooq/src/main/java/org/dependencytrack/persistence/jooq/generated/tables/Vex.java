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
import org.dependencytrack.persistence.jooq.generated.tables.Project.ProjectPath;
import org.dependencytrack.persistence.jooq.generated.tables.records.VexRecord;
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
public class Vex extends TableImpl<VexRecord> {

    private static final long serialVersionUID = 1744304855;

    /**
     * The reference instance of <code>VEX</code>
     */
    public static final Vex VEX = new Vex();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VexRecord> getRecordType() {
        return VexRecord.class;
    }

    /**
     * The column <code>VEX.ID</code>.
     */
    public final TableField<VexRecord, Long> id = createField(DSL.name("ID"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>VEX.IMPORTED</code>.
     */
    public final TableField<VexRecord, OffsetDateTime> imported = createField(DSL.name("IMPORTED"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "");

    /**
     * The column <code>VEX.PROJECT_ID</code>.
     */
    public final TableField<VexRecord, Long> projectId = createField(DSL.name("PROJECT_ID"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>VEX.SERIAL_NUMBER</code>.
     */
    public final TableField<VexRecord, String> serialNumber = createField(DSL.name("SERIAL_NUMBER"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>VEX.SPEC_VERSION</code>.
     */
    public final TableField<VexRecord, String> specVersion = createField(DSL.name("SPEC_VERSION"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>VEX.UUID</code>.
     */
    public final TableField<VexRecord, UUID> uuid = createField(DSL.name("UUID"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>VEX.VEX_FORMAT</code>.
     */
    public final TableField<VexRecord, String> vexFormat = createField(DSL.name("VEX_FORMAT"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>VEX.VEX_VERSION</code>.
     */
    public final TableField<VexRecord, Integer> vexVersion = createField(DSL.name("VEX_VERSION"), SQLDataType.INTEGER, this, "");

    private Vex(Name alias, Table<VexRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Vex(Name alias, Table<VexRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>VEX</code> table reference
     */
    public Vex(String alias) {
        this(DSL.name(alias), VEX);
    }

    /**
     * Create an aliased <code>VEX</code> table reference
     */
    public Vex(Name alias) {
        this(alias, VEX);
    }

    /**
     * Create a <code>VEX</code> table reference
     */
    public Vex() {
        this(DSL.name("VEX"), null);
    }

    public <O extends Record> Vex(Table<O> path, ForeignKey<O, VexRecord> childPath, InverseForeignKey<O, VexRecord> parentPath) {
        super(path, childPath, parentPath, VEX);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class VexPath extends Vex implements Path<VexRecord> {

        private static final long serialVersionUID = 1744304855;
        public <O extends Record> VexPath(Table<O> path, ForeignKey<O, VexRecord> childPath, InverseForeignKey<O, VexRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private VexPath(Name alias, Table<VexRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public VexPath as(String alias) {
            return new VexPath(DSL.name(alias), this);
        }

        @Override
        public VexPath as(Name alias) {
            return new VexPath(alias, this);
        }

        @Override
        public VexPath as(Table<?> alias) {
            return new VexPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.VEX_PROJECT_ID_IDX);
    }

    @Override
    public Identity<VexRecord, Long> getIdentity() {
        return (Identity<VexRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<VexRecord> getPrimaryKey() {
        return Keys.VEX_PK;
    }

    @Override
    public List<UniqueKey<VexRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.VEX_UUID_IDX);
    }

    @Override
    public List<ForeignKey<VexRecord, ?>> getReferences() {
        return Arrays.asList(Keys.VEX_PROJECT_FK);
    }

    private transient ProjectPath _project;

    /**
     * Get the implicit join path to the <code>PROJECT</code> table.
     */
    public ProjectPath project() {
        if (_project == null)
            _project = new ProjectPath(this, Keys.VEX_PROJECT_FK, null);

        return _project;
    }

    @Override
    public Vex as(String alias) {
        return new Vex(DSL.name(alias), this);
    }

    @Override
    public Vex as(Name alias) {
        return new Vex(alias, this);
    }

    @Override
    public Vex as(Table<?> alias) {
        return new Vex(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Vex rename(String name) {
        return new Vex(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Vex rename(Name name) {
        return new Vex(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Vex rename(Table<?> name) {
        return new Vex(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Vex where(Condition condition) {
        return new Vex(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Vex where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Vex where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Vex where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Vex where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Vex where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Vex where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Vex where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Vex whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Vex whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
