package com.paul.edd.member.domain

import javax.persistence.*

@Entity
@Table(name = "member")
class Member(
    var name: String
) {
    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = 0
}