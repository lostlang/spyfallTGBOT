package ru.sber.spyfallBot.entity

import javax.persistence.*

@Entity
@Table(name = "games")
data class Game (
    @Id
    val id: Long? = null,

    var location: String? = null,

    @OneToOne
    val spy: Player? = null,

    @OneToMany(fetch = FetchType.EAGER)
    val players: MutableList<Player> = mutableListOf()
)