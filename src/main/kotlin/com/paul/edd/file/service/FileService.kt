package com.paul.edd.file.service

interface FileService {
    fun upload(file: String): String
    fun delete(key: String)
}