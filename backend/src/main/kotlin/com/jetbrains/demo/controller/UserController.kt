package com.jetbrains.demo.controller

import com.jetbrains.demo.dto.PasswordDto
import com.jetbrains.demo.dto.UserDto
import com.jetbrains.demo.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody @Valid user: UserDto) = userService.addUser(user)

    @PatchMapping
    fun updateUser(auth: Authentication, @RequestBody @Valid passwordDto: PasswordDto): UserDto {
        val user = auth.principal as User
        return userService.updateUserPassword(user.username, passwordDto)
    }
}