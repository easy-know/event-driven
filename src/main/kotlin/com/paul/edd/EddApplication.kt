package com.paul.edd

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class EddApplication

fun main(args: Array<String>) {
	runApplication<EddApplication>(*args)
}
