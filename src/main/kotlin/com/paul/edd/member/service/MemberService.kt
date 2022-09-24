package com.paul.edd.member.service

import com.paul.edd.history.event.HistoryRequestEvent
import com.paul.edd.member.domain.Member
import com.paul.edd.member.repository.MemberRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberService(
    private val memberRepository: MemberRepository,
    private val publisher: ApplicationEventPublisher
) {
    @Transactional
    fun saveMember(name: String): Long {
        val member = memberRepository.save(Member(name))
        val memberId = member.id
        publisher.publishEvent(HistoryRequestEvent(memberId = memberId!!))
        return memberId
    }
}