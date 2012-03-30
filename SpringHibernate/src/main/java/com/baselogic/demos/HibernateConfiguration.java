package com.baselogic.demos;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.dialect.H2Dialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

@Configuration
public class HibernateConfiguration {

	@Value("#{dataSource}")
	private DataSource dataSource;

	@Bean
	public AnnotationSessionFactoryBean sessionFactoryBean() {
		
		Properties props = new Properties();
		props.put("hibernate.dialect", H2Dialect.class.getName());
		props.put("hibernate.format_sql", "true");

		AnnotationSessionFactoryBean bean = new AnnotationSessionFactoryBean();
		
		bean.setAnnotatedClasses(
				new Class[]{
						Item.class, 
						Order.class
				}
		);
		
		bean.setHibernateProperties(props);
		
		bean.setDataSource(this.dataSource);
		
		bean.setSchemaUpdate(true);

		return bean;
	}

	/**
	 * sessionFactoryBean().getObject() // returns Singleton
	 * @return
	 */
	@Bean
	public HibernateTransactionManager transactionManager() {
		
		return new HibernateTransactionManager( sessionFactoryBean().getObject() );
	}

}
