package com.baselogic.tutorials.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

/**
 * BASE Entity Class
 *
 * @since 2012
 *
 */
//@MappedSuperclass
//@EntityListeners({AuditListener.class})
public abstract class AuditableEntity implements Serializable {


    public static ThreadLocal currentUser = new ThreadLocal();

    @Column(name = JpaConstants.AUDIT_USER)
    protected String auditUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = JpaConstants.AUDIT_TIMESTAMP)
    protected Calendar auditTimestamp;

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
    }

    public Calendar getAuditTimestamp() {
        return auditTimestamp;
    }

    public void setAuditTimestamp(Calendar auditTimestamp) {
        this.auditTimestamp = auditTimestamp;
    }

    @PrePersist
    @PreUpdate
    public void updateAuditInfo() {
        setAuditUser((String) currentUser.get());
        setAuditTimestamp(Calendar.getInstance());
    }

    //-----------------------------------------------------------------------//
    // toString
    //-----------------------------------------------------------------------//

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
