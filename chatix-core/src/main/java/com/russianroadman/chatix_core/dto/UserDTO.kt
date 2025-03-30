package com.russianroadman.chatix_core.dto

data class UserDTO(
    var username: String,
    var login: String,
    var passwordHash: String,
)
