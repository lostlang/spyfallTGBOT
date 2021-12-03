package ru.sber.spyfallBot.services

import org.springframework.stereotype.Service
import ru.sber.spyfallBot.entity.Game
import ru.sber.spyfallBot.entity.Player
import ru.sber.spyfallBot.repository.GameRepository

@Service
class GameService (
    private val gameRepository: GameRepository
) {

    fun createGame(player: Player) = gameRepository.save(Game(player.id, false, null, mutableListOf(player)))

    fun findGameById(id: Long) = gameRepository.findById(id)

    fun updateGame(game: Game) = gameRepository.save(game)
}