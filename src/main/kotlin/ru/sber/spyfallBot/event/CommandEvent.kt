package ru.sber.spyfallBot.event

import ru.sber.spyfallBot.command.CommandInfo

// Не знаю заче оно надо, но вроде недо

data class CommandEvent (
    val chatId: Long,
    val command: CommandInfo,
    val arguments: List<out String>
)
