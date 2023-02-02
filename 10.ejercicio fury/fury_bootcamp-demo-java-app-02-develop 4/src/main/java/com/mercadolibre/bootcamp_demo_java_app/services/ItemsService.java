package com.mercadolibre.bootcamp_demo_java_app.services;

import com.mercadolibre.bootcamp_demo_java_app.api.services.CurrencyApiService;
import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyEnum;
import com.mercadolibre.bootcamp_demo_java_app.dtos.RatioDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.bootcamp_demo_java_app.api.services.ItemsApiService;
import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemDTO;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;

@Service
public class ItemsService {
	private static final Logger log = LoggerFactory.getLogger(ItemsService.class);
	private ItemsApiService itemsApiService;
	private CurrencyApiService currencyApiService;
	
	@Autowired
	public ItemsService(ItemsApiService itemsApiService, CurrencyApiService currencyApiService) {
		this.itemsApiService = itemsApiService;
		this.currencyApiService = currencyApiService;
	}
	
	public Double getItemPrice(String itemId) throws ParseException, RestException {
		ItemDTO itemInfo = itemsApiService.getItemInfo(itemId);
		if (log.isDebugEnabled()) {
			log.debug("Item info lookup: {}",itemInfo);
		}
		return itemInfo.getPrice();
	}

	public Double getItemPriceInUsd(String itemId) throws ParseException, RestException {
		ItemDTO itemInfo = itemsApiService.getItemInfo(itemId);
		RatioDTO conversionRatio = currencyApiService.getCurrencyConversion(itemInfo.getCurrencyId(), CurrencyEnum.USD);
		if (log.isDebugEnabled()) {
			log.debug("Conversion rate: {}",conversionRatio);
		}
		return itemInfo.getPrice() * conversionRatio.getRatio();
	}
}
