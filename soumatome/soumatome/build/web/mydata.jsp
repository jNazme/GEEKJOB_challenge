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
    UserDataDTO udt = (UserDataDTO)hs.getAttribute("udt");
    %>
<!DOCTYPE html>
<html>
    <style>
        div.Item img{
    border: none;
    float: left;
    clear: both;
    margin: 5px;
}

div.Item p{
    height: 146px;
    
    line-height:120%;
    font-size:90%;
    overflow:hidden;
    color:#808080;

}
    </style>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
        <title>ユーザー情報</title>
    </head>
    <body>
        <%=a.getHeaderMessage()%>
        <h1>ユーザー情報</h1>
        <hr>
        名前:<%=udt.getName()%><br>
        メール:<%=udt.getMail()%><br>
        住所:<%=udt.getAdress()%><br>
        <form action="Myhistory" method="GET">
        <input type="submit" name="btnSubmit" value="購入履歴を見る">
        </form>
        <form action="myupdate.jsp" method="GET">
        <input type="submit" name="btnSubmit" value="登録情報を変更">
        </form>
        <form action="mydelete.jsp" method="GET">
        <input type="submit" name="btnSubmit" value="ユーザーを削除">
        </form>
    </body>

</html>