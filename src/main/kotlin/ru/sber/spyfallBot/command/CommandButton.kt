package ru.sber.spyfallBot.command

import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

enum class CommandButton(val buttons: MutableList<MutableList<InlineKeyboardButton>>) {
    START (
        mutableListOf(
            mutableListOf(
                InlineKeyboardButton()
                    .also { it.text = "Как играть" }
                    .also { it.callbackData = "/help" }
            )
        )
    ),
}