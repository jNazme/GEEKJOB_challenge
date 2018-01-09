<%-- 
    Document   : newjsp
    Created on : 2018/01/05, 16:15:00
    Author     : jun
--%>
<%@ page import="java.util.ArrayList" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <%
          request.setCharacterEncoding("UTF-8");
          String string = request.getParameter("number");
          int number = Integer.parseInt(string);
          out.print("元の値"+number+", 1桁の素因数");
          int[] prime = {2,3,5,7};
          ArrayList<Integer> youso = new ArrayList<Integer>();
          while(true){
              if(number%2==0){
                  number /= 2;
                  out.print("2");
              }else if(number%3==0){
                  number /= 3;
                  out.print("3");
              }else if(number%5==0){
                  number /= 5;
                  out.print("5");
              }else if(number%7==0){
                  number /= 7;
                  out.print("7");
              }else{
                  break;
              }
          }
          if (number > 1){
              out.print(", 余った値"+number);
          }
          
          
      %>        
    </body>
</html>
