package ru.sber.spyfallBot.component

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Lazy
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import ru.sber.spyfallBot.command.CommandList
import ru.sber.spyfallBot.event.CommandEvent
import ru.sber.spyfallBot.logic.*

@Component
class EventListener(
    private val bot: Bot
) {
    inner class CommandEventListener {
        @EventListener
        fun onApplicationEvent(event: CommandEvent) {
            var sendMessages: MutableList<SendMessage>? = null

            when (event.command) {
                CommandList.START -> {
                    sendMessages = simpleTextMessage(event.chatId, event.arguments)
                }
                CommandList.RUN -> {
                    println("run")
                }
                CommandList.JOIN -> {
                    println("join")
                }
                CommandList.LEAVE -> {
                    println("leave")
                }
            }

            sendMessages?.forEach { sendMessage ->
                bot.execute(sendMessage)
            }
        }
    }

    @Bean
    @Lazy
    fun commandEventListenerBean(): CommandEventListener = CommandEventListener()
}