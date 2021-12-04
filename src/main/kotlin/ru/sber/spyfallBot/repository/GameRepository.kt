package ru.sber.spyfallBot.repository

import ru.sber.spyfallBot.entity.Game
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface GameRepository : JpaRepository<Game, Long> {
    /*
    fun getListActiveGames() {

    }

     */
}
