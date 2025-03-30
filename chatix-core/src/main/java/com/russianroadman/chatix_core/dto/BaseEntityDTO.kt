package com.russianroadman.chatix_core.dto

import java.time.LocalDateTime
import java.util.*

abstract class BaseEntityDTO(
    val id: UUID,
    val createdAt: LocalDateTime,
    val createdBy: String?,
    val updatedAt: LocalDateTime,
    val updatedBy: String?,
    val deletedAT: LocalDateTime?,
    val deletedBy: String?
)
