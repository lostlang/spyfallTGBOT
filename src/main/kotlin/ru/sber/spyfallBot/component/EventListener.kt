package ru.sber.spyfallBot.component

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Lazy
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import ru.sber.spyfallBot.command.CommandList
import ru.sber.spyfallBot.event.CommandEvent
import ru.sber.spyfallBot.logic.MessageBuilder

@Component
class EventListener(
    private val bot: Bot,
    private val messageBuilder: MessageBuilder
) {
    inner class CommandEventListener {
        @EventListener
        fun onApplicationEvent(event: CommandEvent) {
            var sendMessage: SendMessage? = null

            when (event.command) {
                CommandList.START -> {
                    sendMessage = messageBuilder.simpleTextMessage(event.chatId, "run")
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

            bot.execute(sendMessage)
        }
    }

    @Bean
    @Lazy
    fun commandEventListenerBean(): CommandEventListener = CommandEventListener()
}