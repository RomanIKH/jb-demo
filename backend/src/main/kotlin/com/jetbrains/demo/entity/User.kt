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

    @Column(name = "username")
    open var username: String? = null

    @Column(name = "password")
    open var password: String? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    open var role: Role? = null
}