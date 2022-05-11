package com.jetbrains.demo.dto

import java.util.Arrays.stream

const val ROLE_ADMIN = "hasRole('ADMIN') "
const val ROLE_REVIEWER = "hasRole('REVIEWER') "
const val ROLE_USER = "hasRole('USER') "

enum class Role(val authorityName: String) {
    ADMIN("ROLE_ADMIN"),
    REVIEWER("ROLE_REVIEWER"),
    USER("ROLE_USER");

    companion object {
        fun create(grantedAuthority: String): Role {
            return stream(values())
                    .filter { it.authorityName.equals(grantedAuthority, true) }
                    .findFirst()
                    .orElse(null)
        }
    }
}