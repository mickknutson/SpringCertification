package com.baselogic.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Auditable
 *
 * @author Mick Knutson
 * @see Blog: <a href="http://www.baselogic.com">http://baselogic.com</a><br />
 * @see LinkedIN: <a href="http://linkedin.com/in/mickknutson">http://linkedin.com/in/mickknutson</a><br />
 * @see Twitter: <a href="http://twitter.com/mickknutson">http://twitter.com/mickknutson</a><br />
 * @see Github: <a href="http://github.com/mickknutson">http://github.com/mickknutson</a><br />
 * 
 * @see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 6 Cookbook Packt</a><br />
 * @see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 6 Cookbook Amazon</a><br />
 * 
 * @since 2012
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Auditable {
	String value();
}