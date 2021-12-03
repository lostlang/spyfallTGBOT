package ru.sber.spyfallBot.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.sber.spyfallBot.entity.Alias

@Repository
interface AliasRepository: JpaRepository<Alias, Long> {
    /*
    fun Random() {

    }
     */
}