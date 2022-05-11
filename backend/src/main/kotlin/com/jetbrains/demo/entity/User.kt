package com.jetbrains.demo.entity

import com.jetbrains.demo.dto.Role
import javax.persistence.*


@Entity
@Table(name = "user",
        uniqueConstraints = [
            UniqueConstraint(columnNames = ["username"])
        ])
open class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    open var id: Long? = null

    @Column(name = "username", nullable = false)
    open var username: String? = null

    @Column(name = "password", nullable = false)
    open var password: String? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    open var role: Role = Role.USER
}