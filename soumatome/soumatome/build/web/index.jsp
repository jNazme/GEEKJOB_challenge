<%-- 
    Document   : index
    Created on : 2018/01/30, 13:54:47
    Author     : jun
--%>
<%@page import="kagoyume.header"%>
<% 
    HttpSession hs = request.getSession();
    header a = new header(hs,request); 
%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>トップページ</title>
    </head>
    <body>
        <%=a.getHeaderMessage()%>
        <h1>かごゆめ</h1>
        以下のフォームから、商品が検索できます。商品をカートに追加し、会員登録すると商品が購入できます。
        <hr>
        <form action="search.jsp" method="GET">
        <input type="text" name="search" >
        <input type="submit" name="btnSubmit" value="検索">
    </form>
    </body>
</html>
