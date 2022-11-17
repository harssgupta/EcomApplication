package com.project.ecomapplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
//configuring
public class SecurityConfig {
//creating a filter chain
    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;

    @Autowired
    private JWTSAuthEntryPoint jwtsAuthEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception
    {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(jwtsAuthEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/seller/**").permitAll()
                .anyRequest().authenticated()
                .and()          
                .httpBasic();
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

@Bean
public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)throws Exception
{
    return authenticationConfiguration.getAuthenticationManager();
}


@Bean
    PasswordEncoder passwordEncoder()
{
    return new BCryptPasswordEncoder();
}
    @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter(){
        return new JWTAuthenticationFilter();
    }


}

