package ru.sber.spyfallBot.component

import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import javax.annotation.PostConstruct

@Component
class Bot (
    private val botProperties: BotProperties,
    private val botCommands: List<IBotCommand>
): TelegramLongPollingBot() {

    override fun getBotUsername() = botProperties.username

    override fun getBotToken() = botProperties.token

    override fun onUpdateReceived(update: Update) {
        try {
            execute(
                SendMessage
                .builder()
                .chatId(update.message.chatId.toString())
                .text("${update.message.chatId}, ${botUsername}: ${update.message.text}")
                .build()
            )
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }

    @PostConstruct
    fun initCommands() {

    }
}