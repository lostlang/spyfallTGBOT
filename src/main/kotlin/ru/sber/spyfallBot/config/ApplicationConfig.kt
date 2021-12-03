package ru.sber.spyfallBot.config

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ApplicationConfig {

    @Bean
    fun logger() = LoggerFactory.getLogger(javaClass)

}