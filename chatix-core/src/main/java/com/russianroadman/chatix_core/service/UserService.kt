package com.russianroadman.chatix_core.service

import com.russianroadman.chatix_core.model.User

interface UserService {

    fun findByLogin(login: String): User

    fun findCurrentUser(): User

}