package ru.sber.spyfallBot.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import ru.sber.spyfallBot.entity.Alias

@Repository
interface AliasRepository: JpaRepository<Alias, Long> {

    @Query("select * from aliases order by random() limit 1", nativeQuery=true)
    fun findRandomOne(): Alias

    @Query("select * from aliases order by random() limit :count", nativeQuery=true)
    fun findRandomByCount(@Param("count")count: Long): List<Alias>

}