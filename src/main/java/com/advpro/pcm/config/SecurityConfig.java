package com.advpro.pcm.config;

import com.advpro.pcm.middleware.JwtAuthFilter;

import static com.advpro.pcm.model.enumtype.Role.ADMIN;
import static com.advpro.pcm.model.enumtype.Role.MEMBER;

import static com.advpro.pcm.model.enumtype.Permission.PROJECT_READ;
import static com.advpro.pcm.model.enumtype.Permission.PROJECT_CREATE;
import static com.advpro.pcm.model.enumtype.Permission.PROJECT_UPDATE;
import static com.advpro.pcm.model.enumtype.Permission.PROJECT_DELETE;

import static com.advpro.pcm.model.enumtype.Permission.COST_CATEGORY_READ;
import static com.advpro.pcm.model.enumtype.Permission.COST_CATEGORY_CREATE;
import static com.advpro.pcm.model.enumtype.Permission.COST_CATEGORY_UPDATE;
import static com.advpro.pcm.model.enumtype.Permission.COST_CATEGORY_DELETE;

import static com.advpro.pcm.model.enumtype.Permission.COST_ITEM_READ;
import static com.advpro.pcm.model.enumtype.Permission.COST_ITEM_CREATE;
import static com.advpro.pcm.model.enumtype.Permission.COST_ITEM_UPDATE;
import static com.advpro.pcm.model.enumtype.Permission.COST_ITEM_DELETE;

import static com.advpro.pcm.model.enumtype.Permission.MEMBER_READ;
import static com.advpro.pcm.model.enumtype.Permission.MEMBER_CREATE;
import static com.advpro.pcm.model.enumtype.Permission.MEMBER_UPDATE;
import static com.advpro.pcm.model.enumtype.Permission.MEMBER_DELETE;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final LogoutHandler logoutHandler;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf()
            .disable()
            .authorizeHttpRequests()

            // Public aceess
            .requestMatchers("/api/v1/auth/**")
            .permitAll()

            // Only logged-in member has ADMIN | MEMBER role. 
            // Only ADMIN has permission to delete a resource.
            .requestMatchers("/api/v1/projects/**").hasAnyRole(ADMIN.name(), MEMBER.name())
            .requestMatchers(GET, "/api/v1/projects/**").hasAnyAuthority(PROJECT_READ.name())
            .requestMatchers(POST, "/api/v1/projects/**").hasAnyAuthority(PROJECT_CREATE.name())
            .requestMatchers(PUT, "/api/v1/projects/**").hasAnyAuthority(PROJECT_UPDATE.name())
            .requestMatchers(DELETE, "/api/v1/projects/**").hasAnyAuthority(PROJECT_DELETE.name())

            // Only logged-in member has ADMIN | MEMBER role. 
            // Only ADMIN has permission to delete a resource.
            .requestMatchers("/api/v1/members/**").hasAnyRole(ADMIN.name(), MEMBER.name())
            .requestMatchers(GET, "/api/v1/members/**").hasAnyAuthority(MEMBER_READ.name())
            .requestMatchers(POST, "/api/v1/members/**").hasAnyAuthority(MEMBER_CREATE.name())
            .requestMatchers(PUT, "/api/v1/members/**").hasAnyAuthority(MEMBER_UPDATE.name())
            .requestMatchers(DELETE, "/api/v1/members/**").hasAnyAuthority(MEMBER_DELETE.name())

            // Only logged-in member has ADMIN | MEMBER role. 
            // Only ADMIN has permission to delete a resource.
            .requestMatchers("/api/v1/costcategories/**").hasAnyRole(ADMIN.name(), MEMBER.name())
            .requestMatchers(GET, "/api/v1/costcategories/**").hasAnyAuthority(COST_CATEGORY_READ.name())
            .requestMatchers(POST, "/api/v1/costcategories/**").hasAnyAuthority(COST_CATEGORY_CREATE.name())
            .requestMatchers(PUT, "/api/v1/costcategories/**").hasAnyAuthority(COST_CATEGORY_UPDATE.name())
            .requestMatchers(DELETE, "/api/v1/costcategories/**").hasAnyAuthority(COST_CATEGORY_DELETE.name())

            // Only logged-in member has ADMIN | MEMBER role. 
            // Only ADMIN has permission to delete a resource.            
            .requestMatchers("/api/v1/costitems/**").hasAnyRole(ADMIN.name(), MEMBER.name())
            .requestMatchers(GET, "/api/v1/costitems/**").hasAnyAuthority(COST_ITEM_READ.name())
            .requestMatchers(POST, "/api/v1/costitems/**").hasAnyAuthority(COST_ITEM_CREATE.name())
            .requestMatchers(PUT, "/api/v1/costitems/**").hasAnyAuthority(COST_ITEM_UPDATE.name())
            .requestMatchers(DELETE, "/api/v1/costitems/**").hasAnyAuthority(COST_ITEM_DELETE.name())

            .anyRequest()
            .authenticated()            
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)

            .logout()
            .logoutUrl("/api/v1/auth/logout")
            .addLogoutHandler(logoutHandler)
            .logoutSuccessHandler((request, response, authentication)->SecurityContextHolder.clearContext());

        return http.build();

    }
    
}