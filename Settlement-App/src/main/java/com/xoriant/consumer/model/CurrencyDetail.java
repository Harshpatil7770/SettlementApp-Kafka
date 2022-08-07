package com.xoriant.consumer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
