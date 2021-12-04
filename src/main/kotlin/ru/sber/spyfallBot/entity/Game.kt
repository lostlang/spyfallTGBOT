package ru.sber.spyfallBot.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "games")
data class Game (
    @Id
    val id: Long? = null,

    val timeStart: LocalDateTime = LocalDateTime.now(),

    val timeForPlay: Long? = null,

    var timePreviousStep: LocalDateTime = LocalDateTime.now(),

    @OneToOne
    val spy: Player? = null,

    @OneToMany(fetch = FetchType.EAGER)
    val players: MutableList<Player> = mutableListOf(),

    @OneToOne
    var location: Location? = null,

    @OneToMany(fetch = FetchType.EAGER)
    val locationPool: MutableList<Location> = mutableListOf()
) {
    fun nextStep() {
        timePreviousStep = LocalDateTime.now()
    }
}