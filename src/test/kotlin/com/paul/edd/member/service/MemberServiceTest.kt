package com.paul.edd.member.service

import com.paul.edd.history.repository.HistoryRepository
import com.paul.edd.history.service.HistoryService
import com.paul.edd.member.repository.MemberRepository
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.springframework.context.ApplicationEventPublisher

@ExtendWith(MockKExtension::class)
internal class MemberServiceTest {

    @MockK
    lateinit var memberRepository: MemberRepository

    @MockK
    lateinit var historyRepository: HistoryRepository

    @MockK
    lateinit var publisher: ApplicationEventPublisher

    lateinit var memberService: MemberService

    lateinit var historyService: HistoryService

    @BeforeEach
    fun setUp() {
        memberService = MemberService(memberRepository, publisher)
        historyService = HistoryService(historyRepository)
    }

    @Test
    fun `멤버 저장 후 히스토리 저장`() {
        // given
        val name = "홍길동"

        // when
        val memberId = memberService.saveMember(name)

        // then
        verify(historyService, times(1)).saveHistory(memberId)
    }
}