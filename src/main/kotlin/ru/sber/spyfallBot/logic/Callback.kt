package ru.sber.spyfallBot.logic

import ru.sber.spyfallBot.command.CommandInfo
import ru.sber.spyfallBot.component.command.CreateCommand
import ru.sber.spyfallBot.component.command.HelpCommand


fun useCommandClass(chatId: Long, command: CommandInfo, arguments: List<String>): List<out String> {
    when (command) {
        CommandInfo.HELP -> return listOf(HelpCommand().getMessage())
        CommandInfo.CREATE -> {
            return listOf(CreateCommand().getMessage(chatId, arguments))
        }
        else -> return listOf()
    }
}
