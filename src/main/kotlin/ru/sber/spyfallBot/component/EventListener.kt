package ru.sber.spyfallBot.component

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Lazy
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.sber.spyfallBot.event.CommandEvent
import ru.sber.spyfallBot.logic.*

@Component
class EventListener(
    private val bot: Bot
) {
    inner class CommandEventListener {
        @EventListener
        fun onApplicationEvent(event: CommandEvent) {
            val sendMessages: MutableList<SendMessage> = simpleTextMessage(event.chatId, event.arguments)

            sendMessages.forEach { sendMessage ->
                var markup = InlineKeyboardMarkup()
                var buttons: MutableList<MutableList<InlineKeyboardButton>> = mutableListOf()

                buttons.add(mutableListOf(
                    InlineKeyboardButton()
                        .also { it.text = "тест дата" }
                        .also { it.callbackData = it.text },
                    InlineKeyboardButton()
                        .also { it.text = "тест дата 2" }
                        .also { it.callbackData = it.text })
                )
                buttons.add(mutableListOf(InlineKeyboardButton()
                    .also { it.text = "тест дата 3" }
                    .also { it.callbackData = it.text }))

                markup.keyboard = buttons
                sendMessage.replyMarkup = markup
                bot.execute(sendMessage)
            }
        }
    }

    @Bean
    @Lazy
    fun commandEventListenerBean(): CommandEventListener = CommandEventListener()
}