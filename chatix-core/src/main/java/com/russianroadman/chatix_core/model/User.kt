package com.russianroadman.chatix_core.model

import jakarta.persistence.*

@Table(name = "cx_user")
@Entity(name = "User")
class User: BaseEntity() {

    @Column(name = "username", nullable = false)
    var username: String? = null

    @Column(name = "login", nullable = false)
    var login: String? = null

    @Column(name = "password_hash", nullable = false)
    var passwordHash: String? = null

}