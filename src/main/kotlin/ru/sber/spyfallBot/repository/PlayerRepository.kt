package ru.sber.spyfallBot.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.sber.spyfallBot.entity.Player


@Repository
interface PlayerRepository: JpaRepository<Player, Long> {
    fun findByTelegramId(id: Long): Player?
}
