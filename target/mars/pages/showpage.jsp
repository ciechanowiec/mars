<%@ page import="com.controller.Controller"%>
<jsp:useBean id="controller" class="com.controller.Controller" scope="session"/>
<html>
    <head>
        <title>Live Mars Weather Monitor</title>
    </head>
    <body>
        <% for (int day = 0; day <= 5; day++) { %>            
            <p>Terrestrial date full: <%= controller.getTerrestrialDateFull(day)%></p>        
            <p>Terrestrial date short: <%= controller.getTerrestrialDateShort(day)%></p>        
            <p>Season: <%= controller.getSeason(day)%></p>        
            <p>Min temp: <%= controller.getMinTemp(day)%></p>        
            <p>Max temp: <%= controller.getMaxTemp(day)%></p>        
            <p>Sol: <%= controller.getSol(day)%></p><br/>
        <% } %>
    </body>
</html>