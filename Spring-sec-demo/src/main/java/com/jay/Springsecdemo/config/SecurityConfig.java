package com.jay.Springsecdemo.config;

import com.jay.Springsecdemo.Service.StudentDetailsService;
import com.jay.Springsecdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.concurrent.atomic.DoubleAccumulator;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private StudentDetailsService studentDetailsService;

    private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(12);
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(Customizer->Customizer.disable())
                .authorizeHttpRequests(request->request.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
    @Bean
    public AuthenticationProvider  authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(studentDetailsService);
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        return provider;
    }

}
