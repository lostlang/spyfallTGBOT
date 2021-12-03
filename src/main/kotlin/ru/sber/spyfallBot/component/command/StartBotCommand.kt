package ru.sber.spyfallBot.component.command

import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender
import ru.sber.spyfallBot.comand.AbstractCommand
import ru.sber.spyfallBot.comand.CommandList

@Component
class StartBotCommand: AbstractCommand(CommandList.START) {
    fun execute(absSender: AbsSender, user: User, chat: Chat, arguments: Array<out String>) {
        val userFullName = "${user.firstName} ${user.lastName}"
        sendEvent(chat.id, arrayOf(userFullName))
    }
}