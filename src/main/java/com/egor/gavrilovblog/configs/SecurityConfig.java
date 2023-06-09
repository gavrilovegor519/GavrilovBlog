package com.egor.gavrilovblog.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/admin/**",
                                "/rest/publish",
                                "/rest/modify/**",
                                "/rest/delete/**").hasRole("ADMIN")
                        .anyRequest().permitAll())
                .formLogin((form) -> form
                        .loginPage("/admin/login")
                        .defaultSuccessUrl("/admin/addPost")
                        .loginProcessingUrl("/login")
                        .permitAll())
                .httpBasic(Customizer.withDefaults())
                .csrf((csrf) -> csrf.disable())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User
                .withUsername("egor").password("qwerty")
                .roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user);
    }
}
