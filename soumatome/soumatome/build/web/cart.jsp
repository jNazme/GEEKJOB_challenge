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
    ArrayList items = new ArrayList();
    ArrayList<HashMap> item2 = new ArrayList<HashMap>();
    items = (ArrayList)request.getAttribute("cartItems");
    %>
<!DOCTYPE html>

    <style>
        div.Item img{
    border: none;
    float: left;
    clear: both;
    margin: 5px;
}

div.Item p{
    height: 64px;
    line-height:120%;
    font-size:90%;
    overflow:hidden;
    color:#808080;

}
    </style>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
        <title>カートの中身</title>
    </head>
    
        <%=a.getHeaderMessage()%>
        <h1>カートの中身</h1>
        <hr>
        <% 
            int allPrice = 0;
            ArrayList array = new ArrayList();
            for (int i=0;i<items.size()&&i<10;i++){
                HashMap<String, String> item = new HashMap<String, String>();
                item2 = (ArrayList<HashMap>)items.get(i);
                item = (HashMap<String, String>)item2.get(0);
                allPrice +=  Integer.parseInt(item.get("Price"));
        %>
        <div class="Item">
            <a href="<% out.print("item.jsp?id="+item.get("ID")+"&price="+item.get("Price")+"&name="+item.get("Name")+"&image="+item.get("Image"));%>"><img src="<% out.print(item.get("Image"));%>" /></a>
            <a href="<% out.print("item.jsp?id="+item.get("ID"));%>"><% out.print(item.get("Name"));%></a>
            <p class="price"><% out.print(item.get("Price")+"円");%>&emsp;<a href="<% out.print("CartDelete?id="+item.get("ID"));%>">カートから商品を削除</a></p>
        </div>
        <% }
            out.print("合計金額:"+String.valueOf(allPrice)+"円");
        %>
        <form action="Buyconfirm">
            <input type="submit" value="購入する">
        </form>
    

