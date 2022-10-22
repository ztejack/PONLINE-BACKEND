// package com.api.ponline.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfiguration {

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http.authorizeRequests()
//             .antMatchers("/users/register")
//             .permitAll()
//             .and()
//             .authorizeRequests()
//             .antMatchers("/documentation.html")
//             .hasRole("PEMILIK")
//             .anyRequest()
//             .authenticated()
//             .and()
//             .httpBasic();
//         return http.build();
//     }
// }