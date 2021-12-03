package ru.sber.spyfallBot.services

import org.springframework.stereotype.Service
import ru.sber.spyfallBot.entity.Player
import ru.sber.spyfallBot.repository.PlayerRepository

@Service
class PlayerService(
    private val playerRepository: PlayerRepository
) {

    fun existPlayerById(id: Long) = playerRepository.existsById(id)

    fun findPlayerById(id: Long) = playerRepository.findById(id)

    fun saveNewPlayer(id: Long, name: String) = playerRepository
        .save(Player(id = id, name = name))

    fun updatePlayer(player: Player) = playerRepository.save(player)

}