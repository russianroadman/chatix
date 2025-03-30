package com.russianroadman.chatix_core.model

import jakarta.persistence.Column
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@MappedSuperclass
abstract class BaseEntity {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    var id: UUID? = null

    @CreatedDate
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()

    @CreatedBy
    @Column(name = "CREATED_BY", nullable = false, updatable = false, length = 20)
    var createdBy: String? = null

    @LastModifiedDate
    @Column(name = "UPDATED_AT", nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedBy
    @Column(name = "UPDATED_BY", nullable = false, length = 20)
    var updatedBy: String? = null

    @Column(name = "DELETED_AT")
    var deletedAT: LocalDateTime? = null

    @Column(name = "DELETED_BY", length = 20)
    var deletedBy: String? = null

}