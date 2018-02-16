<%@page import="kagoyume.header"%>
<% 
    HttpSession hs = request.getSession();
    header a = new header(hs,request); 
    request.setCharacterEncoding("UTF-8");
%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%=a.getHeaderMessage()%>
        <h1><%=request.getParameter("name")%></h1><hr>
        <img src="<%=request.getParameter("image")%>" />
                <p class="price"><%=request.getParameter("price")%>
                    <a href="<% out.print("Add?id="+request.getParameter("id")+"&price="+request.getParameter("price")+"&name="+request.getParameter("name")+"&image="+request.getParameter("image"));%>">カートに加える</a>
</p>
        
    </body>
</html>
