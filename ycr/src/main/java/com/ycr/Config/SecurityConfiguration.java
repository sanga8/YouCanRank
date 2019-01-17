package com.ycr.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{


 //@Autowired
 //private BCryptPasswordEncoder bCryptPasswordEncoder;

 @Autowired
 private DataSource dataSource;
 
 private final String USERS_QUERY = "select username, password, active from user where username=?";



 
 

 @Override
 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  auth.jdbcAuthentication()
   .usersByUsernameQuery(USERS_QUERY)
   .authoritiesByUsernameQuery("select username, 'ROLE_USER' from user where username=?")
   .dataSource(dataSource);
   //.passwordEncoder(bCryptPasswordEncoder);
 }
 
 @Override
 protected void configure(HttpSecurity http) throws Exception{
  http
   .authorizeRequests().antMatchers("/resources/**").permitAll().anyRequest().permitAll()
   .and().csrf().disable()
   .formLogin().loginPage("/login").loginProcessingUrl("/login").failureUrl("/login?error=true")
   .defaultSuccessUrl("/index")
   .usernameParameter("username")
   .passwordParameter("password")
   .and().logout()
   .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
   .logoutSuccessUrl("/")
   .and().rememberMe()
   .tokenRepository(persistentTokenRepository())
   .tokenValiditySeconds(3600*3600);
 }
 
 @Bean
 public PersistentTokenRepository persistentTokenRepository() {
  JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
  db.setDataSource(dataSource);
  
  return db;
 }
}