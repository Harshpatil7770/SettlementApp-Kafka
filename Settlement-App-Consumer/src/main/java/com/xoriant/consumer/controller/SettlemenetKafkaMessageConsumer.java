package com.xoriant.consumer.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

import com.xoriant.consumer.constant.KafkaConstant;
import com.xoriant.consumer.dto.CurrencyDetail;
import com.xoriant.consumer.dto.CurrencyDetailDTO;

@Controller
public class SettlemenetKafkaMessageConsumer {

	@KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
	public void listner(String msg) {
		System.out.println(msg + KafkaConstant.MESSAGE_LISTNER);
	}

	@KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
	public void jsonDataListner(CurrencyDetail currencyDetail) {
		System.out.println(currencyDetail + KafkaConstant.MESSAGE_LISTNER);
	}
}
