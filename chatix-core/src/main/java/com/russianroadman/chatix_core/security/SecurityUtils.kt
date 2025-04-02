package com.russianroadman.chatix_core.security

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails

object SecurityUtils {

    fun usernameOrSystem(): String {
        return username() ?: "system"
    }

    fun username(): String? {
        return SecurityContextHolder.getContext().authentication?.name
    }

    fun principal(): String {
        return when (
            val principal = SecurityContextHolder.getContext().authentication.principal
        ) {
            is UserDetails -> principal.username
            is String -> return principal
            else -> "system"
        }
    }

}