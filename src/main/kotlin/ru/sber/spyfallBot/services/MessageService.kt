package ru.sber.spyfallBot.services

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import ru.sber.spyfallBot.bot.Bot

@Service
class MessageService (
    private val bot: Bot,
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    fun sendMessageToBot(chatId: Long, text: String) {
        bot.execute(simpleTextMessage(chatId, text))
    }

    private fun simpleTextMessage(chatId: Long, text: String): SendMessage {
        val sendMessage = SendMessage()
        sendMessage.chatId = chatId.toString()
        sendMessage.text = text
        return sendMessage
    }
}
