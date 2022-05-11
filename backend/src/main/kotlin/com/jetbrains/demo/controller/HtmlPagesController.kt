package com.jetbrains.demo.controller

import com.jetbrains.demo.dto.UserPrincipalDto
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlPagesController {

    @GetMapping("/")
    fun indexPage(auth: Authentication, model: Model): String {
        val userDto = getUserDtoFromAuthentication(auth)
        model.addAttribute("auth", userDto)
        return "index"
    }

    @GetMapping("/login")
    fun loginUser(): String = "login"

    @GetMapping("/add_user")
    fun createUser(): String = "add_user"

    @GetMapping("/update_password")
    fun updatePassword(): String = "update_password"

    private fun getUserDtoFromAuthentication(auth: Authentication): UserPrincipalDto {
        val user = auth.principal as User
        return UserPrincipalDto.createFromPrincipal(user)
    }
}