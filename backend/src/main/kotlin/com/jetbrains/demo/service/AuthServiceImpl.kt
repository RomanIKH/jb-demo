package com.jetbrains.demo.service

import com.jetbrains.demo.dto.LoginDto
import com.jetbrains.demo.dto.UserDto
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl : AuthService {
    override fun loginUser(userDto: UserDto): LoginDto {
        return LoginDto()
    }

    override fun logout() {
        TODO("Not yet implemented")
    }
}