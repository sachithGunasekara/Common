package com.app.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// TODO: Auto-generated Javadoc
/**
 * The Class AppSecurityConfig.
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"com.app"})
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

  /** The user details service. */
  @Autowired
  @Qualifier(value = "securityUserDetailsService")
  private UserDetailsService userDetailsService;

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#
   * configure(org.springframework.security.config.annotation.authentication.builders.
   * AuthenticationManagerBuilder)
   */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#
   * configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/","/register","/registerUser").permitAll().anyRequest().authenticated().and().formLogin()
        .loginPage("/login").permitAll().usernameParameter("userid").passwordParameter("passwd")
        .defaultSuccessUrl("/home").and().logout().logoutUrl("/signout").permitAll().and().csrf().disable();

  }

  /**
   * Password encoder.
   *
   * @return the password encoder
   */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();

  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#
   * configure(org.springframework.security.config.annotation.web.builders.WebSecurity)
   */
  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/resources/**");
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#
   * userDetailsService()
   */
  @Override
  protected UserDetailsService userDetailsService() {
    return this.userDetailsService;
  }
}
