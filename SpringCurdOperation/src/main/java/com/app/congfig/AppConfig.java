package com.app.congfig;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@PropertySource("classpath:jdbc.properties")
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.app")
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;

	@Bean
	public BasicDataSource dsObj() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(env.getProperty("dc"));
		ds.setUrl(env.getProperty("url"));
		ds.setUsername(env.getProperty("un"));
		ds.setPassword(env.getProperty("pwd"));
		ds.setInitialSize(5);
		ds.setMaxTotal(5);
		ds.setMaxIdle(5);
		ds.setMinIdle(5);
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean sfObj() {
	
		LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
		sf.setDataSource(dsObj());
		sf.setHibernateProperties(prps());
		sf.setAnnotatedClasses();
		return sf;
		
	}

	private Properties prps() {
		Properties p=new Properties();
		p.put("hibernate.dialect",env.getProperty("dialect"));
		p.put("hibernate.show_sql",env.getProperty("showsql"));
		p.put("hibernate.format_sql",env.getProperty("fmtsql"));
		p.put("hibernate.hbm2ddl.auto",env.getProperty("ddlauto"));
		return p;
	}
	
	//HibernateTemplate
	@Bean
	public HibernateTemplate htObj() {
		HibernateTemplate ht=new HibernateTemplate();
		ht.setSessionFactory(sfObj().getObject());
		return ht;
	}
	
	//Hibernate Transtaion Mangar
	
	@Bean
	public HibernateTransactionManager htmObj() {
		HibernateTransactionManager htm=new HibernateTransactionManager();
		htm.setSessionFactory(sfObj().getObject());
		return htm;
	}
	    @Bean
		public InternalResourceViewResolver ivr() {
			InternalResourceViewResolver iv=new InternalResourceViewResolver();
			iv.setPrefix("/WEB-INF/views/");
			iv.setSuffix(".jsp");
			return iv;
			
		}
	}


