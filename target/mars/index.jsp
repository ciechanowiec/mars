<%@ page import="com.controller.Controller" %>
<jsp:useBean id="controller" class="com.controller.Controller" scope="session"/>
<%  if (controller.isDataAvailable()) {
        response.sendRedirect("pages/main.jsp");
    } else {
        response.sendRedirect("pages/error.html");
    } %>