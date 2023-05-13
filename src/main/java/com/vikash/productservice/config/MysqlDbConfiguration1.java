package com.vikash.productservice.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class MysqlDbConfiguration1 {
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		
		LocalSessionFactoryBean sessionFactory = 
				new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setHibernateProperties(getConnectionProperties());
		sessionFactory.setPackagesToScan("com.vikash.productservice.entity");
		return sessionFactory;
	}
	
	@Bean
	public DataSource getDataSource() {
		
		DriverManagerDataSource dataSource = 
				new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/wakanda");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	public static Properties getConnectionProperties() {
		
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL55Dialect");
		properties.setProperty("hibernate.show_sql","true");
		properties.setProperty("hibernate.hbm2ddl.auto","update");
		return properties;
	}
}
	
