package com.russianroadman.chatix_core.dto

import java.time.LocalDateTime
import java.util.*

data class ServerUserContextDTO(
    var userId: UUID,
    var serverId: UUID,
    var terminationType: String,
    var enteredAt: LocalDateTime
)
