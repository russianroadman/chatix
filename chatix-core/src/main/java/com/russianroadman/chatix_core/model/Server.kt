package com.russianroadman.chatix_core.model

import jakarta.persistence.*

@Table(name = "cx_server")
@Entity(name = "Server")
class Server: BaseEntity() {

    @Column(name = "title", nullable = false)
    var title: String? = null

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "server")
    var rooms: List<Room>? = null

}