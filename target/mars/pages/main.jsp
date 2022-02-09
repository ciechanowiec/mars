<%@page pageEncoding="UTF-8" %>
<%@page import="com.controller.Controller"%>
<jsp:useBean id="controller" class="com.controller.Controller" scope="session"/>
<%  if (!controller.isDataAvailable()) {        
        response.sendRedirect("pages/error.html");
    } %>
    
<html style="font-size: 16px;">
  
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="Live Mars Weather Monitor Curiosity Rover Gale Crater NASA">
    <meta name="description" content="Latest weather at Gale Crater in the southern hemisphere of Mars. Measurements taken by Curiosity Rover.">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>Live Mars Weather Monitor</title>
    <link rel="stylesheet" href="general.css" media="screen">
    <link rel="stylesheet" href="main.css" media="screen">      
    <meta property="og:title" content="Live Mars Weather Monitor">
    <meta property="og:description" content="Latest weather at Gale Crater in the southern hemisphere of Mars. Measurements taken by Curiosity Rover.">
    <meta property="og:image" content="../images/snippet.jpg">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
    <link id="u-page-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">        
    <link rel="icon" href="../images/favicon.png">
    <meta name="theme-color" content="#478ac9">
    <meta property="og:type" content="website">
  </head>
  
  <body class="u-body u-grey-30 u-xl-mode">
    
    <header class="u-clearfix u-grey-30 u-header u-header" id="sec-81bb">
      <div class="u-align-left u-clearfix u-sheet u-valign-middle-sm u-valign-middle-xl u-valign-middle-xs u-sheet-1">
        <a href="https://github.com/ciechanowiec/mars" class="u-active-grey-70 u-border-none u-btn u-btn-round u-button-style u-grey-60 u-hover-grey-70 u-radius-38 u-btn-1" target="_blank">About</a>
      </div>
    </header>

    <section class="u-align-center u-clearfix u-image u-shading u-section-1" id="sec-c28c" data-image-width="9910" data-image-height="7079">
      <div class="u-clearfix u-sheet u-sheet-1">
        <h1 class="u-align-center-sm u-align-center-xs u-align-left-lg u-align-left-md u-align-left-xl u-custom-font u-font-open-sans u-text u-text-white u-text-1"> Latest Weather<br>at Gale Crater</h1>
        <p class="u-align-justify u-text u-text-white u-text-2"> Curiosity Rover is taking daily weather measurements at Gale Crater in the southern hemisphere of Mars, near the equator.&nbsp;At this location, it's currently <%=controller.getSeason(5)%>.</p>
        <p class="u-align-center-sm u-align-center-xs u-align-left-lg u-align-left-md u-align-left-xl u-text u-text-white u-text-3"> High: <%=controller.getMaxTemp(5)%>°C<br>Low: <%=controller.getMinTemp(5)%>°C
        <p class="u-align-center u-text u-text-white u-text-4">
          <span style="font-weight: 700; font-size: 2.5rem;">Sol <%=controller.getSol(5)%></span>
          <br>
          <span style="font-size: 2.125rem;"><%=controller.getTerrestrialDateFull(5)%></span>
        </p>
        <div class="u-expanded-width-lg u-list u-list-1">
          <div class="u-repeater u-repeater-1">
            <div class="u-align-center u-container-style u-grey-60 u-list-item u-opacity u-opacity-45 u-repeater-item u-shape-rectangle u-list-item-1">
              <div class="u-container-layout u-similar-container u-container-layout-1">
                <p class="u-align-center-sm u-align-center-xs u-text u-text-default u-text-5"> Sol <%=controller.getSol(0)%><br><%=controller.getTerrestrialDateShort(0)%><br>
                  <br>High: <%=controller.getMaxTemp(0)%>°C<br>Low: <%=controller.getMinTemp(0)%>°C
                </p>
                <div class="u-border-2 u-border-white u-line u-line-horizontal u-line-1"></div>
              </div>
            </div>
            <div class="u-align-center-lg u-align-center-md u-align-center-xl u-container-style u-grey-60 u-list-item u-opacity u-opacity-45 u-repeater-item u-shape-rectangle u-list-item-2">
              <div class="u-container-layout u-similar-container u-container-layout-2">
                <p class="u-align-center-sm u-align-center-xs u-text u-text-default u-text-6"> Sol <%=controller.getSol(1)%><br><%=controller.getTerrestrialDateShort(1)%><br>
                  <br>High: <%=controller.getMaxTemp(1)%>°C<br>Low: <%=controller.getMinTemp(1)%>°C
                </p>
                <div class="u-border-2 u-border-white u-line u-line-horizontal u-line-2"></div>
              </div>
            </div>
            <div class="u-align-center u-container-style u-grey-60 u-list-item u-opacity u-opacity-45 u-repeater-item u-shape-rectangle u-list-item-3">
              <div class="u-container-layout u-similar-container u-container-layout-3">
                <p class="u-align-center-sm u-align-center-xs u-text u-text-default u-text-7"> Sol <%=controller.getSol(2)%><br><%=controller.getTerrestrialDateShort(2)%><br>
                  <br>High: <%=controller.getMaxTemp(2)%>°C<br>Low: <%=controller.getMinTemp(2)%>°C
                </p>
                <div class="u-border-2 u-border-white u-line u-line-horizontal u-line-3"></div>
              </div>
            </div>
            <div class="u-align-center u-container-style u-grey-60 u-list-item u-opacity u-opacity-45 u-repeater-item u-shape-rectangle u-list-item-4">
              <div class="u-container-layout u-similar-container u-container-layout-4">
                <p class="u-align-center-sm u-align-center-xs u-text u-text-default u-text-8"> Sol <%=controller.getSol(3)%><br><%=controller.getTerrestrialDateShort(3)%><br>
                  <br>High: <%=controller.getMaxTemp(3)%>°C<br>Low: <%=controller.getMinTemp(3)%>°C
                </p>
                <div class="u-border-2 u-border-white u-line u-line-horizontal u-line-4"></div>
              </div>
            </div>
            <div class="u-align-center u-container-style u-grey-60 u-list-item u-opacity u-opacity-45 u-repeater-item u-shape-rectangle u-list-item-5">
              <div class="u-container-layout u-similar-container u-container-layout-5">
                <p class="u-align-center-sm u-align-center-xs u-text u-text-default u-text-9"> Sol <%=controller.getSol(4)%><br><%=controller.getTerrestrialDateShort(4)%><br>
                  <br>High: <%=controller.getMaxTemp(4)%>°C<br>Low: <%=controller.getMinTemp(4)%>°C
                </p>
                <div class="u-border-2 u-border-white u-line u-line-horizontal u-line-5"></div>
              </div>
            </div>
            <div class="u-align-center u-container-style u-grey-60 u-list-item u-opacity u-opacity-45 u-repeater-item u-shape-rectangle u-list-item-6">
              <div class="u-container-layout u-similar-container u-container-layout-6">
                <p class="u-align-center-sm u-align-center-xs u-text u-text-default u-text-10"> Sol <%=controller.getSol(5)%><br><%=controller.getTerrestrialDateShort(5)%><br>
                  <br>High: <%=controller.getMaxTemp(5)%>°C<br>Low: <%=controller.getMinTemp(5)%>°C
                </p>
                <div class="u-border-2 u-border-white u-line u-line-horizontal u-line-6"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

  </body>

</html>