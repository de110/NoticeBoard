package com.ttff.board1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/**", "/static/css/**", "/static/img/**",
                        "/static/js/**", "/static/**", "/**/*", "/board", "api/hello")
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/api/**").permitAll()
                // .antMatchers("/api/login").authenticated()
                .anyRequest().authenticated()
                .and().csrf().disable();

    }

}