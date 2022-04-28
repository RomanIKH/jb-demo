package com.jetbrains.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@Configuration

class SecurityConfig : WebSecurityConfigurerAdapter() {
    companion object {
        val PERMITTED_ROUTES: Array<String> = arrayOf("/h2/**", "/logout*", "/login*", "/css/*", "/js/*")
    }

    @Bean
    fun encoder(): PasswordEncoder = BCryptPasswordEncoder()

    override fun configure(http: HttpSecurity) {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(*PERMITTED_ROUTES).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .and()
                .headers().frameOptions().disable() // use this for h2 console accessing

    }


}