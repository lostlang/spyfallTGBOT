package ru.sber.spyfallBot.component.command

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender
import ru.sber.spyfallBot.command.AbstractCommand
import ru.sber.spyfallBot.command.CommandInfo
import ru.sber.spyfallBot.command.CommandMessage
import ru.sber.spyfallBot.services.GameService


@Component
class CreateCommand: AbstractCommand(CommandInfo.CREATE) {
    @Autowired
    lateinit var gameService: GameService

    fun getMessage(userId: Long, args: List<String>): String {
        println(playerRepository.findByTelegramId(userId))

        gameService.createGame(
            playerRepository.findByTelegramId(userId)!!
        )

        return CommandMessage.CREATE.text
    }

    override fun execute(absSender: AbsSender, user: User, chat: Chat, arguments: Array<out String>) {
        if (arguments.isEmpty()){
            sendEvent(chat.id, listOf(
                getMessage( user.id, arguments.toList() )
            ))
        } else {
            getMessage( user.id, listOf() )
        }
    }
}