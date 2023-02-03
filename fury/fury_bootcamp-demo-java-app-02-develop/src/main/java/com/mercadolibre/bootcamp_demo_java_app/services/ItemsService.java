package com.mercadolibre.bootcamp_demo_java_app.services;

import com.mercadolibre.bootcamp_demo_java_app.api.services.CurrencyConvertApiService;
import com.mercadolibre.bootcamp_demo_java_app.dtos.PriceInDollarDTO;
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
	private CurrencyConvertApiService convertApiService;
	
	@Autowired
	public ItemsService(ItemsApiService itemsApiService, CurrencyConvertApiService convertApiService) {
		this.itemsApiService = itemsApiService;
		this.convertApiService = convertApiService;
	}
	
	public Double getItemPrice(String itemId) throws ParseException, RestException {
		ItemDTO itemInfo = itemsApiService.getItemInfo(itemId);
		if (log.isDebugEnabled()) {
			log.debug("Item info lookup: {}",itemInfo);
		}
		return itemInfo.getPrice();
	}

	public PriceInDollarDTO getItemPriceInUSD(String itemId) throws RestException, ParseException {
		ItemDTO item = getItemInfo(itemId);
		Double ratio = convertApiService.getRatio(item.getCurrencyId());
		return new PriceInDollarDTO(itemId, ratio*item.getPrice());
	}

	public ItemDTO getItemInfo(String itemId) throws ParseException, RestException{
		return itemsApiService.getItemInfo(itemId);
	}
}
