package com.russianroadman.chatix_core.dto

import java.time.LocalDateTime
import java.util.*

data class ServerUserContextDTO(
    val id: UUID?,
    val userId: UUID,
    val serverId: UUID,
    val terminationType: String,
    val enteredAt: LocalDateTime
)
