package com.paul.edd.history.repository

import com.paul.edd.history.domain.History
import org.springframework.data.jpa.repository.JpaRepository

interface HistoryRepository : JpaRepository<History, Long>