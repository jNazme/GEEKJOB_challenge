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
<html>
    <style>
        div.Item img{
    border: none;
    float: left;
    clear: both;
    margin: 5px;
}

div.Item p{
    line-height:120%;
    font-size:90%;
    overflow:hidden;
    color:#808080;

}
    </style>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
        <title>購入</title>
    </head>
    <body>
        <%=a.getHeaderMessage()%>
        <h1>カートの中身</h1>
        <hr>
        <form action="Buycomplete">
            <select name="type">
                <option value=1>宅急便</option>
                <option value=2>郵便</option>
            </select>
            <input type="submit" value="購入">
        </form>
        <% 
            ArrayList array = new ArrayList();
            int allPrice = 0;
            for (int i=0;i<items.size()&&i<10;i++){
                HashMap<String, String> item = new HashMap<String, String>();
                item2 = (ArrayList<HashMap>)items.get(i);
                item = (HashMap<String, String>)item2.get(0);
                allPrice +=  Integer.parseInt(item.get("Price"));
        %>
        <div class="Item">
            <img src="<%=item.get("Image")%>" />
            <%=item.get("Name")%>
            <p class="price"><%=item.get("Price")+"円"%></p>
        </div>
        <% }
            out.print("合計金額:"+String.valueOf(allPrice)+"円");
        %>
        
    </body>

</html>