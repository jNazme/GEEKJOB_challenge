<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="kagoyume.xmlReader" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.List" 
        import="javax.servlet.http.HttpSession"
        import="kagoyume.UserDataDTO"
        import="kagoyume.header"%>
<%
    HttpSession hs = request.getSession();
    header a = new header(hs,request);
    ArrayList items = new ArrayList();
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>購入完了</title>
    </head>
    <body>
                <%=a.getHeaderMessage()%>
        <h1>購入が完了しました</h1>
    </body>
</html>
