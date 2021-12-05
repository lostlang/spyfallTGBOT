package ru.sber.spyfallBot.command

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand
import ru.sber.spyfallBot.event.SendCommandEvent
import ru.sber.spyfallBot.repository.*


abstract class AbstractCommand (
    private val command: CommandInfo
): BotCommand(command.command, command.description) {

    @Autowired
    lateinit var applicationEventPublisher: ApplicationEventPublisher

    @Autowired
    lateinit var playerRepository: PlayerRepository

    @Autowired
    lateinit var aliasRepository: AliasRepository

    abstract fun getMessage(args: List<String>): String

    fun sendEvent(chatId: Long, arguments: List<out String>){
        applicationEventPublisher.publishEvent(
            SendCommandEvent(chatId, command, arguments)
        )
    }
}
