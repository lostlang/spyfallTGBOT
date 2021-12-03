package ru.sber.spyfallBot.repository

import ru.sber.spyfallBot.entity.Player
import org.springframework.data.jpa.repository.JpaRepository

interface PlayerRepository: JpaRepository<Player, Long>{

    override fun existsById(chatId: Long): Boolean
}