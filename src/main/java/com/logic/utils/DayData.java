package com.logic.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DayData {    

    private String terrestrialDateFull;
    private String terrestrialDateShort;
    private String season;
    private String minTemp;
    private String maxTemp;
    private String sol;
    
    public DayData(String terrestrialDateRaw, String season, String minTemp, String maxTemp, String sol)
                   throws IllegalStateException {
        try {
            dispatchTerrestrialDateRaw(terrestrialDateRaw);
            setupSeason(season);
            this.minTemp = minTemp;
            this.maxTemp = maxTemp;
            this.sol = sol;
        } catch (Exception e) {
            throw new IllegalStateException("Failed to create day data.");
        }
    }    

    private void dispatchTerrestrialDateRaw(String terrestrialDateRaw) {        
        LocalDate terrestrialDateISO = LocalDate.parse(terrestrialDateRaw
                                                       .replaceAll("(?<=\\d{4}-\\d{2}-\\d{2}).*", ""));
                                                       /* Converts from "2022-02-02T00:00:00.000Z"
                                                          to "2022-02-02" */
        DateTimeFormatter dateFullFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy"); // "2 February 2022"
        DateTimeFormatter dateShortFormatter = DateTimeFormatter.ofPattern("MMM. d"); // "Feb. 2"
        this.terrestrialDateFull = terrestrialDateISO.format(dateFullFormatter);
        this.terrestrialDateShort = terrestrialDateISO.format(dateShortFormatter);        
    }

    private void setupSeason(String season) throws IllegalStateException {        
        this.season = switch (season) {
            case "Month 1" -> "early autumn";
            case "Month 2" -> "middle autumn";
            case "Month 3" -> "late autumn";
            case "Month 4" -> "early winter";
            case "Month 5" -> "middle winter";
            case "Month 6" -> "late winter";
            case "Month 7" -> "early spring";
            case "Month 8" -> "middle spring";
            case "Month 9" -> "late spring";
            case "Month 10" -> "early summer";
            case "Month 11" -> "middle summer";
            case "Month 12" -> "late summer";            
            default -> throw new IllegalStateException("Unknown month.");
        };        
    }

    public String getTerrestrialDateFull() {
        return this.terrestrialDateFull;
    }

    public String getTerrestrialDateShort() {
        return this.terrestrialDateShort;
    }

    public String getSeason() {
        return this.season;
    }

    public String getMinTemp() {
        return this.minTemp;
    }

    public String getMaxTemp() {
        return this.maxTemp;
    }

    public String getSol() {
        return this.sol;
    }

    /* Method for testing purposes */
    public String toString() {
        return String.format("""
                             Terrestrial date full: %s
                             Terrestrial date short: %s
                             Season: %s
                             Min temp: %s
                             Max temp: %s
                             Sol: %s
                             """, this.terrestrialDateFull, this.terrestrialDateShort,
                                  this.season, this.minTemp, this.maxTemp, this.sol);
    }
    
}
