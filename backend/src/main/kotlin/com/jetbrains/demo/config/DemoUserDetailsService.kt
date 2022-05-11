package com.jetbrains.demo.config

import com.jetbrains.demo.repository.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service("userDetailsService")
class DemoUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findByUsername(username!!) ?: throw UsernameNotFoundException("user '$username' not found")
        return User.builder()
                .username(user.username)
                .password(user.password)
                .roles(user.role?.name)
                .build()
    }
}