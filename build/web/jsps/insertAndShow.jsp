<%-- 
    Document   : insertAndShow
    Created on : 2017/1/23, 下午 01:45:05
    Author     : yuyun
--%>

<%@page import="mypackage.NamePassword"%>
<%@page import="dao.NamePasswordDAOFactory"%>
<%@page import="dao.NamePasswordDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Insert And Show</h1>
        <%
            NamePasswordDAO dao = NamePasswordDAOFactory.getNamePasswordDAO();
            dao.addNamePassword("abcd", "1234"); 
            dao = NamePasswordDAOFactory.getNamePasswordDAO();
            List<NamePassword> list = dao.getAllNamePassword();                    
        %>
        <%= list%>
        
    </body>
</html>
