<%
request.setCharacterEncoding("UTF-8");
out.print(request.getParameter("name"));
out.print(request.getParameter("male"));
out.print(request.getParameter("female"));
out.print(request.getParameter("hobby"));
%>