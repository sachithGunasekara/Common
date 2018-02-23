package com.app.web.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

// TODO: Auto-generated Javadoc
/**
 * The Class AppConfig.
 */
@Configuration
@PropertySource("classpath:db.properties")
public class AppConfig {

  /** The env. */
  @Autowired
  private Environment env;

  /**
   * Gets the data source.
   *
   * @return the data source
   */
  @Bean
  public DataSource getDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(env.getProperty("mysql.driver"));
    dataSource.setUrl(env.getProperty("mysql.jdbcUrl"));
    dataSource.setUsername(env.getProperty("mysql.username"));
    dataSource.setPassword(env.getProperty("mysql.password"));
    return dataSource;
  }

  /**
   * Entity manager factory.
   *
   * @return the local container entity manager factory bean
   */
  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(getDataSource());
    entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
    entityManagerFactoryBean.setPackagesToScan(env.getProperty("entitymanager.packages.to.scan"));
    entityManagerFactoryBean.setJpaProperties(hibProperties());
    return entityManagerFactoryBean;
  }

  /**
   * Hib properties.
   *
   * @return the properties
   */
  private Properties hibProperties() {
    Properties properties = new Properties();
    properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
    properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
    properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
    return properties;
  }

  /**
   * Transaction manager.
   *
   * @return the jpa transaction manager
   */
  @Bean
  public JpaTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return transactionManager;
  }
}
