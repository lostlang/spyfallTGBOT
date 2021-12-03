package repository

import entity.Player
import org.springframework.data.jpa.repository.JpaRepository

interface PlayerRepository: JpaRepository<Player, Long>