package com.russianroadman.chatix_core.model

import jakarta.persistence.*

@Table(name = "cx_room")
@Entity(name = "Room")
class Room: BaseEntity() {

    @Column(name = "title", nullable = false)
    var title: String? = null

    @Column(name = "code", nullable = false)
    var code: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "server_id", nullable = false, updatable = false)
    var server: Server? = null

}