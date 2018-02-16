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
        <title>登録情報更新完了</title>
    </head>
    <body>
        <%=a.getHeaderMessage()%>
        <h2>登録情報を更新しました</h2>
    </body>
</html>

