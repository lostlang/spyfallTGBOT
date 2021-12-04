package ru.sber.spyfallBot.component

import org.springframework.stereotype.Component
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import ru.sber.spyfallBot.command.MessageList
import ru.sber.spyfallBot.logic.*
import javax.annotation.PostConstruct

@Component
class Bot (
    private val botProperties: BotProperties,
    private val botCommands: List<IBotCommand>
): TelegramLongPollingCommandBot() {

    override fun getBotUsername() = botProperties.username

    override fun getBotToken() = botProperties.token

    override fun processNonCommandUpdate(update: Update?) {

    }

    @PostConstruct
    fun initCommands() {
        botCommands.forEach {
            register(it)
        }

        registerDefaultAction { absSender, message ->
            simpleTextMessage(message.chatId,
                arrayOf(formatMessage(MessageList.UNDEFINE.text, arrayOf(message.text)))
            ).forEach {
                absSender.execute(
                    it
                )
            }
        }
    }
}