
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
    String name = request.getParameter("name");
    String password =request.getParameter("password");
    String mail = request.getParameter("mail");
    String adress = request.getParameter("adress");
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>登録確認</h1>
        <hr>
        <%
            if(name.equals("")||password.equals("")||mail.equals("")||adress.equals("")||name == null||password == null||mail == null||adress == null){
        %>
        <h2>入力情報が不完全です</h2>
        <%
            }else{ 
        %>
         <h2>以下の情報で登録してよろしいですか？</h2>
        名前:<%=name%><br>
        パスワード:<%=password%><br>
        メール:<%=mail%><br>
        住所:<%=adress%>
        <form action="Registrationconfirm" method="post">
            <input type="submit" value="新規登録">
           <input type="hidden" name="name" value="<%=name%>">
           <input type="hidden" name="password" value="<%=password%>">
           <input type="hidden" name="mail" value="<%=mail%>">
           <input type="hidden" name="adress" value="<%=adress%>">
        </form>
        <%
            }
        %>
    </body>
</html>
