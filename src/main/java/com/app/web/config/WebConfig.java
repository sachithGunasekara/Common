package com.app.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// TODO: Auto-generated Javadoc
/**
 * The Class WebConfig.
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.app.repository"})
@ComponentScan(basePackages = {"com.app"})
public class WebConfig implements WebMvcConfigurer {

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addViewControllers(org.
   * springframework.web.servlet.config.annotation.ViewControllerRegistry)
   */
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("index");
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/home").setViewName("home");
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.web.servlet.config.annotation.WebMvcConfigurer#configureViewResolvers(org.
   * springframework.web.servlet.config.annotation.ViewResolverRegistry)
   */
  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    registry.jsp().prefix("/WEB-INF/views/").suffix(".jsp");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addResourceHandlers(org.
   * springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
  }



}
