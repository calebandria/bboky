package com.bookrental.bboky.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CacheControlFilter cacheControlFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
            .addFilterBefore(cacheControlFilter, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class)
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/login", "/register", "/css/**", "/js/**").permitAll()
                .requestMatchers("/livres/**").hasRole("ADMIN")
                .requestMatchers("/adherents/**").hasRole("ADMIN")
                .requestMatchers("/exemplaires/**").hasRole("ADMIN")
                .requestMatchers("/prets/**").hasRole("ADMIN")
                .anyRequest().permitAll()
            )
             .formLogin((form) -> form 
                .loginPage("/login")
                .permitAll()
                .successHandler(customAuthenticationSuccessHandler())
            )
            .logout((logout) -> logout
                .logoutUrl("/logout") 
                .logoutSuccessUrl("/login?logout") 
                .invalidateHttpSession(true) 
                .deleteCookies("JSESSIONID")
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(CustomUsersDetailService usersDetailService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(usersDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler(){
        return(request, response, authentication) -> {
            String username = authentication.getName();
            response.sendRedirect("/user/" + username);
        };
    }

}
