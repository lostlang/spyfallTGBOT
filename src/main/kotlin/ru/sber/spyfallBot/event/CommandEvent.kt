package ru.sber.spyfallBot.event

import ru.sber.spyfallBot.command.CommandList

// Не знаю заче оно надо, но вроде недо

data class CommandEvent (
    val chatId: Long,
    val command: CommandList,
    val arguments: Array<out String>
)
