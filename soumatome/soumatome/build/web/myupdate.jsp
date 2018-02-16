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
    UserDataDTO udt = new UserDataDTO();
    udt = (UserDataDTO)hs.getAttribute("udt");
    header a = new header(hs,request);
    ArrayList items = new ArrayList();
    ArrayList<HashMap> item2 = new ArrayList<HashMap>();
    items = (ArrayList)request.getAttribute("cartItems");
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録情報を更新</title>
    </head>
    <body>
                <%=a.getHeaderMessage()%>
        <h1>登録情報を更新</h1>
        <hr>
        <form action="Myupdateresult" method="post">
                      <tr>
                          <th>ユーザ名</th>
                          <td><input type="text" name="name" value="<%=udt.getName()%>" size="24"></td>
                      </tr>
                      <tr>
                          <th>パスワード</th>
                          <td>
                              <input type="password" name="password" value="<%=udt.getPassword()%>" size="24">
                          </td>
                      </tr>
                      <tr>
                          <th>
                              メールアドレス
                          </th>
                          <td>
                              <input type="text" name="mail" value="<%=udt.getMail()%>" size="24">
                          </td>
                      </tr>
                       <tr>
                          <th>
                              住所
                          </th>
                          <td>
                              <input type="text" name="adress" value="<%=udt.getAdress()%>" size="24">
                          </td>
                      </tr>
                      <tr>
                          <td colspan="2">
                              <input type="submit" value="登録情報を更新">
                              <input type="hidden" name="url" value="<%=request.getParameter("page")%>">
                      </tr>        
                  </form>
    </body>
</html>
