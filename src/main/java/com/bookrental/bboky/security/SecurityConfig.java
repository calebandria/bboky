package com.bookrental.bboky.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

   /*  @Autowired
    private CustomUsersDetailService usersDetailService; */
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/login", "/register", "/css/**", "/js/**").permitAll()
                .requestMatchers("/livres/**").hasRole("ADMIN")
                .requestMatchers("/adherents/**").hasRole("ADMIN")
                .requestMatchers("/exemplaires/**").hasRole("ADMIN")
                .requestMatchers("/prets/**").hasRole("ADMIN")
                .anyRequest().permitAll()
            )
             .formLogin((form) -> form
                .permitAll()
            )
            .logout((logout) -> logout.permitAll());

        return http.build();
    }

    /* @Bean
    public UserDetailsService userDetailsService(){
        UserDetails normalUser = User.builder()
            .username("user")
            .password("$2a$12$HQrvibTt3s8Bs7Ms/nDFKufp1u.6rhqwhUOz1Tqr4liHDNy4KeJhu")
            .roles("USER")
            .build();

        UserDetails adminUser = User.builder()
            .username("admin")
            .password("$2a$12$HQrvibTt3s8Bs7Ms/nDFKufp1u.6rhqwhUOz1Tqr4liHDNy4KeJhu")
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(normalUser, adminUser);
    } */

 /*    @Bean 
    public UserDetailsService userDetailsService(){
        return usersDetailService;
    } */

  /*   @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(usersDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    } */

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
