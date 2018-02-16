<%@page import="kagoyume.header"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    HttpSession hs = request.getSession();
    header a = new header(hs,request); 
    request.setCharacterEncoding("ISO-8859-1");
    String itemName = new String (request.getParameter("name").getBytes("ISO-8859-1"));
%> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品を追加しました。</title>
    </head>
    <body>
        <%=a.getHeaderMessage()%>
        <h1><%=itemName%>をカートに追加しました。</h1><hr>
        <img src="<%=request.getParameter("image")%>" />
                <p class="price"><%=request.getParameter("price")%></p>
    </body>
</html>