package com.example.zipapp.controller

import com.example.zipapp.service.ZipFileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/generate-init")
class ZipFileController @Autowired constructor(private var zipService: ZipFileService){

    @GetMapping
    fun index(): ResponseEntity<Any>{
        zipService.generatezipProject()

        return ResponseEntity.ok().build()
    }
}