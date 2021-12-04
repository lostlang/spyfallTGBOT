package ru.sber.spyfallBot.services

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.api.objects.CallbackQuery
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update
import ru.sber.spyfallBot.event.CommandEvent
import ru.sber.spyfallBot.logic.textToCommand
import ru.sber.spyfallBot.logic.useCommandClass


@Service
class RedirectService(
    private val applicationEventPublisher: ApplicationEventPublisher,
) {
    fun execute(update: Update){
        if (update.hasCallbackQuery()) {
            callbackExecute(update.callbackQuery)
        }
        if (update.hasMessage()) {
            messageExecute(update.message)
        }
    }

    private fun callbackExecute(callbackQuery: CallbackQuery) {
        val command = textToCommand(callbackQuery.data) ?: return
        val commandArguments = callbackQuery.data.split(" ")
        println(commandArguments.subList(1, commandArguments.size))

        val commandEvent = CommandEvent(
            callbackQuery.from.id,
            command,
            useCommandClass(command, commandArguments.subList(1, commandArguments.size))
        )

        applicationEventPublisher.publishEvent(
            commandEvent
        )
    }

    private fun messageExecute(message: Message) {
        println(message)
    }
}
