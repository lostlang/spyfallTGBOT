package ru.sber.spyfallBot.logic

import ru.sber.spyfallBot.command.CommandInfo
import ru.sber.spyfallBot.component.command.HelpCommand


fun useCommandClass(command: CommandInfo, arguments: List<String>): List<out String> {
    when (command) {
        CommandInfo.HELP -> return listOf(HelpCommand().getMessage( arguments ))
        else -> return listOf()
    }
}