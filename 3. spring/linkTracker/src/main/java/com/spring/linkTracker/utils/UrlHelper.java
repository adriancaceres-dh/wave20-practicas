package com.spring.linkTracker.utils;

import com.spring.linkTracker.exception.UrlNotValidException;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlHelper {

    public static boolean checkUrl(String url){
        try{
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
