package com.jetbrains.demo.config

import com.jetbrains.demo.dto.Role
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler
import org.springframework.security.access.hierarchicalroles.RoleHierarchy
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl
import org.springframework.security.access.vote.RoleHierarchyVoter
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true,jsr250Enabled = true)
class RoleConfig : GlobalMethodSecurityConfiguration() {
    override fun createExpressionHandler(): MethodSecurityExpressionHandler {
        val expressionHandler = super.createExpressionHandler() as DefaultMethodSecurityExpressionHandler
        expressionHandler.setRoleHierarchy(roleHierarchy())
        return expressionHandler
    }

    @Bean
    fun roleHierarchy(): RoleHierarchy? {
        val roleHierarchy = RoleHierarchyImpl()
        val hierarchy = "${Role.ADMIN.authorityName} > ${Role.REVIEWER.authorityName} > ${Role.USER.authorityName}"
        roleHierarchy.setHierarchy(hierarchy)
        return roleHierarchy
    }

    @Bean
    fun roleVoter(): RoleHierarchyVoter? = RoleHierarchyVoter(roleHierarchy())
}