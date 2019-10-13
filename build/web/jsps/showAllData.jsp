<%-- 
    Document   : showAllData
    Created on : 2019/8/4, 上午 11:58:28
    Author     : student
--%>

<%@page import="mypackage.NamePassword"%>
<%@page import="java.util.List"%>
<%@page import="dao.NamePasswordDAO"%>
<%@page import="dao.NamePasswordDAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            NamePasswordDAO dao = NamePasswordDAOFactory.getNamePasswordDAO();
            List<NamePassword> list = dao.getAllNamePassword();            
        %>
        <%= list%>
    </body>
</html>
