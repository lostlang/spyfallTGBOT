package ru.sber.spyfallBot.entity

import javax.persistence.*


@Entity
@Table(name = "players")
data class Player (
    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column
    val telegramId: Long? = null,

    @ManyToOne(fetch = FetchType.EAGER )
    var playerAlias: Alias? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    var playerGame: Game? = null
)
