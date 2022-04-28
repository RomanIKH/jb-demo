package com.jetbrains.demo.dto

import java.util.Arrays.stream

const val ROLE_ADMIN = "ROLE_ADMIN"
const val ROLE_REVIEWER = "ROLE_REVIEWER"
const val ROLE_USER = "ROLE_USER"

enum class Role(val authorityName: String) {
    ADMIN(ROLE_ADMIN),
    REVIEWER(ROLE_REVIEWER),
    USER(ROLE_USER);

    companion object {
        fun create(grantedAuthority: String): Role {
            return stream(values())
                    .filter { it.authorityName.equals(grantedAuthority, true) }
                    .findFirst()
                    .orElse(null)
        }
    }
}