package com.mercadolibre.bootcamp_demo_java_app.api.services;

import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyEnum;
import com.mercadolibre.bootcamp_demo_java_app.dtos.RatioDTO;
import com.mercadolibre.restclient.RestClient;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.IOException;

import static java.lang.String.format;

@Service
public class CurrencyConvertApiService extends RestClientService{
    @Value("${meli.base.url}")
    private String baseUrl;

    private String currencyConvertApiBaseUrl;
    private RestClient currencyConvertApiClient;

    public CurrencyConvertApiService() throws IOException {
        super();
    }

    @PostConstruct
    public void init() throws IOException {
        currencyConvertApiBaseUrl = format("%s/currency_conversions/search",baseUrl);
        currencyConvertApiClient = RestClient.builder()
                .withPool(restPool)
                .build();
    }

    public Double getRatio(CurrencyEnum localCurrency) throws RestException, ParseException {
        String endpoint = format("%s?from=%s&to=USD", currencyConvertApiBaseUrl, localCurrency);
        return currencyConvertApiClient
                .get(endpoint)
                .getData(RatioDTO.class)
                .getRatio();
    }
}
