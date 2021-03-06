package net.kzn.shoppingbackend.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//Will scan the Entity classes like Category and many more
@ComponentScan(basePackages ={"net.kzn.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	// Create % static final varibale for database connection
	
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASS = "";

	//providing necessary database connection info
	@Bean
	public DataSource getDataSource(){
		BasicDataSource datasource = new BasicDataSource();
		
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUrl(DATABASE_URL);
		datasource.setUsername(DATABASE_USERNAME);
		datasource.setPassword(DATABASE_PASS);
		
		return datasource;
	}
	
	// Session factory bean - It will use the datasource so that it will produce a session for a particular user
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource)
	{
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(datasource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.kzn.shoppingbackend.dto");
		
		return builder.buildSessionFactory();
	}
	
	private Properties getHibernateProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.dialect",DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		//properties.put("hibernate.hbm2ddl.auto", "update");
		
		return properties;
		
	}
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionfactory) 
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionfactory);
		
		return transactionManager;
	}
}
