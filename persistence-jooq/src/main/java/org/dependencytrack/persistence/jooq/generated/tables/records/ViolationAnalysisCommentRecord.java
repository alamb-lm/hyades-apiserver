/*
 * This file is generated by jOOQ.
 */
package org.dependencytrack.persistence.jooq.generated.tables.records;


import java.time.OffsetDateTime;

import org.dependencytrack.persistence.jooq.generated.tables.ViolationAnalysisComment;
import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class ViolationAnalysisCommentRecord extends UpdatableRecordImpl<ViolationAnalysisCommentRecord> {

    private static final long serialVersionUID = -1450450248;

    /**
     * Setter for <code>VIOLATIONANALYSISCOMMENT.ID</code>.
     */
    public ViolationAnalysisCommentRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>VIOLATIONANALYSISCOMMENT.ID</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>VIOLATIONANALYSISCOMMENT.COMMENT</code>.
     */
    public ViolationAnalysisCommentRecord setComment(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>VIOLATIONANALYSISCOMMENT.COMMENT</code>.
     */
    public String getComment() {
        return (String) get(1);
    }

    /**
     * Setter for <code>VIOLATIONANALYSISCOMMENT.COMMENTER</code>.
     */
    public ViolationAnalysisCommentRecord setCommenter(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>VIOLATIONANALYSISCOMMENT.COMMENTER</code>.
     */
    public String getCommenter() {
        return (String) get(2);
    }

    /**
     * Setter for <code>VIOLATIONANALYSISCOMMENT.TIMESTAMP</code>.
     */
    public ViolationAnalysisCommentRecord setTimestamp(OffsetDateTime value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>VIOLATIONANALYSISCOMMENT.TIMESTAMP</code>.
     */
    public OffsetDateTime getTimestamp() {
        return (OffsetDateTime) get(3);
    }

    /**
     * Setter for <code>VIOLATIONANALYSISCOMMENT.VIOLATIONANALYSIS_ID</code>.
     */
    public ViolationAnalysisCommentRecord setViolationanalysisId(Long value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>VIOLATIONANALYSISCOMMENT.VIOLATIONANALYSIS_ID</code>.
     */
    public Long getViolationanalysisId() {
        return (Long) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ViolationAnalysisCommentRecord
     */
    public ViolationAnalysisCommentRecord() {
        super(ViolationAnalysisComment.VIOLATIONANALYSISCOMMENT);
    }

    /**
     * Create a detached, initialised ViolationAnalysisCommentRecord
     */
    public ViolationAnalysisCommentRecord(Long id, String comment, String commenter, OffsetDateTime timestamp, Long violationanalysisId) {
        super(ViolationAnalysisComment.VIOLATIONANALYSISCOMMENT);

        setId(id);
        setComment(comment);
        setCommenter(commenter);
        setTimestamp(timestamp);
        setViolationanalysisId(violationanalysisId);
        resetTouchedOnNotNull();
    }
}
