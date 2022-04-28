package com.jetbrains.demo.controller

import com.jetbrains.demo.dto.UserDto
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {

    @GetMapping("/")
    fun indexPage(auth: Authentication, model: Model): String {
        val userDto = getUserDtoFromAuthentication(auth)
        model.addAttribute("auth", userDto)
        return "index"
    }

    private fun getUserDtoFromAuthentication(auth: Authentication): UserDto {
        val user = auth.principal as User
        return UserDto.createFromPrincipal(user)
    }
}