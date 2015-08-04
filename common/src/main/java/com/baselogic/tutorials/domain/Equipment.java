package com.baselogic.tutorials.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Equipment Used
 */
@Embeddable
public class Equipment extends AbstractEntity
        implements Serializable {

    @Column
    String suit;
    String container;
    String parachute;
    String deploymentMethod;

    public Equipment() {
    }

    //--- Common methods ----------------------------------------------------//

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }

}

