package com.linktracker.LinkTracker.utils;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Validators {

    public boolean validateUrl(String url) {
        try {
            new URL(url).toURI();
            return true;

        }catch(URISyntaxException | MalformedURLException exception){
            return false;
        }
    }
}
