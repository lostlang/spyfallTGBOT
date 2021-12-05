package ru.sber.spyfallBot.component.command

import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender
import ru.sber.spyfallBot.command.AbstractCommand
import ru.sber.spyfallBot.command.CommandInfo
import ru.sber.spyfallBot.command.CommandMessage


@Component
class CreateCommand: AbstractCommand(CommandInfo.CREATE) {
    override fun getMessage(args: List<String>): String {
        println(args)

        return CommandMessage.CREATE.text
    }

    override fun execute(absSender: AbsSender, user: User, chat: Chat, arguments: Array<out String>) {
        if (arguments.isEmpty()){
            sendEvent(chat.id, listOf(
                getMessage( arguments.toList() )
            ))
        } else {
            getMessage( listOf() )
        }

    }

}