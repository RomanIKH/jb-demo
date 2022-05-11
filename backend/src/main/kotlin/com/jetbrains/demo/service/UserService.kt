package com.jetbrains.demo.service

import com.jetbrains.demo.dto.PasswordDto
import com.jetbrains.demo.dto.UserDto

interface UserService {

    fun addUser(userDto: UserDto)

    fun updateUserPassword(username: String, passwordDto: PasswordDto): UserDto
}