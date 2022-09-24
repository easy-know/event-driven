package com.paul.edd.history.service

import com.paul.edd.history.domain.History
import com.paul.edd.history.repository.HistoryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
@Transactional(readOnly = true)
class HistoryService(
    private val historyRepository: HistoryRepository
) {
    @Transactional
    fun saveHistory(memberId: Long) = historyRepository.save(History(memberId, LocalDateTime.now()))
}