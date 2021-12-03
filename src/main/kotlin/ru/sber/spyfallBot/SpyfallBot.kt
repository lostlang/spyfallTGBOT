package ru.sber.spyfallBot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SpyfallBot

fun main(args: Array<String>) {
    runApplication<SpyfallBot>(*args)
}