package ru.sber.spyfallBot.component.command

import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender
import ru.sber.spyfallBot.command.CommandList
import ru.sber.spyfallBot.command.AbstractCommand
import ru.sber.spyfallBot.command.MessageList
import ru.sber.spyfallBot.entity.Player
import ru.sber.spyfallBot.logic.*

@Component
class StartCommand: AbstractCommand(CommandList.START) {
    override fun execute(absSender: AbsSender, user: User, chat: Chat, arguments: Array<out String>) {
        val outText: String
        if (!playerRepository.findByTelegramId(chat.id).isPresent) {
            outText = formatMessage(MessageList.START.text,
                arrayOf(user.firstName, user.lastName)
            )

            playerRepository.save(
                Player(telegramId = user.id)
            )
        } else {
            outText = MessageList.START_ALREADY_AVAILABLE.text
        }

        sendEvent(chat.id, arrayOf(outText))
    }
}