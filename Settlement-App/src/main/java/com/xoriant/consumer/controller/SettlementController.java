package com.xoriant.consumer.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.consumer.constant.KafkaConstant;
import com.xoriant.consumer.dto.CurrencyDetailDTO;
import com.xoriant.consumer.model.CurrencyDetail;
import com.xoriant.consumer.service.CurrencyDetailService;

@RestController
@RequestMapping("/api/settlement")
public class SettlementController {

	@Autowired
	private CurrencyDetailService currencyDetailService;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private KafkaTemplate<String, CurrencyDetail> kafkaTemplateForJsonData;

	@Value("${spring.kafka.topic}")
	private String topic;

	@Value("${spring.kafka.topic-json}")
	private String topicJson;

	@PostConstruct
	public void info() {
		kafkaTemplate.send(topic, "Welcome To Settlement Services !");
		System.out.println(KafkaConstant.MESSAGE_SENDER);
	}

	@PostMapping("/save/{agreeOrDisagree}")
	public CurrencyDetail settleNewCurrencyDetails(@RequestBody CurrencyDetailDTO currencyDetailDTO,
			@PathVariable String agreeOrDisagree) {
		CurrencyDetail result = currencyDetailService.settleNewCurrencyDetails(currencyDetailDTO, agreeOrDisagree);
		if (result != null) {
			kafkaTemplateForJsonData.send(topic, result);
			System.out.println(KafkaConstant.MESSAGE_SENDER);
		}
		return result;
	}
}
