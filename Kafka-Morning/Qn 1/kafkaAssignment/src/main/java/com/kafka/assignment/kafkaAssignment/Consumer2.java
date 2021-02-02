package com.kafka.assignment.kafkaAssignment;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class Consumer2 {
	 @KafkaListener(topics = "AfterPass",groupId = "group_id")
	    public void consumeMessage(String message){
		 System.out.println(message);
	 
	 }

}
