<%-- 
    Document   : error
    Created on : 2018/02/13, 10:23:17
    Author     : jun
--%>
<%
String error = (String)request.getAttribute("error");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>エラー</title>
    </head>
    <body>
        <h1>エラーが出ました</h1>
        <%=error%>
    </body>
</html>
