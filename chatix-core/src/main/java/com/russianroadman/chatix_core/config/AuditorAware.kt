package com.russianroadman.chatix_core.config

import com.russianroadman.chatix_core.security.SecurityUtils
import org.springframework.data.domain.AuditorAware
import org.springframework.stereotype.Component
import java.util.*

@Component
class AuditorAware : AuditorAware<String> {
    override fun getCurrentAuditor(): Optional<String> {
        return Optional.ofNullable(SecurityUtils.username())
    }
}
