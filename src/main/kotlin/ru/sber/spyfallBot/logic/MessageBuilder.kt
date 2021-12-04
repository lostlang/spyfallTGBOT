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

fun formatMessage(text: String, values: Array<String>): String {
    var outText = text

    for (i in 1..values.size) {
        outText = outText.replace(
            "#$i",
            values[i - 1]
        )
    }

    return outText
}