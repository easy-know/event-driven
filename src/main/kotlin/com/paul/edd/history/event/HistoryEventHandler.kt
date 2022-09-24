package com.paul.edd.history.event

import com.paul.edd.history.service.HistoryService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class HistoryEventHandler(
    private val historyService: HistoryService
) {
    @Async
    @EventListener
    fun saveHistory(historyRequestEvent: HistoryRequestEvent) {
        historyService.saveHistory(historyRequestEvent.memberId)
    }
}