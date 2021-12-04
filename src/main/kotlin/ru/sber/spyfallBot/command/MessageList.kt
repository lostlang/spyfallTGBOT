package ru.sber.spyfallBot.command

// Используйте #1 для нумерцаии данных для вставки
// И string.replace() для самой вставки

enum class MessageList (val text: String) {
    UNDEFINE("Простите, но '#1' - не известная команда для меня"),
    START("Приветсвенное сообщение"),
}