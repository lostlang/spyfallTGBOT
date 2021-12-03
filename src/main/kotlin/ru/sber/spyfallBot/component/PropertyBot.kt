package ru.sber.spyfallBot.component

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
data class PropertyBot (
    @Value("\${bot.name}")
    var username: String,

    @Value("\${bot.token}")
    var token: String
)