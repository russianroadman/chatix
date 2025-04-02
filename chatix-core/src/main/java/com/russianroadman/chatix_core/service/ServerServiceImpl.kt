package com.russianroadman.chatix_core.service

import com.russianroadman.chatix_core.model.Server
import com.russianroadman.chatix_core.security.SecurityUtils
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Service

@Service
class ServerServiceImpl(
    private val em: EntityManager,
    private val userService: UserService
) : ServerService {

    override fun findByCurrentUser(): List<Server> {
        val userId = userService.findCurrentUser().id
        return em.createQuery(
            """
                select s
                from Server s
                join s.userContextList cl
                where cl.user.id = :userId
            """.trimIndent(),
            Server::class.java
        )
            .setParameter("userId", userId)
            .resultList
    }

}