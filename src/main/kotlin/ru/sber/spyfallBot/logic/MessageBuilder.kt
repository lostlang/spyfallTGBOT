package ru.sber.spyfallBot.logic

import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.api.methods.send.SendMessage

@Service
class MessageBuilder (
) {
    fun simpleTextMessage(chatId: Long, text: String): SendMessage {
        return  SendMessage.builder()
                .chatId(chatId.toString())
                .text(text)
                .build()
    }
}
