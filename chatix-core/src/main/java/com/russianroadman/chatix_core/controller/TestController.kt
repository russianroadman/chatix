package com.russianroadman.chatix_core.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/test")
class TestController {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello World"
    }

}