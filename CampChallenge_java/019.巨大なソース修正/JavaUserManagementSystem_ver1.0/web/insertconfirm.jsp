<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jums.JumsHelper"%>
<jsp:useBean id="bean" class="jums.UserDataBeans" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <% if(!bean.getName().equals("") && !bean.getYear().equals("") && !bean.getMonth().equals("") && !bean.getDay().equals("") && !bean.getType().equals("") && !bean.getComment().equals("") && !bean.getTell().equals("")){ %>
        <h1>登録確認</h1>
        名前:<%= bean.getName()%><br>
        生年月日:<%= bean.getYear()+"年"+bean.getMonth()+"月"+bean.getDay()+"日"%><br>
        種別:<%= bean.getType()%><br>
        電話番号:<%= bean.getTell()%><br>
        自己紹介:<%= bean.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="submit" name="yes" value="はい">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        </form>
    <% }else{ 
    if(bean.getName().equals("")){
    %>
    <h2>名前が不完全です</h2>
    <% }if(bean.getYear().equals("")){ %>
    <h2>年度が不完全です</h2>    
    <% }if(bean.getMonth().equals("")){ %>
    <h2>月が不完全です</h2>    
    <% }if(bean.getDay().equals("")){ %>
    <h2>日が不完全です</h2>    
    <% }if(bean.getYear().equals("")){ %>
    <h2>年度が不完全です</h2>    
    <% }if(bean.getTell().equals("")){ %>
    <h2>電話番号が不完全です</h2>    
    <% }if(bean.getComment().equals("")){ %>
    <h2>自己紹介文が不完全です</h2>   
    <% }} %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
            
        </form>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
