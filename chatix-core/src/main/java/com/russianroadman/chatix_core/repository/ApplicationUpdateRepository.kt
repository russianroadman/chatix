package com.russianroadman.chatix_core.repository

import com.russianroadman.chatix_core.model.ApplicationIncrementalUpdate
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ApplicationUpdateRepository: JpaRepository<ApplicationIncrementalUpdate, UUID>