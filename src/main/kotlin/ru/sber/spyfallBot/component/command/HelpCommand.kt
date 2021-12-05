package ru.sber.spyfallBot.component.command

import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender
import ru.sber.spyfallBot.command.AbstractCommand
import ru.sber.spyfallBot.command.CommandInfo
import ru.sber.spyfallBot.command.CommandMessage


@Component
class HelpCommand: AbstractCommand(CommandInfo.HELP) {
    fun getMessage(): String {
        return CommandMessage.HELP.text
    }

    override fun execute(absSender: AbsSender, user: User, chat: Chat, arguments: Array<out String>) {
        sendEvent(chat.id, listOf(getMessage()))
    }
}
