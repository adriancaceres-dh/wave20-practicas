package com.mercadolibre.bootcamp_demo_java_app.api.services;

import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyEnum;
import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemDTO;
import com.mercadolibre.bootcamp_demo_java_app.dtos.RatioDTO;
import com.mercadolibre.bootcamp_demo_java_app.services.ItemsService;
import com.mercadolibre.restclient.Response;
import com.mercadolibre.restclient.RestClient;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class CurrencyApiService extends RestClientService {
    @Value("${meli.base.url}")
    private String baseUrl;
    private static final Logger log = LoggerFactory.getLogger(CurrencyApiService.class);

    private String currencyApiBaseUrl;

    private RestClient currencyApiClient;

    public CurrencyApiService() throws IOException {
        super();
    }

    @PostConstruct
    public void init() throws IOException {
        currencyApiBaseUrl = String.format("%s/currency_conversions/search?",baseUrl);
        currencyApiClient = RestClient.builder()
                .withPool(restPool)
                .build();
    }

    public RatioDTO getCurrencyConversion(CurrencyEnum currencyBase, CurrencyEnum currencyQuote) throws ParseException, RestException {
        String currencyConversionUrl = String.format("%sfrom=%s&to=%s",currencyApiBaseUrl, currencyBase.toString(), currencyQuote.toString());
        if (log.isDebugEnabled()) {
            log.debug(currencyConversionUrl);
        }
        Response resp = currencyApiClient.get(currencyConversionUrl);
        return resp.getData(RatioDTO.class);
    }
}
