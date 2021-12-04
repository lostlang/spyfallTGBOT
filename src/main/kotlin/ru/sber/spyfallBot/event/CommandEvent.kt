package ru.sber.spyfallBot.event

import ru.sber.spyfallBot.command.CommandInfo


data class CommandEvent (
    val chatId: Long,
    val command: CommandInfo,
    val arguments: List<out String>
)
