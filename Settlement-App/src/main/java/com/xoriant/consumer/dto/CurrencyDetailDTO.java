package com.xoriant.consumer.dto;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.xoriant.consumer.model.SettlementStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDetailDTO {

	private long currencyConversionId;

	private String formCurrency;

	private String toCurrency;

	private double formCurrencyValue;

	private double toCurrencyValue;

	private Date date;

	private String agreeOrDisagree;

	@Enumerated(EnumType.STRING)
	private SettlementStatus settlementStatus;

	private double sellQuantity;

	private double returnAmount;
}
