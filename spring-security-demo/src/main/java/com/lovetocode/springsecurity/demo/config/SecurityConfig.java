package com.lovetocode.springsecurity.demo.config;

import com.lovetocode.springsecurity.demo.model.RoleEnum;
import com.lovetocode.springsecurity.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Autowired
    private DataSource securityDataSource;*/

    @Autowired
    private UserService userService;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*// For now, hardcode users for in-memory authentication
        var userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("john").password("test123").roles(RoleEnum.EMPLOYEE.name()))
                .withUser(userBuilder.username("mary").password("test123").roles(RoleEnum.EMPLOYEE.name(), RoleEnum.MANAGER.name()))
                .withUser(userBuilder.username("susan").password("test123").roles(RoleEnum.EMPLOYEE.name(), RoleEnum.ADMIN.name()));*/

        /*// JDBC authentication: let Spring security handle calls to database automatically using defaults
        auth.jdbcAuthentication().dataSource(securityDataSource);*/

        // Custom authentication provider: our entities do not match the Spring security spec anymore, we need to implement everything
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasRole(RoleEnum.EMPLOYEE.name())
                .antMatchers("/leaders/**").hasRole(RoleEnum.MANAGER.name())
                .antMatchers("/systems/**").hasRole(RoleEnum.ADMIN.name())
                .antMatchers("/css/**", "/register/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/loginPage").loginProcessingUrl("/authenticateUser")
                .successHandler(customAuthenticationSuccessHandler).permitAll()
                .and().logout().permitAll()
                .and().exceptionHandling().accessDeniedPage("/accessDenied");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        var authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}
