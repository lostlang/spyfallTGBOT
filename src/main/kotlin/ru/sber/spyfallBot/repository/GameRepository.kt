package ru.sber.spyfallBot.repository

import ru.sber.spyfallBot.entity.Game
import org.springframework.data.jpa.repository.JpaRepository

interface GameRepository : JpaRepository<Game, Long>