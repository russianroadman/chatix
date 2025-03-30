package com.russianroadman.chatix_core.controller

import com.russianroadman.chatix_core.service.AppQueryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("api/v1/test")
class TestController(
    private val queryService: AppQueryService
) {

    data class DbTestResultWrapper(
        val id: UUID,
        val testColumn: String
    )

    @GetMapping("/")
    fun test(): String {
        return "test"
    }

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello World"
    }

    @GetMapping("/db-test")
    fun dbTest(): List<Any> {
        return queryService.executeResultList(
            "select id, test_column from test",
            DbTestResultWrapper::class.java,
            emptyMap()
        )
    }

}