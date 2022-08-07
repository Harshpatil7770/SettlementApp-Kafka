package com.xoriant.consumer.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.consumer.dao.CurrentDetailRepo;
import com.xoriant.consumer.dto.CurrencyDetailDTO;
import com.xoriant.consumer.model.CurrencyDetail;
import com.xoriant.consumer.model.SettlementStatus;

@Service
public class CurrencyDetailsServiceImpl implements CurrencyDetailService {

	@Autowired
	private CurrentDetailRepo currentDetailRepo;

	@Override
	public CurrencyDetail settleNewCurrencyDetails(CurrencyDetailDTO currencyDetailDTO, String agreeOrDisagree) {
		CurrencyDetail currencyDetail = new CurrencyDetail();
		currencyDetail.setCurrencyConversionId(currencyDetailDTO.getCurrencyConversionId());
		currencyDetail.setFormCurrency(currencyDetailDTO.getFormCurrency().toUpperCase());
		currencyDetail.setToCurrency(currencyDetailDTO.getToCurrency().toUpperCase());
		currencyDetail.setFormCurrencyValue(currencyDetailDTO.getFormCurrencyValue());
		currencyDetail.setToCurrencyValue(currencyDetailDTO.getToCurrencyValue());
		Date date = new Date();
		currencyDetail.setDate(date);
		currencyDetail.setAgreeOrDisagree(agreeOrDisagree);
		if (agreeOrDisagree.equals("agree")) {
			currencyDetail.setSettlementStatus(SettlementStatus.SETTLED);
		} else {
			currencyDetail.setSettlementStatus(SettlementStatus.REJECTED);
		}
		currencyDetail.setSellQuantity(currencyDetailDTO.getSellQuantity());
		double amount = currencyDetailDTO.getToCurrencyValue() * currencyDetail.getSellQuantity();
		currencyDetail.setReturnAmount(amount);
		return currentDetailRepo.save(currencyDetail);
	}
}
