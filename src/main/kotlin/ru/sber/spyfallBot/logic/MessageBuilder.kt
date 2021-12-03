package ru.sber.spyfallBot.logic

import org.telegram.telegrambots.meta.api.methods.send.SendMessage

class MessageBuilder (
) {
    fun simpleTextMessage(chatId: Long, text: String): SendMessage {
        return  SendMessage.builder()
                .chatId(chatId.toString())
                .text(text)
                .build()
    }
}
