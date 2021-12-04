package ru.sber.spyfallBot.component.command

import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender
import ru.sber.spyfallBot.command.CommandInfo
import ru.sber.spyfallBot.command.AbstractCommand
import ru.sber.spyfallBot.command.CommandMessage
import ru.sber.spyfallBot.entity.Player
import ru.sber.spyfallBot.logic.*

@Component
class StartCommand: AbstractCommand(CommandInfo.START) {

    override fun getMessage(args: List<String>): String {
        val userId = args!![0].toLong()
        val userFirstName = args[1]
        val userLastName = args[2]

        val outText: String

        if (!playerRepository.findByTelegramId(userId).isPresent) {
            outText = formatMessage(CommandMessage.START.text,
                arrayOf(userFirstName, userLastName)
            )

            playerRepository.save(
                Player(telegramId = userId)
            )
        } else {
            outText = CommandMessage.START_ALREADY_AVAILABLE.text
        }

        return outText
    }

    override fun execute(absSender: AbsSender, user: User, chat: Chat, arguments: Array<out String>) {
         sendEvent(chat.id, listOf(
             getMessage(
                 listOf(user.id.toString(),
                     user.firstName,
                     user.lastName)
             ))
         )
    }
}