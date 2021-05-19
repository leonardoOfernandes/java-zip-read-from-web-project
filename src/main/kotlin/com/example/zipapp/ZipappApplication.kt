package com.example.zipapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ZipappApplication

fun main(args: Array<String>) {
	runApplication<ZipappApplication>(*args)
}
