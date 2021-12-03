package ru.sber.spyfallBot.commands

import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender
import ru.sber.spyfallBot.enums.Command

@Component
class BeginCommand: AbstractCommand(Command.BEGIN) {

    override fun execute(absSender: AbsSender, user: User, chat: Chat, arguments: Array<out String>) {
        sendEvent(chat.id, arguments)
    }
}