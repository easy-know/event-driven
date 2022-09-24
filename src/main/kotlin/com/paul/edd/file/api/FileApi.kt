package com.paul.edd.file.api

import com.paul.edd.file.event.FileUploadEvent
import com.paul.edd.file.service.FileService
import org.springframework.context.ApplicationEventPublisher
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("files")
class FileApi(
    private val fileService: FileService,
    private val publisher: ApplicationEventPublisher
) {
    @PostMapping
    fun uploadFile(): String {
        println("FileApi - uploadFile(): " + Thread.currentThread().id)

        // file upload
        val file = "파일 이름"
        val result = fileService.upload(file)

        // event publish
        val fileUploadEvent = FileUploadEvent(result, "abc@test.com")
        publisher.publishEvent(fileUploadEvent)
        println("after publish(): " + Thread.currentThread().id)
        return "OK"
    }
}