/**
 * # Live Mars Weather Monitor
 * 
 * ## Table of Contents
 * 1. Basic Info
 * 2. Features
 * 3. Deployment
 * 4. Weather Data Source
 * 5. Architecture
 * 6. License
 * 
 * ## Basic Info
 * This program is an online (https://live-mars.herokuapp.com) Mars weather monitor. It shows the 
 * latest results of daily weather measurements taken by Curiosity Rover at Gale Crater in 
 * the southern hemisphere of Mars, near the equator.
 * 
 * | Parameter                               | Data                                                      |
 * | :-------------------------------------: | :-------------------------------------------------------: |
 * | Program name:                           | Live Mars Weather Monitor                                 |
 * | Date of creation:                       | February 2022                                             |
 * | Technologies used:                      | Java SE, Java Server Pages, HTTP, HTML, CSS, JSON, Maven  |
 * | Time spent to <br/> create the program: | ~2 days                                                   |
 * | Author:                                 | Herman Ciechanowiec, herman@ciechanowiec.eu               |
 * | License:                                | MIT No Attribution License                                |
 * 
 * ## Features
 * The program has the following features:
 * - fully functioning and deployed web application
 * - online retrieving of weather data from Astrobiology Center - NASA’s partner 
 *   which manages Curiosity Rover’s weather measurements
 * - presented weather data for each day: Earth date, sol number (Mars days passed from the 
 *   beginning of the Curiosity Rover’s mission), the highest and the lowest registered temperature
 * - presented weather data embraces 6 latest sols (~6.16 Earth days) of the Curiosity Rover’s mission
 * - handling failed weather data retrievement
 * 
 * ## Deployment
 * The program was deployed at https://live-mars.herokuapp.com as a WAR file through Heroku Maven Plugin. Instructions 
 * regarding this way of deployment can be found here:
 * https://devcenter.heroku.com/articles/deploying-java-applications-with-the-heroku-maven-plugin.
 * 
 * ## Weather Data Source 
 * The source of weather data presented by the program is Rover Environmental Monitoring Station (REMS) installed 
 * on Curiosity Rover (https://cab.inta-csic.es/rems/en). REMS was designed and is managed by Spanish Astrobiology 
 * Center (https://cab.inta-csic.es/en).
 * 
 * Full (both archive and current) weather data from REMS is published by Astrobiology 
 * Center at https://cab.inta-csic.es/rems//wp-content/plugins/marsweather-widget/api.php. However, due to the 
 * extensiveness of that original weather data, the program uses intermediate API called MAAS2 to retrieve 
 * required weather data. The description of MAAS2 API can be found here: https://github.com/Apollorion/MAAS2.
 * 
 * ## Architecture
 * The program is divided into three parts: front-end (graphical user interface), back-end (logic of the program) 
 * and the controller, which handles a relationship between the front-end and the back-end. 
 * The connection with Astrobiology Center’s server is established at the back-end level.
 * 
 * ## License
 * The program is subject to MIT No Attribution License
 * 
 * Copyright © 2022 Herman Ciechanowiec
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify,
 * merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so.
 * 
 * The Software is provided "as is", without warranty of any kind, express or implied,
 * including but not limited to the warranties of merchantability, fitness for a
 * particular purpose and noninfringement. In no event shall the authors or copyright
 * holders be liable for any claim, damages or other liability, whether in an action
 * of contract, tort or otherwise, arising from, out of or in connection with the
 * Software or the use or other dealings in the Software.
 *  
 */

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
