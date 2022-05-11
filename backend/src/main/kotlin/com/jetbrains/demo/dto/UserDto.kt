package com.jetbrains.demo.dto

import javax.validation.constraints.NotNull


data class UserDto(var id: Long?,
                   @NotNull val username: String,
                   @NotNull val password: String,
                   val role: Role?)
