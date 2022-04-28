package com.jetbrains.demo.repository

import com.jetbrains.demo.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findByUsername(username: String): User
}