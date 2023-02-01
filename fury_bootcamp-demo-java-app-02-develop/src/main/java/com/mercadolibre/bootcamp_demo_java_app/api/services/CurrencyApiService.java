package com.mercadolibre.bootcamp_demo_java_app.api.services;

import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyDTO;
import com.mercadolibre.restclient.Response;
import com.mercadolibre.restclient.RestClient;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

import javax.annotation.PostConstruct;


@Service


public class CurrencyApiService extends RestClientService
{
    private String currencyApiBaseUrl;
    private RestClient currencyApiClient;


    @Value("${meli.base.url}")
    private String baseUrl;


    public CurrencyApiService() {
        super();
    }

    // /currency_conversions/search?from=$CURRENCY_ID&to=$CURRENCY_ID
    @PostConstruct
    public void init() throws IOException
    {
        currencyApiBaseUrl = String.format("%s/currency_conversions/",baseUrl);
        currencyApiClient = RestClient.builder()
                .withPool(restPool)
                .build();
    }


    public CurrencyDTO getCurrency(String currencyIdFrom, String currencyIdTo) throws ParseException, RestException {
        String currentItemUrl = currencyApiBaseUrl + "search?from=" +currencyIdFrom+"&to="+currencyIdTo;
        Response resp = currencyApiClient.get(currentItemUrl);
        return resp.getData(CurrencyDTO.class);
    }




}
