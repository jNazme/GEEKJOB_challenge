<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="kagoyume.header"%>
<% 
    HttpSession hs = request.getSession();
    header a = new header(hs,request);
    
%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録完了</title>
    </head>
    <body>
        <%=a.getHeaderMessage()%>
        <h1>登録完了</h1>
        <hr>
        <h2>
            登録が完了し、ログインしました。
        </h2>
    </body>
</html>
