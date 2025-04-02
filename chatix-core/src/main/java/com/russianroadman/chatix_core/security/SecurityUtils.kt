package com.russianroadman.chatix_core.security

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails

object SecurityUtils {

    fun username(): String {
        return SecurityContextHolder.getContext().authentication?.name ?: "system"
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