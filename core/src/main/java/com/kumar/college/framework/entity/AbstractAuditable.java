package com.kumar.college.framework.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import com.kumar.college.framework.util.DateUtil;

import org.joda.time.DateTime;
import org.pojomatic.annotations.PojomaticPolicy;
import org.pojomatic.annotations.Property;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Abstract base class for auditable entities. Stores the audit values in persistent fields. "Borrowed" from spring-data-jpa.
 *
 * ILR - Added in onPersist and onCreate. These will put in dates and users.
 *
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AbstractAuditable extends AbstractPersistable {

	private static final long serialVersionUID = -2447786456789L;

	@CreatedBy
	@Basic
	@Column(name = "CREATED_BY", updatable = false, nullable = false)
	private String createdBy;

	@CreatedDate
	@Basic
	@Column(name = "CREATED_ON", updatable = false, nullable = false)
	private Long createdDate;

	@LastModifiedBy
	@Basic
	@Column(name = "LAST_UPDATED_BY")
	private String lastModifiedBy;

	@LastModifiedDate
	@Basic
	@Column(name = "LAST_UPDATED_ON")
	private Long lastModifiedDate;

	@Property(policy = PojomaticPolicy.TO_STRING)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(final String createdBy) {
		this.createdBy = createdBy;
	}


	@Property(policy = PojomaticPolicy.TO_STRING)
	public Long getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(final DateTime createdDate) {
		this.createdDate = DateUtil.setMillisForAudit(createdDate);
	}


	@Property(policy = PojomaticPolicy.TO_STRING)
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}


	public void setLastModifiedBy(final String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}


	@Property(policy = PojomaticPolicy.TO_STRING)
	public Long getLastModifiedDate() {
		return lastModifiedDate;
	}


	public void setLastModifiedDate(final DateTime lastModifiedDate) {
		this.lastModifiedDate = DateUtil.setMillisForAudit(lastModifiedDate);
	}

}
