<%-- 
    Document   : login
    Created on : 2018/02/07, 17:24:13
    Author     : jun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(request.getParameter("log").equals("out")){
              HttpSession hs = request.getSession();
              hs.setAttribute("udt", "");
              
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            out.print("ログアウトしました。");
            }
        %>
           <h1>ログイン</h1>
           <hr>
           <div>
              <table border="0">
                  <form action="/soumatome/Login" method="GET">
                      <tr>
                          <th>
                              ユーザ名
                          </th>
                          <td>
                              <input type="text" name="name" value="" size="24">
                          </td>
                      </tr>
                      <tr>
                          <th>
                              パスワード
                          </th>
                          <td>
                              <input type="password" name="password" value="" size="24">
                          </td>
                      </tr>
                      <tr>
                          <td colspan="2">
                              <input type="submit" value="ログイン">
                              <input type="hidden" name="page" value="<%=request.getParameter("page")%>">
                              <input type="hidden" name="log" value="<%=request.getParameter("log")%>">
                  </form>
                  <button onclick="location.href='registration.jsp?page=<%=request.getParameter("page")%>'">新規登録</button>
                          </td>
                      </tr>
                  
                  </table>
          </div>
      </body>
</html>
