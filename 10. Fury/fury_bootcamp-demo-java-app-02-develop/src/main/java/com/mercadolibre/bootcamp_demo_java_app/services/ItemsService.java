package com.mercadolibre.bootcamp_demo_java_app.services;

import com.mercadolibre.bootcamp_demo_java_app.dtos.ConvertionRatioDTO;
import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemPriceUsdDTO;
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
	
	@Autowired
	public ItemsService(ItemsApiService itemsApiService) {
		this.itemsApiService = itemsApiService;
	}
	
	public Double getItemPrice(String itemId) throws ParseException, RestException {
		ItemDTO itemInfo = itemsApiService.getItemInfo(itemId);
		if (log.isDebugEnabled()) {
			log.debug("Item info lookup: {}",itemInfo);
		}
		return itemInfo.getPrice();
	}

	public ItemPriceUsdDTO getItemPriceInUsd(String itemId) throws ParseException, RestException {
		ItemDTO itemInfo = itemsApiService.getItemInfo(itemId);
		ConvertionRatioDTO ratio = itemsApiService.getConvertionRatioToUsd(itemInfo.getCurrencyId());
		Double price = getItemPrice(itemId);
		return new ItemPriceUsdDTO(itemId, price * ratio.getRatio());
	}
}
