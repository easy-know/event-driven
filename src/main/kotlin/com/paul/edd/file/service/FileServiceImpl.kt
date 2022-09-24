package com.paul.edd.file.service

import org.springframework.stereotype.Service

@Service
class FileServiceImpl : FileService {
    override fun upload(file: String): String {
        println("FileServiceImpl - upload(): " + Thread.currentThread().id)
        return file + "_result"
    }

    override fun delete(key: String) {
        println("FileServiceImpl - delete(): " + Thread.currentThread().id)
    }
}