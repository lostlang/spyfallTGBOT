package ru.sber.spyfallBot.entity

import javax.persistence.*

@Entity
@Table(name = "players")
data class Player (
    @Id
    val id: Long? = null,

    @Column(name = "telegram_id")
    val telegramIg: Long? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    var playerAlias: Alias? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    var playerGame: Game? = null
)