<%-- 
    Document   : deleteAndShow
    Created on : 2019/8/4, 下午 03:33:35
    Author     : student
--%>

<%@page import="mypackage.NamePassword"%>
<%@page import="java.util.List"%>
<%@page import="dao.NamePasswordDAOFactory"%>
<%@page import="dao.NamePasswordDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>delete And Show</h1>
        <%
            NamePasswordDAO dao = NamePasswordDAOFactory.getNamePasswordDAO();
            //dao.deleteNamePassword("yyyy", "1234"); 
            dao.deleteNamePassword("abcd");
            dao = NamePasswordDAOFactory.getNamePasswordDAO();
            List<NamePassword> list = dao.getAllNamePassword();                    
        %>
        <%= list%>
    </body>
</html>
