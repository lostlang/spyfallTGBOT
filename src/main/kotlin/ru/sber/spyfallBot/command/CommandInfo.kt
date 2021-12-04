package ru.sber.spyfallBot.command


enum class CommandInfo(val command: String, val description: String) {
    START ("start", "Начало работы с ботом"),
    RUN ("run", "Найти игру"),
    JOIN ("join", "Подключится к игре"),
    LEAVE ("leave", "Покинуть игру"),
    HELP ("help", "Как играть")
}
