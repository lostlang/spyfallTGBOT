package ru.sber.spyfallBot.services

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.api.objects.CallbackQuery
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update
import ru.sber.spyfallBot.command.CommandInfo
import ru.sber.spyfallBot.event.SendCommandEvent
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


        when (command) {
            CommandInfo.CREATE -> {
                if (commandArguments.isNotEmpty()) {

                }
            }
            else -> {
                applicationEventPublisher.publishEvent(
                    SendCommandEvent(
                        callbackQuery.from.id,
                        command,
                        useCommandClass(command, commandArguments.subList(1, commandArguments.size))
                    )
                )
            }
        }

    }

    private fun messageExecute(message: Message) {
        println(message)
    }
}
