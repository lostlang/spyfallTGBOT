package ru.sber.spyfallBot.event

import ru.sber.spyfallBot.enums.Command

class CommandEvent(
    val chatId: Long,
    val command: Command,
    val arguments: Array<out String>
)