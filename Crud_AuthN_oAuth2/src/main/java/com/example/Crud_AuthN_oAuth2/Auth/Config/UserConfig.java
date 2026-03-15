package com.example.Crud_AuthN_oAuth2.Auth.Config;


import com.example.Crud_AuthN_oAuth2.Auth.Security.AUserJwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class UserConfig {

    private final AUserJwtFilter aJwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf((c) -> c.disable())
                        .sessionManagement((s) ->
                                s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/user/crud/**").permitAll()
                        .requestMatchers("login.html").permitAll()
                        .requestMatchers("signup.html").permitAll()
                        .requestMatchers("crud.html").permitAll()
                        .requestMatchers("api/auth/signup").permitAll()
                        .requestMatchers("api/auth/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/user/crud/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "api/user/crud/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "api/user/crud/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "api/user/crud/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(aJwtFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
