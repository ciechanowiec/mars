# Live Mars Weather Monitor

## Table of Contents
1. [Basic Info](#Basic-Info)
2. [Features](#Features)
3. [Deployment](#Deployment)
4. [Weather Data Source](#Weather-Data-Source)
5. [Architecture](#Architecture)
6. [Screenshots](#Screenshots)
7. [License](#License)

## Basic Info
This program is an [online](https://live-mars.herokuapp.com) Mars weather monitor. It shows the latest results of daily weather measurements taken by Curiosity Rover at Gale Crater in the southern hemisphere of Mars, near the equator.
| Parameter                               | Data                                                              |
| :-------------------------------------: | :---------------------------------------------------------------: |
| Program name:                           | Live Mars Weather Monitor                                         |
| Date of creation:                       | February 2022                                                     |
| Technologies used:                      | Java SE, Java Server Pages,<br/>HTTP, HTML, CSS,<br/>JSON, Maven  |
| Time spent to <br/> create the program: | ~2 days                                                           |
| Author:                                 | Herman Ciechanowiec <br/> herman@ciechanowiec.eu                  |
| License:                                | MIT No Attribution License                                        |

## Features
The program has the following features:
- fully functioning and deployed web application
- online retrieving of weather data from Astrobiology Center - NASA’s partner which manages Curiosity Rover’s weather measurements
- presented weather data for each day: Earth date, sol number (Mars days passed from the beginning of the Curiosity Rover’s mission), the highest and the lowest registered temperature
- presented weather data embraces 6 latest sols (~6.16 Earth days) of the Curiosity Rover’s mission
- handling failed weather data retrievement

## Deployment
The program was deployed at https://live-mars.herokuapp.com as a WAR file through Heroku Maven Plugin. Instructions regarding this way of deployment can be found here: https://devcenter.heroku.com/articles/deploying-java-applications-with-the-heroku-maven-plugin.

## Weather Data Source 
The source of weather data presented by the program is Rover Environmental Monitoring Station (REMS) installed on Curiosity Rover (https://cab.inta-csic.es/rems/en). REMS was designed and is managed by Spanish Astrobiology Center (https://cab.inta-csic.es/en). Here are some Mars photos of REMS sensors:<br/>

<kbd><img src="!presentation/rems/1.jpg" width="500" height="694"></kbd><br/><br/>
<kbd><img src="!presentation/rems/2.jpg" width="694" height="510"></kbd><br/><br/>
<kbd><img src="!presentation/rems/3.jpg" width="694" height="505"></kbd><br/>

Full (both archive and current) weather data from REMS is published by Astrobiology Center at https://cab.inta-csic.es/rems//wp-content/plugins/marsweather-widget/api.php. However, due to the extensiveness of that original weather data, the program uses intermediate API called MAAS2 to retrieve required weather data. The description of MAAS2 API can be found here: https://github.com/Apollorion/MAAS2.

## Architecture
The program is divided into three parts: front-end (graphical user interface), back-end (logic of the program) and the controller, which handles a relationship between the front-end and the back-end. The connection with Astrobiology Center’s server is established at the back-end level:
<img src="!presentation/program_architecture.jpg">

## Screenshots
<kbd><img src="!presentation/gui_screenshots/1.png"></kbd><br/>

## License
The program is subject to MIT No Attribution License

Copyright © 2022 Herman Ciechanowiec

Permission is hereby granted, free of charge, to any person obtaining a copy of this
software and associated documentation files (the "Software"), to deal in the Software
without restriction, including without limitation the rights to use, copy, modify,
merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so.

The Software is provided "as is", without warranty of any kind, express or implied,
including but not limited to the warranties of merchantability, fitness for a
particular purpose and noninfringement. In no event shall the authors or copyright
holders be liable for any claim, damages or other liability, whether in an action
of contract, tort or otherwise, arising from, out of or in connection with the
Software or the use or other dealings in the Software.
