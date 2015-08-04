package com.baselogic.tutorials.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Malfunction
 */
@Embeddable
public class Malfunction implements Serializable {

    @Column
    private String name;
    private String description;

    public Malfunction() {}

    //--- Common methods ----------------------------------------------------//

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }

}
