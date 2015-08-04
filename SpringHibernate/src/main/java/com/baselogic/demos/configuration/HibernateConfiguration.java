package com.baselogic.demos.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import com.baselogic.demos.Item;
import com.baselogic.demos.Order;
import org.hibernate.dialect.H2Dialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

/**
 * HibernateConfiguration
 *
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html">Objectives</a><br />
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
