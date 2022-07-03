package com.spring.secirity.infrastructure.http.oath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    };

    @Autowired
    private void ConfigureGlobal(AuthenticationManagerBuilder auth, UserDatails userDatails) throws Exception {
        auth.userDetailsService(userDatails).passwordEncoder(this.encoder());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        String[] allowed = new String[]{
                "/wejars", "/static/**", "/users"
        };
        return http.csrf().disable()
                .authorizeRequests()
                .antMatchers(allowed).permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and().build();
    }
}
