package ru.sber.spyfallBot.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "games")
data class Game (
    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column(name = "time_start")
    val timeStart: LocalDateTime = LocalDateTime.now(),

    @Column(name = "time_for_play")
    val timeForPlay: Long? = null,

    @Column(name = "time_previous_step")
    var timePreviousStep: LocalDateTime = LocalDateTime.now(),

    @OneToOne
    val spy: Player? = null,

    @OneToOne
    var location: Location? = null,

    @OneToMany(fetch = FetchType.EAGER)
    val players: MutableList<Player> = mutableListOf(),

    @ManyToMany(fetch = FetchType.EAGER)
    val locationPool: MutableList<Location> = mutableListOf()
) {
    fun nextStep() {
        timePreviousStep = LocalDateTime.now()
    }
}