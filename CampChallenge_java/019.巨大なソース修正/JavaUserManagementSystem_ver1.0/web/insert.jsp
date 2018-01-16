<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<jsp:useBean id="bean" class="jums.UserDataBeans" scope="session" />
<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value="<%=bean.getName()%>">
        <br><br>

        生年月日:
        <select name="year">
            <option value="<%=bean.getYear()%>"><%=bean.getYear()%></option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"> <%=i%> </option>
            <% } %>
        </select>年
        <select name="month">
            <option value="<%=bean.getMonth()%>"><%=bean.getMonth()%></option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="<%=bean.getDay()%>"><%=bean.getDay()%></option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        
        <input type="radio" name="type" value="1" <% if(bean.getType().equals("1")){%> <%="checked"%><%}%>>エンジニア<br>
        <input type="radio" name="type" value="2" <% if(bean.getType().equals("2")){%> <%="checked"%><%}%>>営業<br>
        <input type="radio" name="type" value="3" <% if(bean.getType().equals("3")){%> <%="checked"%><%}%>>その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%=bean.getTell()%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard" value="<%=bean.getComment()%>"><%=bean.getComment()%></textarea><br><br>

        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
