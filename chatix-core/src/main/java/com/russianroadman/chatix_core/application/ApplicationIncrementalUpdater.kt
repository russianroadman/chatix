package com.russianroadman.chatix_core.application

import com.russianroadman.chatix_core.service.ApplicationUpdateService
import com.russianroadman.chatix_core.update.Updatable
import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ApplicationIncrementalUpdater(
    private val updates: List<Updatable>,
    private val updateService: ApplicationUpdateService
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @PostConstruct
    private fun init() {
        log.info("Initializing application incremental updater")
        val executed = updateService.findAllNames()
        log.info("Found ${updates.size} updates")
        log.info("Found ${executed.size} already executed updates")
        val toBeExecuted = updates
            .associateBy { it.javaClass.simpleName }
            .filterKeys { !executed.contains(it) }
        if (toBeExecuted.isNotEmpty()) {
            log.info("Found ${toBeExecuted.size} updates to be executed")
        } else {
            log.info("Found none updates to be executed. Skipped")
        }
        toBeExecuted.forEach { (_, v) -> runUpdate(v) }
    }

    private fun runUpdate(update: Updatable) {
        log.info("RUNNING APPLICATION INCREMENTAL UPDATE: ${update.javaClass.simpleName}")
        try {
            update.run()
            updateService.save(update.javaClass)
        } catch (e: Exception) {
            log.error(e.message, e)
        }
    }

}