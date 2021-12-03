package ru.sber.spyfallBot.component.command

import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender
import ru.sber.spyfallBot.command.CommandList
import ru.sber.spyfallBot.command.AbstractCommand
import ru.sber.spyfallBot.command.MessageList

@Component
class StartBotCommand: AbstractCommand(CommandList.START) {
    override fun execute(absSender: AbsSender, user: User, chat: Chat, arguments: Array<out String>) {
        val outText: String = MessageList.START.text
        sendEvent(chat.id, arrayOf(outText))
    }
}