package ru.sber.spyfallBot.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.sber.spyfallBot.entity.Player
import java.util.*


@Repository
interface PlayerRepository: JpaRepository<Player, Long> {
    fun findByTelegramId(id: Long): Optional<Player>
}
