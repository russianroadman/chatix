package com.russianroadman.chatix_core.service

import com.russianroadman.chatix_core.model.Server

interface ServerService {

    fun findByCurrentUser(): List<Server>

}