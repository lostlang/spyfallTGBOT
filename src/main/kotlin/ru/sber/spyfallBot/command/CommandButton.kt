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
    HELP (
        mutableListOf(
            mutableListOf(
                InlineKeyboardButton()
                    .also { it.text = "Создать игру" }
                    .also { it.callbackData = "/create" }
            ),
            mutableListOf(
                InlineKeyboardButton()
                    .also { it.text = "Найти случайную игру" }
                    .also { it.callbackData = "/run" }
            ),
            mutableListOf(
                InlineKeyboardButton()
                    .also { it.text = "Подключится к существующей" }
                    .also { it.callbackData = "/join" }
            )
        )
    ),
    CREATE (
        mutableListOf(
            mutableListOf(
                InlineKeyboardButton()
                    .also { it.text = "5 \uD83D\uDE4D\u200D♂" }
                    .also { it.callbackData = "/create p1 5" },
                InlineKeyboardButton()
                    .also { it.text = "7 \uD83D\uDE4D\u200D♂" }
                    .also { it.callbackData = "/create p1 7" },
                InlineKeyboardButton()
                    .also { it.text = "9 \uD83D\uDE4D\u200D♂" }
                    .also { it.callbackData = "/create p1 9" }
            ),
            mutableListOf(
                InlineKeyboardButton()
                    .also { it.text = "8 \uD83C\uDFD9" }
                    .also { it.callbackData = "/create p2 8" },
                InlineKeyboardButton()
                    .also { it.text = "10 \uD83C\uDFD9" }
                    .also { it.callbackData = "/create p2 10" },
                InlineKeyboardButton()
                    .also { it.text = "12 \uD83C\uDFD9" }
                    .also { it.callbackData = "/create p2 12" },
            ),
            mutableListOf(
                InlineKeyboardButton()
                    .also { it.text = "5 ⏰" }
                    .also { it.callbackData = "/create p3 5" },
                InlineKeyboardButton()
                    .also { it.text = "10 ⏰" }
                    .also { it.callbackData = "/create p3 10" },
                InlineKeyboardButton()
                    .also { it.text = "15 ⏰" }
                    .also { it.callbackData = "/create p3 15" },
            ),
            mutableListOf(
                InlineKeyboardButton()
                    .also { it.text = "Приватная" }
                    .also { it.callbackData = "/create p4 0" },
                InlineKeyboardButton()
                    .also { it.text = "Публичная" }
                    .also { it.callbackData = "/create p4 1" },
            ),
            mutableListOf(
                InlineKeyboardButton()
                    .also { it.text = "Случайная" }
                    .also { it.callbackData = "/create r1" },
            )
        )
    )
}
