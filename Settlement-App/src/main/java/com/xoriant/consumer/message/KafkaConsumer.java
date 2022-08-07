package com.xoriant.consumer.message;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

import com.xoriant.consumer.constant.KafkaConstant;
import com.xoriant.consumer.model.CurrencyDetail;

@Controller
public class KafkaConsumer {

	@KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
	public void listner(String msg) {
		System.out.println(KafkaConstant.MESSAGE_LISTNER + msg);
	}

	@KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
	public void listnerJson(CurrencyDetail currencyDetail) {
		System.out.println(KafkaConstant.MESSAGE_LISTNER + currencyDetail);
	}
}
