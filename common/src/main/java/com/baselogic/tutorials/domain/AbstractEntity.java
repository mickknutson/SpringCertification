package com.baselogic.tutorials.domain;

//import com.github.peholmst.stuff4vaadin.clone.CloneUtil;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity implements java.io.Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Version
    protected Long version;



    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (o.getClass() != getClass()) {
            return false;
        }
        final AbstractEntity other = (AbstractEntity) o;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        if (id == null) {
            return getClass().hashCode();
        } else {
            return id.hashCode();
        }
    }

    @Override
    public AbstractEntity clone() {
        try {
            return (AbstractEntity) super.clone();
//            return CloneUtil.deepClone((AbstractEntity) super.clone());
        } catch (CloneNotSupportedException ex) {
            throw new InternalError(ex.getMessage());
        }
    }
}
