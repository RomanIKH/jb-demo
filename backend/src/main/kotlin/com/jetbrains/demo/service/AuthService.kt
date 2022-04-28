package com.jetbrains.demo.service

import com.jetbrains.demo.dto.LoginDto
import com.jetbrains.demo.dto.UserDto

interface AuthService {

    fun loginUser(userDto: UserDto): LoginDto

    fun logout()
}