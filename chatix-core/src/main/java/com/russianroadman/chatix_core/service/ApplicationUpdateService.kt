package com.russianroadman.chatix_core.service

import com.russianroadman.chatix_core.model.ApplicationIncrementalUpdate
import com.russianroadman.chatix_core.repository.ApplicationUpdateRepository
import com.russianroadman.chatix_core.update.Updatable
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Service

@Service
class ApplicationUpdateService(
    private val em: EntityManager,
    private val repo: ApplicationUpdateRepository
) {

    fun findAllNames(): List<String> {
        return em
            .createQuery(
                "select a from ApplicationIncrementalUpdate a",
                ApplicationIncrementalUpdate::class.java
            )
            .resultList
            .mapNotNull { it.name }
    }

    fun <T: Updatable> save(t: Class<T>) {
        repo.save(
            ApplicationIncrementalUpdate().apply {
                this.name = t.simpleName
            }
        )
    }

}