package com.jetbrains.demo.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler


@Configuration
@EnableWebSecurity
class SecurityConfigurerAdapterConfig(private val webExpressionHandler: DefaultWebSecurityExpressionHandler) : WebSecurityConfigurerAdapter() {
    companion object {
        val PERMITTED_ROUTES: Array<String> = arrayOf(
                "/h2/**",
                "/logout*",
                "/login*",
                "/css/*",
                "/js/*",
                "/actuator/**")
    }

    override fun configure(http: HttpSecurity) {
        http
                .csrf().disable()
                .authorizeRequests()
                .expressionHandler(webExpressionHandler)
                .antMatchers(*PERMITTED_ROUTES).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
//                .failureForwardUrl("/login")
                .and()
                .logout()
                .clearAuthentication(true)
                .and()
                .headers().frameOptions().disable() // use this for h2 console accessing

    }

}