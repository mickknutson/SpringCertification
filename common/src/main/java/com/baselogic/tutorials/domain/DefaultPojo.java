package com.baselogic.tutorials.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Required;

/**
 * <p>Spring Certification objective: 1.2 Lifecycle</p>
 *
 * @since 2012
 *
 */
public class DefaultPojo {

	private Long id;

	private String description;

	public DefaultPojo() {}

    public DefaultPojo(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    @Required
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
