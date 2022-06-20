package com.example.ldapgetconfigsettingproperties.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class LdapConfig extends WebSecurityConfigurerAdapter {


    @Value("${security.ldap.url}")
    private String ldapUrl;
    @Value("${security.ldap.user-search-filter}")
    private String userSearchFilter;
    @Value("${security.ldap.user-search-base}")
    private String userSearchBase;
    @Value("${security.ldap.group-search-filter}")
    private String groupSearchFilter;
    @Value("${security.ldap.group-search-base}")
    private String groupSearchBase;
    @Value("${security.ldap.port}")
    private int ldapPort;
    @Value("${security.ldap.manager-dn}")
    private String managerDn;
    @Value("${security.ldap.auth.password}")
    private String authPassword;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/ldap").permitAll()
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
        System.out.println(userSearchFilter);
        auth
                .ldapAuthentication()
                .userSearchFilter(userSearchFilter)
                .userSearchBase(userSearchBase)
                .groupSearchBase(groupSearchBase)
                .groupSearchFilter(groupSearchFilter)
                .contextSource()
                .url(ldapUrl)
                .port(ldapPort)
                .managerDn(managerDn)
                .managerPassword(authPassword);
    }

}