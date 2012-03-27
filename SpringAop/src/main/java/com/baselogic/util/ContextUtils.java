package com.baselogic.util;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.lang.annotation.Annotation;

/**
 * ContextUtils
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
public class ContextUtils {

	private static final Logger logger = LoggerFactory
            .getLogger(ContextUtils.class);
	
    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    BeanFactory beanFactory;

    public void showBeansInContext() {
        DefaultListableBeanFactory factory = (DefaultListableBeanFactory) beanFactory;
        if (factory != null) {
            logger.debug("Bean Factory: '{}'", factory);
        }


        if (applicationContext.getParent() != null) {
            logger.debug("Bean Factory: '{}'", applicationContext.getParentBeanFactory());
        }
        logger.debug("******************************************************************************");
        String[] beans = applicationContext.getBeanDefinitionNames();
        for (String o : beans) {
            logger.debug("________________________");
            logger.debug("BEAN id: '{}'", o);
            logger.debug("\tType: '{}'", applicationContext.getType(o));
            String[] aliases = applicationContext.getAliases(o);
            if (factory.isFactoryBean(o)) logger.debug("\tFACTORY");
            if (aliases != null && aliases.length > 0) {
                for (String a : aliases) {
                    logger.debug("\tAliased as: '{}'", a);
                }
            }
            if (factory.getBeanDefinition(o).isAbstract()) {
                logger.debug("\tABSTRACT");
            } else {
                if (applicationContext.isPrototype(o)) logger.debug("\tScope: 'Prototype'");
                if (applicationContext.isSingleton(o)) logger.debug("\tScope: 'Singleton'");

                Annotation[] annotations = applicationContext.getBean(o).getClass().getAnnotations();
                if (annotations != null && annotations.length > 0) {
                    logger.debug("\tAnnotations:");

                    for (Annotation annotation : annotations) {
                        logger.debug("\t\t'{}'", annotation.annotationType());
                    }
                }
                if (!applicationContext.getBean(o).toString().startsWith(applicationContext.getType(o).toString() + "@"))
                {
                    logger.debug("\tContents: {}", applicationContext.getBean(o).toString());
                }
            }
        }

        logger.debug("******************************************************************************");
        logger.debug("*** Number of Beans={} ***",
                applicationContext.getBeanDefinitionCount());
        logger.debug("*** Number of Bean Post Processors={} ***", factory.getBeanPostProcessorCount());
        logger.debug("******************************************************************************");
    }


    public void showBeansInContext2() {
        DefaultListableBeanFactory factory = (DefaultListableBeanFactory) beanFactory;
        if (factory != null) {
            logger.debug("Bean Factory: '{}'", factory);
        }


        if (applicationContext.getParent() != null) {
            logger.debug("Bean Factory: '{}'", applicationContext.getParentBeanFactory());
        }
        logger.debug("******************************************************************************");
        String[] beans = applicationContext.getBeanDefinitionNames();
        for (String o : beans) {
            logger.debug("________________________");
            logger.debug("BEAN id: '{}'", o);
            logger.debug("\tType: '{}'", applicationContext.getType(o));
            String[] aliases = applicationContext.getAliases(o);
            if (factory.isFactoryBean(o)) logger.debug("\tFACTORY");
            if (aliases != null && aliases.length > 0) {
                for (String a : aliases) {
                    logger.debug("\tAliased as: '{}'", a);
                }
            }
            if (factory.getBeanDefinition(o).isAbstract()) {
                logger.debug("\tABSTRACT");
            } else {
                if (applicationContext.isPrototype(o)) logger.debug("\tScope: 'Prototype'");
                if (applicationContext.isSingleton(o)) logger.debug("\tScope: 'Singleton'");

                Annotation[] annotations = applicationContext.getBean(o).getClass().getAnnotations();
                if (annotations != null && annotations.length > 0) {
                    logger.debug("\tAnnotations:");

                    for (Annotation annotation : annotations) {
                        logger.debug("\t\t'{}'", annotation.annotationType());
                    }
                }
                if (!applicationContext.getBean(o).toString().startsWith(applicationContext.getType(o).toString() + "@")) {
                    logger.debug("\tContents: {}", applicationContext.getBean(o).toString());
                }
            }
        }

        logger.debug("******************************************************************************");
        logger.debug("*** Number of Beans={} ***", applicationContext.getBeanDefinitionCount());
        logger.debug("*** Number of Bean Post Processors={} ***", factory.getBeanPostProcessorCount());
        logger.debug("******************************************************************************");
    }

}
