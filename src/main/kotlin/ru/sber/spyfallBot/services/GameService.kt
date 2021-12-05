package ru.sber.spyfallBot.services

import org.springframework.stereotype.Service
import ru.sber.spyfallBot.entity.Game
import ru.sber.spyfallBot.entity.Player
import ru.sber.spyfallBot.repository.AliasRepository
import ru.sber.spyfallBot.repository.GameRepository
import ru.sber.spyfallBot.repository.LocationRepository
import ru.sber.spyfallBot.repository.PlayerRepository

@Service
class GameService (
    private val gameRepository: GameRepository,
    private val locationRepository: LocationRepository,
    private val aliasRepository: AliasRepository,
    private val playerRepository: PlayerRepository
) {

    fun createGame(player: Player) {
        val newGame = Game()
        newGame.players.add(player)

        gameRepository.save(
            newGame
        )

        println(player)
    }
}