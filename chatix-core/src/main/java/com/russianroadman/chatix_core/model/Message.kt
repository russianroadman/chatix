package com.russianroadman.chatix_core.model

import jakarta.persistence.*

@Table(name = "cx_message")
@Entity(name = "Message")
class Message: BaseEntity() {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    var room: Room? = null

    @Column(name = "text", nullable = false)
    var text: String? = null

    @Column(name = "is_during_call", nullable = false, updatable = false)
    var isDuringCall: Boolean = false

}