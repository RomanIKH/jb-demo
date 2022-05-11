package com.jetbrains.demo.service

import com.jetbrains.demo.dto.PasswordDto
import com.jetbrains.demo.dto.Role
import com.jetbrains.demo.dto.UserDto
import com.jetbrains.demo.entity.User
import com.jetbrains.demo.repository.UserRepository
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository,
                      private val passwordEncoder: PasswordEncoder) : UserService {

    override fun addUser(userDto: UserDto) {
        val user = createEntityWithEncodedPassword(userDto)
        userRepository.save(user)
    }

    override fun updateUserPassword(username: String, passwordDto: PasswordDto): UserDto {
        val user = userRepository.findByUsername(username)
                ?: throw UsernameNotFoundException("user '$username' not found")
        assertPasswordCorrect(passwordDto.oldPassword, user.password!!)

        user.password = passwordEncoder.encode(passwordDto.newPassword)
        val savedUser = userRepository.save(user)
        return convertToDto(savedUser)
    }

    private fun createEntityWithEncodedPassword(user: UserDto): User {
        val userEntity = User()
        userEntity.id = user.id
        userEntity.username = user.username
        userEntity.password = passwordEncoder.encode(user.password)
        userEntity.role = user.role ?: Role.USER
        return userEntity
    }

    private fun assertPasswordCorrect(password: String, encodedPassword: String) {
        if (!passwordEncoder.matches(password, encodedPassword)) {
            throw IllegalStateException("wrong password")
        }
    }

    private fun convertToDto(user: User): UserDto {
        return UserDto(user.id!!, user.username!!, user.password!!, user.role)
    }
}