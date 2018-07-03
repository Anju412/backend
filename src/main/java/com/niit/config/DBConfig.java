package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.UserDetail;

@Configuration
@EnableTransactionManagement
public class DBConfig {

	@Bean
	public DataSource getH2Datasource()
	{
		DriverManagerDataSource datasrc=new DriverManagerDataSource();
		datasrc.setDriverClassName("org.h2.Driver");
		datasrc.setUrl("jdbc:h2:tcp://localhost/~/test");
		datasrc.setUsername("sa");
		datasrc.setPassword("");
		
		System.out.println("Data Source object Created");
				
		return datasrc;
	}
	
	@Bean(name="sessionFactory")
public SessionFactory getSessionFactory()
{
	Properties prp=new Properties();
			prp.put("hibernate.hbm2ddl.auto","update");
	        prp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	        
	        LocalSessionFactoryBuilder sfb=new LocalSessionFactoryBuilder(getH2Datasource());
	        sfb.addProperties(prp);
	        sfb.addPackage("com.niit.model");
	        
	       sfb.addAnnotatedClass(Category.class);
	       sfb.addAnnotatedClass(Product.class);
	       sfb.addAnnotatedClass(Supplier.class);
	       sfb.addAnnotatedClass(UserDetail.class);
	        
	        SessionFactory sf=sfb.buildSessionFactory();
	        System.out.println("sessionFactory object Created");
	        return sf;
}



	@Bean
public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sf)
{
		System.out.println("HibernateTransaction object Created");
		return new HibernateTransactionManager(sf);
}
	}

