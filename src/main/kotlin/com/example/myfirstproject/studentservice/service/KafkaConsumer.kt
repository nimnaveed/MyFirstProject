package com.example.myfirstproject.studentservice.service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer {

    @KafkaListener(topics = ["my-topic"], groupId = "my-group")
    fun consume(message: String) {
        println("Received message: $message")
    }
}
