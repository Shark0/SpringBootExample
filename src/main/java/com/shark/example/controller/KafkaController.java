//package com.shark.example.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.kafka.annotation.EnableKafkaStreams;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.*;
//
//@RequiredArgsConstructor
//@RequestMapping(value = "/kafka")
//@RestController
//public class KafkaController {
//
//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    @PostMapping("/producer")
//    public String producer(@RequestBody String message){
//        kafkaTemplate.sendDefault(message);
//        return message;
//    }
//
//    @KafkaListener(topics = "${kafka.topic.streams}")
//    public void listen(String messageLength) {
//        System.out.println("message length: " + messageLength);
//    }
//}
