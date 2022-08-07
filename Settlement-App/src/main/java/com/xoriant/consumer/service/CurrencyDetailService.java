package com.xoriant.consumer.service;

import com.xoriant.consumer.dto.CurrencyDetailDTO;
import com.xoriant.consumer.model.CurrencyDetail;

public interface CurrencyDetailService {

	CurrencyDetail settleNewCurrencyDetails(CurrencyDetailDTO currencyDetailDTO, String agreeOrDisagree);
}
