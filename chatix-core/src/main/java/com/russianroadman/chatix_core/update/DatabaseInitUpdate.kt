package com.russianroadman.chatix_core.update

import com.russianroadman.chatix_core.annotation.AppUpdate
import com.russianroadman.chatix_core.model.Room
import com.russianroadman.chatix_core.model.Server
import com.russianroadman.chatix_core.model.ServerUserContext
import com.russianroadman.chatix_core.model.User
import com.russianroadman.chatix_core.repository.RoomRepository
import com.russianroadman.chatix_core.repository.ServerRepository
import com.russianroadman.chatix_core.repository.ServerUserContextRepository
import com.russianroadman.chatix_core.repository.UserRepository

@AppUpdate
class DatabaseInitUpdate(
    private val roomRepository: RoomRepository,
    private val serverRepository: ServerRepository,
    private val serverUserContextRepository: ServerUserContextRepository,
    private val userRepository: UserRepository
): Updatable {

    override fun run() {

        val server = Server().apply {
            title = "test server"
        }

        val room = Room().apply {
            title = "test room"
            code = "test_room"
        }

        val user1 = User().apply {
            username = "user1"
            login = "user1"
            passwordHash = "user1"
        }

        val user2 = User().apply {
            username = "user2"
            login = "user2"
            passwordHash = "user2"
        }

        val savedServer = serverRepository.save(server)
        roomRepository.save(room.apply { this.server = savedServer })

        val savedUser1 = userRepository.save(user1)
        val savedUser2 = userRepository.save(user2)

        val user1Context = ServerUserContext().apply {
            this.user = savedUser1
            this.server = savedServer
        }

        val user2Context = ServerUserContext().apply {
            this.user = savedUser2
            this.server = savedServer
        }

        serverUserContextRepository.saveAll(listOf(user1Context, user2Context))

    }

}