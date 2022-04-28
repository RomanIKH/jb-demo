package com.jetbrains.demo.dto

import org.springframework.security.core.userdetails.User

private const val ROLE_PREFIX = "ROLE_"

data class UserDto(val username: String, val role: Role) {
    companion object {
        fun createFromPrincipal(user: User): UserDto {
            val authorities = user.authorities
            val role = authorities
                    .filter { it.authority.startsWith(ROLE_PREFIX) }
                    .map { Role.create(it.authority) }
                    .first()
            return UserDto(user.username, role)
        }
    }
}
