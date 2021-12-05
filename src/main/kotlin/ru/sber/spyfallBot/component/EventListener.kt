package ru.sber.spyfallBot.component

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Lazy
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import ru.sber.spyfallBot.command.CommandButton
import ru.sber.spyfallBot.command.CommandInfo
import ru.sber.spyfallBot.event.SendCommandEvent
import ru.sber.spyfallBot.logic.*


@Component
class EventListener(
    private val bot: Bot
) {
    inner class CommandEventListener {
        @EventListener
        fun onApplicationEvent(event: SendCommandEvent) {
            val sendMessages: MutableList<SendMessage> = simpleTextMessage(event.chatId, event.arguments)

            when (event.command) {
                CommandInfo.START -> addKeyboardInline(sendMessages, CommandButton.START.buttons)
                CommandInfo.HELP -> addKeyboardInline(sendMessages, CommandButton.HELP.buttons)
                CommandInfo.CREATE -> addKeyboardInline(sendMessages, CommandButton.CREATE.buttons)
                else -> {}
            }

            sendMessages.forEach { sendMessage ->
                bot.execute(sendMessage)
            }
        }
    }

    @Bean
    @Lazy
    fun commandEventListenerBean(): CommandEventListener = CommandEventListener()
}
