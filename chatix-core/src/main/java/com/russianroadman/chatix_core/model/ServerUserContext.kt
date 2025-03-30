package com.russianroadman.chatix_core.model

import com.russianroadman.chatix_core.enum.ServerUserParticipationTermination
import jakarta.persistence.*
import java.time.LocalDateTime

@Table(
    name = "cx_server_user_context",
    indexes = [Index(
        name = "idx_server_user_context_user_id_server_id_uq",
        columnList = "user_id, server_id",
        unique = true
    )]
)
@Entity(name = "ServerUserContext")
class ServerUserContext: BaseEntity() {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "server_id")
    var server: Server? = null

    @Column(name = "termination_type", nullable = false)
    @Enumerated(EnumType.STRING)
    var terminationType: ServerUserParticipationTermination = ServerUserParticipationTermination.NONE

    @Column(name = "entered_at", nullable = false, updatable = false)
    var enteredAt: LocalDateTime? = null

}