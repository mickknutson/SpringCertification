package com.baselogic.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * ComponentBeanFactoryPostProcessor
 * 
 * NOTE: A BeanFactoryPostProcessor modifies bean definitions, 
 * while a BeanPostProcessor replaces bean instances (such as when creating a proxy).
 *
 * <p>Spring Certification objective: 1.2 Lifecycle</p>
 * 
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html#beans">Objective 1.2 Lifecycle</a>
 *
 * @author Mick Knutson
 * @see <a href="http://www.baselogic.com">Blog: http://baselogic.com</a>
 * @see <a href="http://linkedin.com/in/mickknutson">LinkedIN: http://linkedin.com/in/mickknutson</a>
 * @see <a href="http://twitter.com/mickknutson">Twitter: http://twitter.com/mickknutson</a>
 * @see <a href="http://github.com/mickknutson">Git hub: http://github.com/mickknutson</a>
 * 
 * @see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 7 Cookbook Packt</a>
 * @see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 7 Cookbook Amazon</a>
 * 
 * @since 2012
 * 
 */
@Component
public class ComponentBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	private static final Logger logger = LoggerFactory.getLogger(ComponentBeanFactoryPostProcessor.class);

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		logger.info(">>> bfpp.ppBf >> postProcessBeanFactory...");
		
		BeanDefinition beanDefinition = beanFactory
				.getBeanDefinition("exampleServiceInitializingBeanImpl");
		
		logger.info(beanDefinition.toString());

		// Register a new Alias
		beanFactory.registerAlias("exampleServiceInitializingBeanImpl",
				"exampleServiceInitializingBeanImplBeanFactoryPostProcessed");
		
		logger.info(">>> bfpp.ppBf >> Can change bean definition here.. for beanDefinition: {}"
						, beanDefinition.toString());
	}
	
}
