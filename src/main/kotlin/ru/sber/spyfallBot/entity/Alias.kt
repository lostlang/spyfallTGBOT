package ru.sber.spyfallBot.entity

import javax.persistence.*

@Entity
@Table(name = "Aliases")
data class Alias (
    @Id
    val id: Long? = null,

    val name: String? = null
)