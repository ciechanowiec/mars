<%@ page import="com.controller.Controller" %>
<jsp:useBean id="controller" class="com.controller.Controller" scope="session"/>
<%  if (controller.isDataAvailable()) {
        response.sendRedirect("pages/showpage.jsp");
    } else {
        response.sendRedirect("pages/errorpage.html");
    } %>