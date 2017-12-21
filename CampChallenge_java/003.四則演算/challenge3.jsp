<%-- 
    Document   : challenge2-2
    Created on : 2017/12/21, 14:30:16
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
        <%

final int CONST = 14;
int var = 6;
int sum = CONST + var;
int sub = CONST - var;
int mul = CONST * var;
int div = CONST / var;
out.print(sum+","+sub+","+mul+","+div);

%>
    </body>
</html>
