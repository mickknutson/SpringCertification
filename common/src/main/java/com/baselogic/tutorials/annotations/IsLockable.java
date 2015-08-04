package com.baselogic.tutorials.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Auditable
 *
 * @since 2012
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface IsLockable {

	String value();

}
