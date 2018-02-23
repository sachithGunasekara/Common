package com.app.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// TODO: Auto-generated Javadoc
/**
 * The Class WebAppInitializer.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#
   * getRootConfigClasses()
   */
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] {AppConfig.class, AppSecurityConfig.class};
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#
   * getServletConfigClasses()
   */
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] {WebConfig.class};
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletMappings()
   */
  @Override
  protected String[] getServletMappings() {
    return new String[] {"/"};
  }

}
