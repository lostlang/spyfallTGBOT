package ru.sber.spyfallBot.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "games")
data class Game (
    @Id
    val id: Long? = null,

    var location: String? = null,

    val timeStart: LocalDateTime = LocalDateTime.now(),

    val timeForPlay: Long? = null,

    @OneToOne
    val spy: Player? = null,

    @OneToMany(fetch = FetchType.EAGER)
    val players: MutableList<Player> = mutableListOf()
)