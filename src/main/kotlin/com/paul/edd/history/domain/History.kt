package com.paul.edd.history.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "history")
class History(
    val memberId: Long,
    val createdDate: LocalDateTime
) {
    @Id
    @Column(name = "HISTORY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L
}