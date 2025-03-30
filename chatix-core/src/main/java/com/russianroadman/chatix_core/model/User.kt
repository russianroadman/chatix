package com.russianroadman.chatix_core.model

import jakarta.persistence.*

@Table(name = "cx_user")
@Entity(name = "User")
class User: BaseEntity() {

    @Column(name = "username")
    var username: String? = null

    @Column(name = "password_hash")
    var passwordHash: String? = null

}