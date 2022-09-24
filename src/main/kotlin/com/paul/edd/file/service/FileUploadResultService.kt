package com.paul.edd.file.service

import com.paul.edd.file.event.FileUploadEvent
import com.paul.edd.file.service.FileService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class FileUploadResultService(
    private val fileService: FileService
) {
    private var saveAttemptCount = 1

    @Async
    @EventListener
    fun saveFileUploadResult(event: FileUploadEvent) {
        Thread.sleep(2000L)
        try {
            println("FileUploadResultService - saveFileUploadResult(): " + Thread.currentThread().id)
            if (saveAttemptCount == 1) {
                throw Exception("강제 예외 처리")
            }
            println("파일 업로드 결과 저장 - " + event.fileUrl + ", " + event.email)
        } catch (ex: java.lang.Exception) {
            println("=======> [Error] FileUploadResultService - saveFileUploadResult(): " + ex.message)
            if (saveAttemptCount < 2) {
                ++saveAttemptCount
                saveFileUploadResult(event)
            } else {
                fileService.delete(event.fileUrl)
            }
        } finally {
            if (saveAttemptCount != 1) {
                saveAttemptCount = 1
            }
        }
    }
}