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
import org.dependencytrack.persistence.jooq.generated.tables.Analysis.AnalysisPath;
import org.dependencytrack.persistence.jooq.generated.tables.Bom.BomPath;
import org.dependencytrack.persistence.jooq.generated.tables.Component.ComponentPath;
import org.dependencytrack.persistence.jooq.generated.tables.DependencyMetrics.DependencyMetricsPath;
import org.dependencytrack.persistence.jooq.generated.tables.FindingAttribution.FindingAttributionPath;
import org.dependencytrack.persistence.jooq.generated.tables.NotificationRuleProjects.NotificationRuleProjectsPath;
import org.dependencytrack.persistence.jooq.generated.tables.PolicyProjects.PolicyProjectsPath;
import org.dependencytrack.persistence.jooq.generated.tables.PolicyViolation.PolicyViolationPath;
import org.dependencytrack.persistence.jooq.generated.tables.Project.ProjectPath;
import org.dependencytrack.persistence.jooq.generated.tables.ProjectAccessTeams.ProjectAccessTeamsPath;
import org.dependencytrack.persistence.jooq.generated.tables.ProjectHierarchy.ProjectHierarchyPath;
import org.dependencytrack.persistence.jooq.generated.tables.ProjectMetadata.ProjectMetadataPath;
import org.dependencytrack.persistence.jooq.generated.tables.ProjectMetrics.ProjectMetricsPath;
import org.dependencytrack.persistence.jooq.generated.tables.ProjectProperty.ProjectPropertyPath;
import org.dependencytrack.persistence.jooq.generated.tables.ProjectsTags.ProjectsTagsPath;
import org.dependencytrack.persistence.jooq.generated.tables.ServiceComponent.ServiceComponentPath;
import org.dependencytrack.persistence.jooq.generated.tables.Tag.TagPath;
import org.dependencytrack.persistence.jooq.generated.tables.Team.TeamPath;
import org.dependencytrack.persistence.jooq.generated.tables.UserProjectEffectivePermissions.UserProjectEffectivePermissionsPath;
import org.dependencytrack.persistence.jooq.generated.tables.UserProjectRoles.UserProjectRolesPath;
import org.dependencytrack.persistence.jooq.generated.tables.Vex.VexPath;
import org.dependencytrack.persistence.jooq.generated.tables.ViolationAnalysis.ViolationAnalysisPath;
import org.dependencytrack.persistence.jooq.generated.tables.records.ProjectRecord;
import org.jooq.Check;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.InverseForeignKey;
import org.jooq.JSONB;
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
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Project extends TableImpl<ProjectRecord> {

    private static final long serialVersionUID = 1157287883;

    /**
     * The reference instance of <code>PROJECT</code>
     */
    public static final Project PROJECT = new Project();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProjectRecord> getRecordType() {
        return ProjectRecord.class;
    }

    /**
     * The column <code>PROJECT.ID</code>.
     */
    public final TableField<ProjectRecord, Long> id = createField(DSL.name("ID"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>PROJECT.CLASSIFIER</code>.
     */
    public final TableField<ProjectRecord, String> classifier = createField(DSL.name("CLASSIFIER"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PROJECT.CPE</code>.
     */
    public final TableField<ProjectRecord, String> cpe = createField(DSL.name("CPE"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PROJECT.DESCRIPTION</code>.
     */
    public final TableField<ProjectRecord, String> description = createField(DSL.name("DESCRIPTION"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PROJECT.DIRECT_DEPENDENCIES</code>.
     */
    public final TableField<ProjectRecord, JSONB> directDependencies = createField(DSL.name("DIRECT_DEPENDENCIES"), SQLDataType.JSONB, this, "");

    /**
     * The column <code>PROJECT.EXTERNAL_REFERENCES</code>.
     */
    public final TableField<ProjectRecord, byte[]> externalReferences = createField(DSL.name("EXTERNAL_REFERENCES"), SQLDataType.BLOB, this, "");

    /**
     * The column <code>PROJECT.GROUP</code>.
     */
    public final TableField<ProjectRecord, String> group = createField(DSL.name("GROUP"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PROJECT.LAST_BOM_IMPORTED</code>.
     */
    public final TableField<ProjectRecord, OffsetDateTime> lastBomImported = createField(DSL.name("LAST_BOM_IMPORTED"), SQLDataType.TIMESTAMPWITHTIMEZONE(6), this, "");

    /**
     * The column <code>PROJECT.LAST_BOM_IMPORTED_FORMAT</code>.
     */
    public final TableField<ProjectRecord, String> lastBomImportedFormat = createField(DSL.name("LAST_BOM_IMPORTED_FORMAT"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PROJECT.LAST_RISKSCORE</code>.
     */
    public final TableField<ProjectRecord, Double> lastRiskScore = createField(DSL.name("LAST_RISKSCORE"), SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>PROJECT.NAME</code>.
     */
    public final TableField<ProjectRecord, String> name = createField(DSL.name("NAME"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>PROJECT.PARENT_PROJECT_ID</code>.
     */
    public final TableField<ProjectRecord, Long> parentProjectId = createField(DSL.name("PARENT_PROJECT_ID"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>PROJECT.PUBLISHER</code>.
     */
    public final TableField<ProjectRecord, String> publisher = createField(DSL.name("PUBLISHER"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PROJECT.PURL</code>.
     */
    public final TableField<ProjectRecord, String> purl = createField(DSL.name("PURL"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PROJECT.SWIDTAGID</code>.
     */
    public final TableField<ProjectRecord, String> swidTagId = createField(DSL.name("SWIDTAGID"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PROJECT.UUID</code>.
     */
    public final TableField<ProjectRecord, UUID> uuid = createField(DSL.name("UUID"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>PROJECT.VERSION</code>.
     */
    public final TableField<ProjectRecord, String> version = createField(DSL.name("VERSION"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PROJECT.SUPPLIER</code>.
     */
    public final TableField<ProjectRecord, String> supplier = createField(DSL.name("SUPPLIER"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>PROJECT.MANUFACTURER</code>.
     */
    public final TableField<ProjectRecord, String> manufacturer = createField(DSL.name("MANUFACTURER"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>PROJECT.AUTHORS</code>.
     */
    public final TableField<ProjectRecord, String> authors = createField(DSL.name("AUTHORS"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>PROJECT.IS_LATEST</code>.
     */
    public final TableField<ProjectRecord, Boolean> isLatest = createField(DSL.name("IS_LATEST"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field(DSL.raw("false"), SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>PROJECT.INACTIVE_SINCE</code>.
     */
    public final TableField<ProjectRecord, OffsetDateTime> inactiveSince = createField(DSL.name("INACTIVE_SINCE"), SQLDataType.TIMESTAMPWITHTIMEZONE(6), this, "");

    private Project(Name alias, Table<ProjectRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Project(Name alias, Table<ProjectRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>PROJECT</code> table reference
     */
    public Project(String alias) {
        this(DSL.name(alias), PROJECT);
    }

    /**
     * Create an aliased <code>PROJECT</code> table reference
     */
    public Project(Name alias) {
        this(alias, PROJECT);
    }

    /**
     * Create a <code>PROJECT</code> table reference
     */
    public Project() {
        this(DSL.name("PROJECT"), null);
    }

    public <O extends Record> Project(Table<O> path, ForeignKey<O, ProjectRecord> childPath, InverseForeignKey<O, ProjectRecord> parentPath) {
        super(path, childPath, parentPath, PROJECT);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class ProjectPath extends Project implements Path<ProjectRecord> {

        private static final long serialVersionUID = 1157287883;
        public <O extends Record> ProjectPath(Table<O> path, ForeignKey<O, ProjectRecord> childPath, InverseForeignKey<O, ProjectRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private ProjectPath(Name alias, Table<ProjectRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public ProjectPath as(String alias) {
            return new ProjectPath(DSL.name(alias), this);
        }

        @Override
        public ProjectPath as(Name alias) {
            return new ProjectPath(alias, this);
        }

        @Override
        public ProjectPath as(Table<?> alias) {
            return new ProjectPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.PROJECT_CLASSIFIER_IDX, Indexes.PROJECT_CPE_IDX, Indexes.PROJECT_GROUP_IDX, Indexes.PROJECT_INACTIVE_SINCE_IDX, Indexes.PROJECT_IS_LATEST_IDX, Indexes.PROJECT_LAST_RISKSCORE_IDX, Indexes.PROJECT_LASTBOMIMPORT_FORMAT_IDX, Indexes.PROJECT_LASTBOMIMPORT_IDX, Indexes.PROJECT_NAME_IDX, Indexes.PROJECT_NAME_VERSION_IDX, Indexes.PROJECT_NAME_VERSION_NULL_IDX, Indexes.PROJECT_PARENT_PROJECT_ID_IDX, Indexes.PROJECT_PURL_IDX, Indexes.PROJECT_SWID_TAGID_IDX, Indexes.PROJECT_VERSION_IDX);
    }

    @Override
    public Identity<ProjectRecord, Long> getIdentity() {
        return (Identity<ProjectRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<ProjectRecord> getPrimaryKey() {
        return Keys.PROJECT_PK;
    }

    @Override
    public List<UniqueKey<ProjectRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.PROJECT_UUID_IDX);
    }

    @Override
    public List<ForeignKey<ProjectRecord, ?>> getReferences() {
        return Arrays.asList(Keys.PROJECT_PROJECT_FK);
    }

    private transient ProjectPath _project;

    /**
     * Get the implicit join path to the <code>PROJECT</code> table.
     */
    public ProjectPath project() {
        if (_project == null)
            _project = new ProjectPath(this, Keys.PROJECT_PROJECT_FK, null);

        return _project;
    }

    private transient AnalysisPath _analysis;

    /**
     * Get the implicit to-many join path to the <code>ANALYSIS</code> table
     */
    public AnalysisPath analysis() {
        if (_analysis == null)
            _analysis = new AnalysisPath(this, null, Keys.ANALYSIS_PROJECT_FK.getInverseKey());

        return _analysis;
    }

    private transient BomPath _bom;

    /**
     * Get the implicit to-many join path to the <code>BOM</code> table
     */
    public BomPath bom() {
        if (_bom == null)
            _bom = new BomPath(this, null, Keys.BOM_PROJECT_FK.getInverseKey());

        return _bom;
    }

    private transient ComponentPath _component;

    /**
     * Get the implicit to-many join path to the <code>COMPONENT</code> table
     */
    public ComponentPath component() {
        if (_component == null)
            _component = new ComponentPath(this, null, Keys.COMPONENT_PROJECT_FK.getInverseKey());

        return _component;
    }

    private transient DependencyMetricsPath _dependencyMetrics;

    /**
     * Get the implicit to-many join path to the <code>DEPENDENCYMETRICS</code>
     * table
     */
    public DependencyMetricsPath dependencyMetrics() {
        if (_dependencyMetrics == null)
            _dependencyMetrics = new DependencyMetricsPath(this, null, Keys.DEPENDENCYMETRICS_PROJECT_FK.getInverseKey());

        return _dependencyMetrics;
    }

    private transient FindingAttributionPath _findingAttribution;

    /**
     * Get the implicit to-many join path to the <code>FINDINGATTRIBUTION</code>
     * table
     */
    public FindingAttributionPath findingAttribution() {
        if (_findingAttribution == null)
            _findingAttribution = new FindingAttributionPath(this, null, Keys.FINDINGATTRIBUTION_PROJECT_FK.getInverseKey());

        return _findingAttribution;
    }

    private transient NotificationRuleProjectsPath _notificationRuleProjects;

    /**
     * Get the implicit to-many join path to the
     * <code>NOTIFICATIONRULE_PROJECTS</code> table
     */
    public NotificationRuleProjectsPath notificationRuleProjects() {
        if (_notificationRuleProjects == null)
            _notificationRuleProjects = new NotificationRuleProjectsPath(this, null, Keys.NOTIFICATIONRULE_PROJECTS_PROJECT_FK.getInverseKey());

        return _notificationRuleProjects;
    }

    private transient PolicyProjectsPath _policyProjects;

    /**
     * Get the implicit to-many join path to the <code>POLICY_PROJECTS</code>
     * table
     */
    public PolicyProjectsPath policyProjects() {
        if (_policyProjects == null)
            _policyProjects = new PolicyProjectsPath(this, null, Keys.POLICY_PROJECTS_PROJECT_FK.getInverseKey());

        return _policyProjects;
    }

    private transient PolicyViolationPath _policyViolation;

    /**
     * Get the implicit to-many join path to the <code>POLICYVIOLATION</code>
     * table
     */
    public PolicyViolationPath policyViolation() {
        if (_policyViolation == null)
            _policyViolation = new PolicyViolationPath(this, null, Keys.POLICYVIOLATION_PROJECT_FK.getInverseKey());

        return _policyViolation;
    }

    private transient ProjectAccessTeamsPath _projectAccessTeams;

    /**
     * Get the implicit to-many join path to the
     * <code>PROJECT_ACCESS_TEAMS</code> table
     */
    public ProjectAccessTeamsPath projectAccessTeams() {
        if (_projectAccessTeams == null)
            _projectAccessTeams = new ProjectAccessTeamsPath(this, null, Keys.PROJECT_ACCESS_TEAMS_PROJECT_FK.getInverseKey());

        return _projectAccessTeams;
    }

    private transient ProjectHierarchyPath _projectHierarchyChildProjectFk;

    /**
     * Get the implicit to-many join path to the <code>PROJECT_HIERARCHY</code>
     * table, via the <code>PROJECT_HIERARCHY_CHILD_PROJECT_FK</code> key
     */
    public ProjectHierarchyPath projectHierarchyChildProjectFk() {
        if (_projectHierarchyChildProjectFk == null)
            _projectHierarchyChildProjectFk = new ProjectHierarchyPath(this, null, Keys.PROJECT_HIERARCHY_CHILD_PROJECT_FK.getInverseKey());

        return _projectHierarchyChildProjectFk;
    }

    private transient ProjectHierarchyPath _projectHierarchyParentProjectFk;

    /**
     * Get the implicit to-many join path to the <code>PROJECT_HIERARCHY</code>
     * table, via the <code>PROJECT_HIERARCHY_PARENT_PROJECT_FK</code> key
     */
    public ProjectHierarchyPath projectHierarchyParentProjectFk() {
        if (_projectHierarchyParentProjectFk == null)
            _projectHierarchyParentProjectFk = new ProjectHierarchyPath(this, null, Keys.PROJECT_HIERARCHY_PARENT_PROJECT_FK.getInverseKey());

        return _projectHierarchyParentProjectFk;
    }

    private transient ProjectMetadataPath _projectMetadata;

    /**
     * Get the implicit to-many join path to the <code>PROJECT_METADATA</code>
     * table
     */
    public ProjectMetadataPath projectMetadata() {
        if (_projectMetadata == null)
            _projectMetadata = new ProjectMetadataPath(this, null, Keys.PROJECT_METADATA_PROJECT_ID_FK.getInverseKey());

        return _projectMetadata;
    }

    private transient ProjectPropertyPath _projectProperty;

    /**
     * Get the implicit to-many join path to the <code>PROJECT_PROPERTY</code>
     * table
     */
    public ProjectPropertyPath projectProperty() {
        if (_projectProperty == null)
            _projectProperty = new ProjectPropertyPath(this, null, Keys.PROJECT_PROPERTY_PROJECT_FK.getInverseKey());

        return _projectProperty;
    }

    private transient ProjectMetricsPath _projectMetrics;

    /**
     * Get the implicit to-many join path to the <code>PROJECTMETRICS</code>
     * table
     */
    public ProjectMetricsPath projectMetrics() {
        if (_projectMetrics == null)
            _projectMetrics = new ProjectMetricsPath(this, null, Keys.PROJECTMETRICS_PROJECT_FK.getInverseKey());

        return _projectMetrics;
    }

    private transient ProjectsTagsPath _projectsTags;

    /**
     * Get the implicit to-many join path to the <code>PROJECTS_TAGS</code>
     * table
     */
    public ProjectsTagsPath projectsTags() {
        if (_projectsTags == null)
            _projectsTags = new ProjectsTagsPath(this, null, Keys.PROJECTS_TAGS_PROJECT_FK.getInverseKey());

        return _projectsTags;
    }

    private transient ServiceComponentPath _serviceComponent;

    /**
     * Get the implicit to-many join path to the <code>SERVICECOMPONENT</code>
     * table
     */
    public ServiceComponentPath serviceComponent() {
        if (_serviceComponent == null)
            _serviceComponent = new ServiceComponentPath(this, null, Keys.SERVICECOMPONENT_PROJECT_FK.getInverseKey());

        return _serviceComponent;
    }

    private transient UserProjectEffectivePermissionsPath _userProjectEffectivePermissions;

    /**
     * Get the implicit to-many join path to the
     * <code>USER_PROJECT_EFFECTIVE_PERMISSIONS</code> table
     */
    public UserProjectEffectivePermissionsPath userProjectEffectivePermissions() {
        if (_userProjectEffectivePermissions == null)
            _userProjectEffectivePermissions = new UserProjectEffectivePermissionsPath(this, null, Keys.USER_PROJECT_EFFECTIVE_PERMISSIONS_PROJECT_FK.getInverseKey());

        return _userProjectEffectivePermissions;
    }

    private transient UserProjectRolesPath _userProjectRoles;

    /**
     * Get the implicit to-many join path to the <code>USER_PROJECT_ROLES</code>
     * table
     */
    public UserProjectRolesPath userProjectRoles() {
        if (_userProjectRoles == null)
            _userProjectRoles = new UserProjectRolesPath(this, null, Keys.USER_PROJECT_ROLES_PROJECT_FK.getInverseKey());

        return _userProjectRoles;
    }

    private transient VexPath _vex;

    /**
     * Get the implicit to-many join path to the <code>VEX</code> table
     */
    public VexPath vex() {
        if (_vex == null)
            _vex = new VexPath(this, null, Keys.VEX_PROJECT_FK.getInverseKey());

        return _vex;
    }

    private transient ViolationAnalysisPath _violationAnalysis;

    /**
     * Get the implicit to-many join path to the <code>VIOLATIONANALYSIS</code>
     * table
     */
    public ViolationAnalysisPath violationAnalysis() {
        if (_violationAnalysis == null)
            _violationAnalysis = new ViolationAnalysisPath(this, null, Keys.VIOLATIONANALYSIS_PROJECT_FK.getInverseKey());

        return _violationAnalysis;
    }

    /**
     * Get the implicit many-to-many join path to the <code>TEAM</code> table
     */
    public TeamPath team() {
        return projectAccessTeams().team();
    }

    /**
     * Get the implicit many-to-many join path to the <code>TAG</code> table
     */
    public TagPath tag() {
        return projectsTags().tag();
    }

    @Override
    public List<Check<ProjectRecord>> getChecks() {
        return Arrays.asList(
            Internal.createCheck(this, DSL.name("PROJECT_CLASSIFIER_check"), "(((\"CLASSIFIER\" IS NULL) OR ((\"CLASSIFIER\")::text = ANY (ARRAY['APPLICATION'::text, 'CONTAINER'::text, 'DEVICE'::text, 'FILE'::text, 'FIRMWARE'::text, 'FRAMEWORK'::text, 'LIBRARY'::text, 'OPERATING_SYSTEM'::text]))))", true)
        );
    }

    @Override
    public Project as(String alias) {
        return new Project(DSL.name(alias), this);
    }

    @Override
    public Project as(Name alias) {
        return new Project(alias, this);
    }

    @Override
    public Project as(Table<?> alias) {
        return new Project(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Project rename(String name) {
        return new Project(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Project rename(Name name) {
        return new Project(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Project rename(Table<?> name) {
        return new Project(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Project where(Condition condition) {
        return new Project(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Project where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Project where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Project where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Project where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Project where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Project where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Project where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Project whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Project whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
