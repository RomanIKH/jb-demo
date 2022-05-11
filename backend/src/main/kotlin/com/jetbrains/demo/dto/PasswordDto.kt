package com.jetbrains.demo.dto

import javax.validation.constraints.NotNull


data class PasswordDto(@NotNull val oldPassword: String,
                       @NotNull val newPassword: String)
