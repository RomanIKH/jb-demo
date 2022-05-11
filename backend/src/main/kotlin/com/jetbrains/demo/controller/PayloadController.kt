package com.jetbrains.demo.controller

import com.jetbrains.demo.dto.ROLE_ADMIN
import com.jetbrains.demo.dto.ROLE_REVIEWER
import com.jetbrains.demo.dto.ROLE_USER
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private const val RESPONSE = "OK"

@RestController
@RequestMapping("/payload")
class PayloadController {

    @GetMapping("/admin")
    @PreAuthorize(ROLE_ADMIN)
    fun adminPayload(): String = RESPONSE

    @GetMapping("/reviewer")
    @PreAuthorize(ROLE_REVIEWER)
    fun reviewerPayload(): String = RESPONSE

    @GetMapping("/user")
    @PreAuthorize(ROLE_USER)
    fun userPayload(): String = RESPONSE
}