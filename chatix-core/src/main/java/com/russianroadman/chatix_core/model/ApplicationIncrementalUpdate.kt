package com.russianroadman.chatix_core.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Table(name = "cx_app_incremental_update")
@Entity(name = "ApplicationIncrementalUpdate")
class ApplicationIncrementalUpdate: BaseEntity() {

    @Column(name = "name", nullable = false, updatable = false)
    var name: String? = null

}