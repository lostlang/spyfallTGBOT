package ru.sber.spyfallBot.commands

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand
import ru.sber.spyfallBot.enums.Command
import ru.sber.spyfallBot.event.CommandEvent

abstract class AbstractCommand(
    private val command: Command,
): BotCommand(command.command, command.description)  {

    @Autowired
    lateinit var applicationEventPublisher: ApplicationEventPublisher

    fun sendEvent(chatId: Long, arguments: Array<out String>){
        applicationEventPublisher.publishEvent(
            CommandEvent(chatId, command, arguments)
        )
    }
}