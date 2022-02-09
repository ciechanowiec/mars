package com.logic;

import java.util.ArrayList;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.logic.utils.DayData;
import com.logic.utils.HTTPDriver;

public class MainEngine {

    private HTTPDriver httpDriver;
    private ArrayList<DayData> latestSixDaysData;
    private boolean isDataAvailable;
    
    public MainEngine() {
        this.httpDriver = new HTTPDriver();
        this.latestSixDaysData = new ArrayList<>();
        this.isDataAvailable = true;
        retrieveLatestSixDaysData();
    }    

    private void retrieveLatestSixDaysData() {
        try {
            int latestSol = Integer.parseInt(getLatestSol());
            int[] sixLatestSols = {latestSol - 5, latestSol - 4, latestSol - 3, 
                                   latestSol - 2, latestSol - 1, latestSol};
            for (int sol : sixLatestSols) {
                this.latestSixDaysData.add(getDayData(String.valueOf(sol)));
            }        
        } catch (Exception e) {
            this.isDataAvailable = false;
        }
    }

    private DayData getDayData(String sol) throws IllegalStateException {
        try {
            String rawDayData = this.httpDriver.retrieveRawDayDataUsual(sol);            
            JsonObject jsonObject = JsonParser.parseString(rawDayData).getAsJsonObject();
    
            String terrestrialDateRaw = jsonObject.get("terrestrial_date").getAsString();
            String season = jsonObject.get("season").getAsString();
            String minTemp = jsonObject.get("min_temp").getAsString();
            String maxTemp = jsonObject.get("max_temp").getAsString(); 

            DayData dayData = new DayData(terrestrialDateRaw, season, minTemp, maxTemp, sol);
            return dayData;
        } catch (Exception e) {
            throw new IllegalStateException("Failed to retrieve weather data.");            
        }
    }

    private String getLatestSol() throws IllegalStateException {
        try {
            String rawDayData = this.httpDriver.retrieveRawDayDataLatest();            
            JsonObject jsonObject = JsonParser.parseString(rawDayData).getAsJsonObject();
            String latestSol = jsonObject.get("sol").getAsString();      
            return latestSol;
        } catch (Exception e) {
            throw new IllegalStateException("Failed to retrieve latest weather data.");
        }
    }

    public ArrayList<DayData> getLatestSixDaysData() {        
        return this.latestSixDaysData;
    }      
    
    public boolean isDataAvailable() {
        return this.isDataAvailable;
    }
    
}
