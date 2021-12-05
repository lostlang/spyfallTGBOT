package ru.sber.spyfallBot.entity

import javax.persistence.*


@Entity
@Table(name = "locations")
data class Location (
    @Id
    @GeneratedValue
    val id: Long? = null,

    val name: String? = null,

    @ManyToMany(fetch = FetchType.EAGER)
    val game: MutableList<Game> = mutableListOf()
)
