package com.russianroadman.chatix_core.controller

import com.russianroadman.chatix_core.dto.UserServerDTO
import com.russianroadman.chatix_core.service.ServerService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/server")
class ServerController(
    private val serverService: ServerService
) {

    fun getAvaiableServers(): List<UserServerDTO> {
        return serverService.findByCurrentUser().map {
            UserServerDTO(it.id, it.title!!)
        }
    }

}