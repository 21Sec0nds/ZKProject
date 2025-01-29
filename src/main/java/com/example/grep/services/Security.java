package com.example.grep.services;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class Security {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        /*http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/web/login.zul").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/web/login.zul")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/web/home.zul", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/web/login.zul")
                        .permitAll()
                );*/


        //DEFAULT
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/", "/resources/web/**", "/resources/**", "/static/**", "/css/**", "/js/**", "/images/**","/presupuestos/login").permitAll()// Permitir acceso al login.zul y recursos estáticos
//                        .requestMatchers("/presupuestos/login").anonymous()
//                        .anyRequest().authenticated() // Requiere autenticación para otros recursos
//                )
//                .formLogin(form -> form
//                        //.loginPage("/presupuestos/login") // Indica el archivo ZUL como página de login
//                        .permitAll() // Permitir acceso sin autenticación
//                        .defaultSuccessUrl("/presupuestos", true)
//                )
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/presupuestos/login") // Redirigir al login.zul tras el logout
//                );

//        http
//                .authorizeHttpRequests()
//                .requestMatchers("/web/**", "/zkau/web/**","/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/font/**","/presupuestos/login", "/zkau/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin( aa ->
//                        aa.loginPage("/presupuestos/login")
//                )
//                //.defaultSuccessUrl("/presupuestos", true)
//                .logout()
//                .logoutSuccessUrl("/")
//                .and()
//                .csrf().disable();

//
        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/zkau/**",          // Asegurar que es el primer matcher
                                "/web/**",
                                "/zkau",
                                "/zkau/web/**",
                                "/resources/**",
                                "/static/**",
                                "/css/**",
                                "/js/**",
                                "/images/**",
                                "/font/**",
                                "/presupuestos/login.zul",  // Archivo ZUL
                                "/presupuestos/login",      // Endpoint POST
                                "/login.zul",      // Endpoint POST
                                "/error/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        //.loginPage("/presupuestos/login")
                        .loginProcessingUrl("/presupuestos/login")
                        .defaultSuccessUrl("/presupuestos", true)
                        .failureUrl("/presupuestos/login?error=true")
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/presupuestos/login")
                        .deleteCookies("JSESSIONID")
                );

        /*.exceptionHandling(exception -> exception
                        .authenticationEntryPoint((request, response, authException) -> {
                            if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
                                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");
                            } else {
                                response.sendRedirect("/presupuestos/login");
                            }
                        })
                );*/


        //http.authorizeHttpRequests().anyRequest().authenticated();
        
        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(List<AuthenticationProvider> authenticationProviders) {
        return new ProviderManager(authenticationProviders);
    }
}