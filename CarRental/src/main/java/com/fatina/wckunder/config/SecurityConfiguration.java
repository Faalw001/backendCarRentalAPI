package com.fatina.wckunder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.AbstractConfiguredSecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
            .withUser("user")
            .password("user")
            .roles("USER")
            .and()
            .withUser("admin")
            .password("admin")
            .roles("ADMIN");
    }

        @Bean
        public PasswordEncoder getPasswordEncoder() {return NoOpPasswordEncoder.getInstance();}

        @Override
        public void configure(HttpSecurity http) throws Exception{

            http.httpBasic()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/api/v1/cars").hasRole("USER")
                    .antMatchers("/api/v1/updateorder").hasRole("USER")
                    .antMatchers("/api/v1/ordercar").hasRole("USER")
                    .antMatchers("/api/v1/myorders").hasRole("USER")
                    .antMatchers("/api/v1/exchange").hasRole("USER")

                    .antMatchers("/api/v1/getuser").hasRole("ADMIN")
                    .antMatchers("/api/v1/customers").hasRole("ADMIN")
                    .antMatchers("/api/v1/updatecar").hasRole("ADMIN")
                    .antMatchers("/api/v1/deletecar").hasRole("ADMIN")
                    .antMatchers("/api/v1/cancelorder").hasRole("ADMIN")
                    .antMatchers("/api/v1/orders").hasRole("ADMIN")
                    .antMatchers("/api/v1/addcar").hasRole("ADMIN");
                   http.csrf().disable();

        }
    }


