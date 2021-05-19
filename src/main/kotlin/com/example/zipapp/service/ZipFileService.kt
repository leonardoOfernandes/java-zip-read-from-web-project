package com.example.zipapp.service

import org.springframework.stereotype.Service
import java.io.File
import java.net.HttpURLConnection
import java.net.URL
import java.net.http.HttpClient
import java.net.http.HttpResponse
import java.util.zip.ZipInputStream
import java.io.FileOutputStream
import java.util.zip.ZipOutputStream
import java.util.zip.ZipEntry

@Service
class ZipFileService {

    fun generatezipProject(){
        val url = URL("https://start.spring.io/starter.zip?type=maven-project&language=java&bootVersion=2.4.5.RELEASE" +
                "&baseDir=demo&groupId=com.example&artifactId=demo&name=demo&description=Demo%20project%20for%20Spring%20Boot" +
                "&packageName=com.example.demo&packaging=jar&javaVersion=11&dependencies=lombok,web")

        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET"  // optional default is GET

            println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")



            val zin = ZipInputStream(inputStream)

            val f = File("downloads/teste.zip")
            val fout = FileOutputStream(f)
            val zos = ZipOutputStream(fout)

            while (true) {
                val ze = zin.nextEntry ?: break
                println("Unzipping file: " + ze.name)
                zos.putNextEntry(ze)
                var c = zin.read()
                while (c != -1) {
                    zos.write(c)
                    c = zin.read()
                }
                zos.closeEntry()
            }
            zos.close()
            fout.close()

        }

    }



}