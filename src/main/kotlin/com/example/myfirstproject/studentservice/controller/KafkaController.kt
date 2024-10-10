package com.example.myfirstproject.studentservice.controller

import com.example.myfirstproject.studentservice.service.KafkaProducer
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class KafkaController(private val kafkaProducer: KafkaProducer) {

    @PostMapping("/send-message")
    fun sendMessage(@RequestParam topic: String, @RequestParam message: String): String {
        kafkaProducer.sendMessage(topic, message)
        return "Message sent to topic $topic"
    }
}
