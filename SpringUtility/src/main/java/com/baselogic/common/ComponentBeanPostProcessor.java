package com.baselogic.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import java.beans.PropertyDescriptor;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.baselogic.annotations.Timestamp;
import com.baselogic.service.ExampleServiceInitializingBeanImpl;

/**
 * ComponentBeanPostProcessor
 *
 * NOTE: A BeanFactoryPostProcessor modifies bean definitions, 
 * while a BeanPostProcessor replaces bean instances (such as when creating a proxy).
 * 
 * <p>Spring Certification objective: 1.2</p>
 * 
 * @see http://springcert.sourceforge.net/core-3/index.html#beans
 *
 * @author Mick Knutson
 * <p><a href="http://www.baselogic.com">Blog: http://baselogic.com</a></p>
 * <p><a href="http://linkedin.com/in/mickknutson">LinkedIN: http://linkedin.com/in/mickknutson</a></p>
 * <p><a href="http://twitter.com/mickknutson">Twitter: http://twitter.com/mickknutson</a></p>
 * <p><a href="http://github.com/mickknutson">Git hub: http://github.com/mickknutson</a></p>
 * 
 * @since 2012
 * 
 */
@Component
public class ComponentBeanPostProcessor implements BeanPostProcessor {

	private static final Logger logger = LoggerFactory.getLogger(ComponentBeanPostProcessor.class);

	/**
	 * for every bean that has @Timestamp, inject a new Date().
	 */
	@Override	
	public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
		logger.info(">>> bpp.ppBi >> Bean : {} can be postProcessedAfterInitialization here..", bean);

        Class<? extends Object> clazz = bean.getClass();
        
        ReflectionUtils.doWithMethods(clazz, new ReflectionUtils.MethodCallback() {
            public void doWith(Method method) {
                if (method.isAnnotationPresent(Timestamp.class)) {
                	logger.info(">>>---postProcessBeforeInitialization---------------------------------------------->>>");
                    try {
                        PropertyDescriptor pd = BeanUtils.findPropertyForMethod(method);

                        Date originalValue = (Date) pd.getReadMethod().invoke(bean, null);
                        if(originalValue == null){ originalValue = new Date(0); }
                        Date doubledValue = new Date(originalValue.getTime() * 2 );

                        // set doubled value
                        pd.getWriteMethod().invoke(bean, new Object[] { doubledValue });

						logger.info(">>> Bean : {} original date value: {}", bean, originalValue);
						logger.info(">>> Bean : {} new date value: {}", bean, doubledValue);
                    } catch (Throwable e) {
                        logger.error(e.getMessage(), e);
                    }
                	logger.info(">>>---end postProcessBeforeInitialization---------------------------------------------->>>");
                }
            }
        });

        return bean;
    }
	
	public Object postProcessBeforeInitialization2(final Object bean, final String beanName)
			throws BeansException {
		logger.info(">>> bpp.ppBi >> Bean : {} can be postProcessedAfterInitialization here..", bean);

		ReflectionUtils.doWithFields(bean.getClass(),
				new ReflectionUtils.FieldCallback() {
					public void doWith(Field field)
							throws IllegalArgumentException,
							IllegalAccessException {
						logger.info(">>> Bean : {} original date value: {}", bean, field.get(bean));
						logger.info(">>> Bean : {} new date value: {}", bean, new Date());
						field.set(bean, new Date());
					}
				}, new ReflectionUtils.FieldFilter() {
					public boolean matches(Field field) {
						return field.getType() == Date.class
								&& field.getAnnotation(Timestamp.class) != null;
					}
				});
		return bean;
	}

	
	@Override
	public Object postProcessAfterInitialization(final Object bean,
			final String beanName) throws BeansException {
		logger.info(">>> bpp.ppAi >> Bean : {} can be postProcessedBeforeInitialization here..", bean);
		return bean;
	}
}
