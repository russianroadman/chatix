package com.russianroadman.chatix_core.repository

import com.russianroadman.chatix_core.model.Room
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface RoomRepository: JpaRepository<Room, UUID>