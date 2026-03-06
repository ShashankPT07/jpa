package com.xworkz.bankingSystem.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("com.xworkz.bankingSystem")
public class WebConfiguration {
    public WebConfiguration() {
        System.out.println("this is congif class");
    }
    @Bean
  public ViewResolver viewResolver(){
        return new InternalResourceViewResolver("/",".jsp");
  }
@Bean
  public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(){
      LocalContainerEntityManagerFactoryBean factoryBean=new LocalContainerEntityManagerFactoryBean();
      factoryBean.setPackagesToScan("com.xworkz.bankingSystem.entity");
      factoryBean.setDataSource(dataSource());
      factoryBean.setJpaProperties(properties());
      factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
      return factoryBean;
  }
  public DataSource dataSource(){
      DriverManagerDataSource managerDataSource=new DriverManagerDataSource();
      managerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
      managerDataSource.setUrl("jdbc:mysql://localhost:3306/bank_db");
      managerDataSource.setUsername("root");
      managerDataSource.setPassword("root");
      return managerDataSource;
  }
  public Properties properties(){
Properties properties=new Properties();
properties.setProperty("hibernate.hbm2ddl.auto","update");
properties.setProperty("hibernate.show_sql","true");
return properties;
  }
}
