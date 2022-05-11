package com.jetbrains.demo.dto

import org.springframework.security.core.userdetails.User

private const val ROLE_PREFIX = "ROLE_"

data class UserPrincipalDto(val username: String, val role: Role) {
    companion object {
        fun createFromPrincipal(user: User): UserPrincipalDto {
            val authorities = user.authorities
            val role = authorities
                    .filter { it.authority.startsWith(ROLE_PREFIX) }
                    .map { Role.create(it.authority) }
                    .first()
            return UserPrincipalDto(user.username, role)
        }
    }
}
