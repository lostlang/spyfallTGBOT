package ru.sber.spyfallBot.entity

import javax.persistence.*

@Entity
@Table(name = "games")
data class Location (
    @Id
    val id: Long? = null,

    val name: String? = null
)