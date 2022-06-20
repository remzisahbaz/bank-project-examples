package com.example.ldap.config;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebSecurity
@EnableLdapRepositories
public class LdapConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
             //  .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

//    @Bean (name = "ldap")
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication()
                .userSearchFilter("(uid={0})")
                .userSearchBase("dc=example,dc=com")
                .groupSearchBase("ou=mathematicians,dc=example,dc=com")
                .groupSearchFilter("cn={0}")
                .contextSource()
                .url("ldap://ldap.forumsys.com")
                .port(389)
                .managerDn("cn=read-only-admin,dc=example,dc=com")
                .managerPassword("password");

    }

    @Override
    protected UserDetailsService userDetailsService() {

        return super.userDetailsService();

    }
}