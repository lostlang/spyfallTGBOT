package ru.sber.spyfallBot.logic

import org.telegram.telegrambots.meta.api.methods.send.SendMessage

fun simpleTextMessage(chatId: Long, text: Array<out String>): MutableList<SendMessage> {
    val messages: MutableList<SendMessage> = mutableListOf()
    text.forEach { message ->
        messages.add(
            SendMessage.builder()
                .chatId(chatId.toString())
                .text(message)
                .build()
        )
    }

    return messages
}
