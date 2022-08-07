package com.xoriant.consumer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.consumer.model.CurrencyDetail;

public interface CurrentDetailRepo extends JpaRepository<CurrencyDetail, Long> {

}
