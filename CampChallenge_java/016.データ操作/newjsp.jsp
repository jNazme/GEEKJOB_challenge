<%-- 
    Document   : newjsp
    Created on : 2018/01/05, 16:15:00
    Author     : jun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="./newjsp.jsp" method="get">
      <!-- formタグで括られた入力項目はこれら -->
      <input type="text" name="type">
      <input type="checkbox" name="chkTest">
      <input type="radio" name="rdoSample">
      <input type="button" name="btnTest">
      <input type="submit" name="btnSubmit">
      <select name="cmbList"></select>
      <textarea name="mulText"></textarea>
      <%
          request.setCharacterEncoding("UTF-8");
          String type = "";
          switch (request.getParameter("txtName")){
              case "1" :
                  type ="雑貨";
    break;
  case "2":
    type ="生鮮食品";
    break;
    case "3":
    type ="その他";
    break;
        }
          out.print("種類"+type);
          String total = request.getParameter("total");
          int totalInt = Integer.parseInt(total);
          String count = request.getParameter("count");
          int countInt = Integer.parseInt(total);
          out.print("一個あたりの数"+(totalInt/countInt));
          double point =0;
          if (totalInt>5000){
              point  = totalInt * 0.05;
          } else if(totalInt>3000){
              point = totalInt * 0.04;
          }
          out.print(point+"ポイント");
      %>
    </form>
        
    </body>
</html>
