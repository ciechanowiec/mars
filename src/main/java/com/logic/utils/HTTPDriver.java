package com.logic.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDate;

public class HTTPDriver {

    private HttpClient client;
    private HttpRequest request;
    private HttpResponse<String> resposne;

    public HTTPDriver() {
        this.client = HttpClient.newBuilder()
                                .followRedirects(Redirect.ALWAYS)
                                .build();
    }

    public String retrieveRawDayDataUsual(String sol) throws IllegalStateException {        
        try {
            buildDayDataRequestUsual(sol);
            buildDayDataResponseUsual();        
            if (this.resposne.statusCode() == 200) {
                return this.resposne.body();
            } else {
                throw new IllegalStateException("Failed to retrieve weather data.");    
            }
        } catch (Exception e) {                        
            throw new IllegalStateException("Failed to retrieve weather data.");            
        }
    }

    private void buildDayDataRequestUsual(String sol) throws URISyntaxException {
        String url = String.format("https://api.maas2.apollorion.com/%s", sol);
        this.request = HttpRequest.newBuilder()
                                  .uri(new URI(url))
                                  .GET()
                                  .build();
    }

    private void buildDayDataResponseUsual() throws IOException, InterruptedException {
        this.resposne = this.client.send(this.request, BodyHandlers.ofString());
    }

    public String retrieveRawDayDataLatest() throws IllegalStateException {        
        try {
            buildDayDataRequestLatest();
            buildDayDataResponseLatest();            
            if (this.resposne.statusCode() == 200) {
                return this.resposne.body();
            } else {
                throw new IllegalStateException("Failed to retrieve latest weather data.");    
            }
        } catch (Exception e) {                        
            throw new IllegalStateException("Failed to retrieve latest weather data.");       
        }
    }

    private void buildDayDataRequestLatest() throws URISyntaxException {
        String url = "https://api.maas2.apollorion.com";
        this.request = HttpRequest.newBuilder()
                                  .uri(new URI(url))
                                  .GET()
                                  .build();
    }

    private void buildDayDataResponseLatest() throws IOException, InterruptedException {
        this.resposne = this.client.send(this.request, BodyHandlers.ofString());
    }
    
}
