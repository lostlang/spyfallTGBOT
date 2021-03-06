package ru.sber.spyfallBot.command

enum class CommandList(val command: String, val description: String) {
    START ("start", "Начало работы с ботом"),
    RUN("run", "Найти игру"),
    JOIN("join", "Подключится к игре"),
    END("leave", "Покинуть игру")
}