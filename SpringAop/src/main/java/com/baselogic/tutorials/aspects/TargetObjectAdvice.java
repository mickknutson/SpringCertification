package com.baselogic.tutorials.aspects;

import com.baselogic.tutorials.annotations.Auditable;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * TargetObjectAdvice
 * returning="retVal"
 *
 * <p>Spring Certification objective: 2.1 AOP Recommendations</p>
 * <p>Spring Certification objective: 2.2 AOP Pointcuts</p>
 * <p>Spring Certification objective: 2.3 AOP Advice</p>
 *
 * <b>target</b> - limits matching to join points (the execution of methods when using Spring AOP) where the
 * target object (application object being proxied) is an instance of the given type
 *
 * <b>@target</b> - limits matching to join points (the execution of methods when using Spring AOP) where the
 * class of the executing object has an annotation of the given type
 *
 * at_see <a href="http://springcert.sourceforge.net/core-3/index.html#aop">Objective 2.1 AOP Recommendations</a>
 * at_see <a href="http://springcert.sourceforge.net/core-3/index.html#aop">Objective 2.2 AOP Pointcuts</a>
 * at_see <a href="http://springcert.sourceforge.net/core-3/index.html#aop">Objective 2.3 AOP Advice</a>
 *
 * @author Mick Knutson
 * at_see <a href="http://www.baselogic.com">Blog: http://baselogic.com</a>
 * at_see <a href="http://linkedin.com/in/mickknutson">LinkedIN: http://linkedin.com/in/mickknutson</a>
 * at_see <a href="http://twitter.com/mickknutson">Twitter: http://twitter.com/mickknutson</a>
 * at_see <a href="http://github.com/mickknutson">Git hub: http://github.com/mickknutson</a>
 *
 * at_see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 6 Cookbook Packt</a>
 * at_see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 6 Cookbook Amazon</a>
 *
 * @since 2012
 *
 */
@Aspect
public class TargetObjectAdvice {

	private final Logger logger = LoggerFactory.getLogger(TargetObjectAdvice.class);


	/**
	 * Within a given package
	 */
    @Pointcut("within(com.baselogic.tutorials.service..*)")
    private void inService() {}


	@After("inService() " +
			"&& @annotation(auditable) " +
			"&& target(bean)")
	public void auditableAnnotation(Auditable auditable, Object bean) throws Throwable {

		logger.info(">>> ----- auditableAnnotation...>>> {}", auditable.value());
	}

}
