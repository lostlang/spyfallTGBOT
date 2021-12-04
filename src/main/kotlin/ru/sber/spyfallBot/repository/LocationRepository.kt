package ru.sber.spyfallBot.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.sber.spyfallBot.entity.Location


@Repository
interface LocationRepository: JpaRepository<Location, Long> {
    /*
    fun randomPool() {

    }
     */
}
