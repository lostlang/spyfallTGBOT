package ru.sber.spyfallBot.repository

import ru.sber.spyfallBot.entity.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository: JpaRepository<Player, Long> {
    /*
    fun searchPlayer() {

    }
     */
}