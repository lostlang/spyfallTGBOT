package entity

import javax.persistence.*

@Entity
@Table(name = "players")
data class Player (
    @Id
    val id: Long? = null,

    @Column(name = "telegram_id")
    val telegramIg: Long? = null,

    val playerAlias: String? = null,

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    var game: Game? = null
)