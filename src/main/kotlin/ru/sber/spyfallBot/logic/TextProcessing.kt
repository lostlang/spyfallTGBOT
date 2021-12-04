package ru.sber.spyfallBot.logic

import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton
import ru.sber.spyfallBot.command.CommandInfo


fun simpleTextMessage(chatId: Long, text: List<out String>): MutableList<SendMessage> {
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

fun addKeyboardInline(sendMessages: MutableList<SendMessage>, keyboardButtons: MutableList<MutableList<InlineKeyboardButton>>){
    sendMessages.forEach{ sendMessage ->
        sendMessage.replyMarkup = InlineKeyboardMarkup(keyboardButtons)
    }
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

fun textToCommand(text: String): CommandInfo? {

    val words = text.split(" ")
    if (words.isEmpty()){
        return null
    }

    val commandWord = words[0].substring(1)

    CommandInfo.values().forEach {
        if (commandWord == it.command) return it
    }

    return null
}
