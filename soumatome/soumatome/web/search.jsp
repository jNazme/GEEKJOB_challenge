
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
    <style>
        div.Item img{
    border: none;
    float: left;
    clear: both;
    margin: 5px;
}

div.Item p{
    height: 128px;
    line-height:120%;
    font-size:90%;
    overflow:hidden;
    color:#808080;

}
    </style>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
        <title>検索結果</title>
    </head>
    <body>
        <%=a.getHeaderMessage()%>
        <h1>検索結果</h1>
        <h2>
            <%
                ArrayList<HashMap> items = new ArrayList<HashMap>();
                items = xmlReader.getXMLFromHttp(Boolean.TRUE,(String)request.getParameter("search"));
                out.print("キーワード:"+(String)request.getParameter("search")+"検索数:"+items.size());
            %></h2>
        <hr>
        
        
        
        
        <% 
           
           
            for (int i=0;i<items.size()&&i<10;i++){
                HashMap item = items.get(i);
                
        %>
        <div class="Item">
            <a href="<% out.print("item.jsp?id="+item.get("ID")+"&price="+item.get("Price")+"&name="+item.get("Name")+"&image="+item.get("Image"));%>">
                <img src="<% out.print(item.get("Image"));%>" /><% out.print(item.get("Name"));%></a>
                <p class="price">
                <% out.print(item.get("Price")+"円");%>                <a href="<% out.print("Add?id="+item.get("ID")+"&price="+item.get("Price")+"&name="+item.get("Name")+"&image="+item.get("Image"));%>">カートに加える</a>
</p>
        </div>
        <% } %>
    </body>

</html>