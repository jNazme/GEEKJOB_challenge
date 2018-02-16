
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
    request.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ユーザーデータ削除</title>
    </head>
    <body>
                <%=a.getHeaderMessage()%>

        <h1>ユーザーデータ削除</h1>
        <hr>
        <h2>このユーザーデータを削除しますか？</h2>
        <form action="Mydeleteresult">
            <input type="submit" value="削除">
        </form>
    </body>
</html>
