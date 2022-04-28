package com.jetbrains.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class LoginController {

    @GetMapping("/login")
    fun loginUser(): String = "login"
}