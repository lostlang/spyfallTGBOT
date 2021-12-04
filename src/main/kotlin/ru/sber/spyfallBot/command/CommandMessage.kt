package ru.sber.spyfallBot.command

// Используйте #1 для нумерцаии данных для вставки
// И string.replace() для самой вставки

enum class CommandMessage (val text: String) {
    UNDEFINE("Простите, но '#1' - не известная команда для меня"),
    START("Здравствуй, #1 #2, добро пожаловать в бот для игры в Шпион, для начала озномся с правилами, " +
            "для этого ты можешь ввести /help или нажать кнопку снизу"),
    START_ALREADY_AVAILABLE("Пользователь уже зарегистрирован"),
}