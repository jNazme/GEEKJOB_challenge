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

        <h1>新規登録</h1>
           <hr>
           <table border="0">
        <form action="registrationconfirm.jsp" method="post">
                      <tr>
                          <th>ユーザ名</th>
                          <td><input type="text" name="name" value="" size="24"></td>
                      </tr>
                      <tr>
                          <th>パスワード</th>
                          <td>
                              <input type="password" name="password" value="" size="24">
                          </td>
                      </tr>
                      <tr>
                          <th>
                              メールアドレス
                          </th>
                          <td>
                              <input type="text" name="mail" value="" size="24">
                          </td>
                      </tr>
                       <tr>
                          <th>
                              住所
                          </th>
                          <td>
                              <input type="text" name="adress" value="" size="24">
                          </td>
                      </tr>
                      <tr>
                          <td colspan="2">
                              <input type="submit" value="新規登録">
                              <input type="hidden" name="url" value="<%=request.getParameter("page")%>">
                      </tr>        
                  </form>
           </table>
    </body>
</html>
