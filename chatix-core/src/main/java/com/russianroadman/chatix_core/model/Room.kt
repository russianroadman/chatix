package com.russianroadman.chatix_core.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Table(name = "cx_room")
@Entity(name = "Room")
class Room: BaseEntity() {

    @Column(name = "title", nullable = false)
    var title: String? = null

    @Column(name = "code", nullable = false)
    var code: String? = null

}