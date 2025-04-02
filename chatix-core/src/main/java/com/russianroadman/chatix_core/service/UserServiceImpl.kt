package com.russianroadman.chatix_core.service

import com.russianroadman.chatix_core.model.User
import com.russianroadman.chatix_core.repository.UserRepository
import com.russianroadman.chatix_core.security.SecurityUtils
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    override fun findByLogin(login: String): User {
        return userRepository.findByLogin(login)
            ?: throw IllegalArgumentException("User not found by login: $login")
    }

    override fun findCurrentUser(): User {
        return findByLogin(SecurityUtils.username()!!)
    }

}