package ru.sber.spyfallBot.entity

import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "games")
data class Game (
    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column
    val timeStart: LocalDateTime = LocalDateTime.now(),

    @Column
    val timeForPlay: Long? = null,

    @Column
    var timePreviousStep: LocalDateTime = LocalDateTime.now(),

    @OneToOne
    val spy: Player? = null,

    @OneToOne
    var currentLocation: Location? = null,

    @OneToMany(fetch = FetchType.EAGER)
    val players: MutableList<Player> = mutableListOf(),

    @ManyToMany(fetch = FetchType.EAGER)
    val locationPool: MutableList<Location> = mutableListOf()
) {
    fun nextStep() {
        timePreviousStep = LocalDateTime.now()
    }
}
