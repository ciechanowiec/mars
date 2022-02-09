package com.controller;

import java.util.ArrayList;

import com.logic.MainEngine;
import com.logic.utils.DayData;

public class Controller {

    private MainEngine mainEngine;
    /* Days are sorted from the oldest to the newest */
    private ArrayList<DayData> latestSixDaysData;

    public Controller() {
        this.mainEngine = new MainEngine();
        if (this.mainEngine.isDataAvailable()) {
            this.latestSixDaysData = mainEngine.getLatestSixDaysData();
        }
    }
    
    public boolean isDataAvailable() {
        return this.mainEngine.isDataAvailable();
    }

    public String getTerrestrialDateFull(int day) {
        return this.latestSixDaysData.get(day).getTerrestrialDateFull();
    }

    public String getTerrestrialDateShort(int day) {
        return this.latestSixDaysData.get(day).getTerrestrialDateShort();
    }

    public String getSeason(int day) {
        return this.latestSixDaysData.get(day).getSeason();
    }

    public String getMinTemp(int day) {
        return this.latestSixDaysData.get(day).getMinTemp();
    }

    public String getMaxTemp(int day) {
        return this.latestSixDaysData.get(day).getMaxTemp();
    }

    public String getSol(int day) {
        return this.latestSixDaysData.get(day).getSol();
    }
    
}
