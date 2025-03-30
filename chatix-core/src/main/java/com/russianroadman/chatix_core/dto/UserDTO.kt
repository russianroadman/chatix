package com.russianroadman.chatix_core.dto

import java.util.*

data class UserDTO(
    val id: UUID?,
    val username: String,
    val login: String,
    val passwordHash: String,
)
