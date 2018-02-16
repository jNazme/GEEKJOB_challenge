package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kagoyume.xmlReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;
import kagoyume.UserDataDTO;
import kagoyume.header;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession hs = request.getSession();
    header a = new header(hs,request); 
    
    
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <style>\n");
      out.write("        div.Item img{\n");
      out.write("    border: none;\n");
      out.write("    float: left;\n");
      out.write("    clear: both;\n");
      out.write("    margin: 5px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("div.Item p{\n");
      out.write("    height: 146px;\n");
      out.write("    \n");
      out.write("    line-height:120%;\n");
      out.write("    font-size:90%;\n");
      out.write("    overflow:hidden;\n");
      out.write("    color:#808080;\n");
      out.write("\n");
      out.write("}\n");
      out.write("    </style>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("        <title>検索結果</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.print(a.getHeaderMessage());
      out.write("\n");
      out.write("        <h1>検索結果</h1>\n");
      out.write("        <h2>\n");
      out.write("            ");

                out.print("キーワード:検索数:");
            
      out.write("</h2>\n");
      out.write("        <hr>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");
 
           ArrayList<HashMap> items = new ArrayList<HashMap>();
           items = xmlReader.getXMLFromHttp(Boolean.TRUE,"mtg");
           
            for (int i=0;i<items.size()&&i<10;i++){
                HashMap item = items.get(i);
                
        
      out.write("\n");
      out.write("        <div class=\"Item\">\n");
      out.write("            <a href=\"");
 out.print("item.jsp?id="+item.get("ID")+"&price="+item.get("Price")+"&name="+item.get("Name")+"&image="+item.get("Image"));
      out.write("\">\n");
      out.write("                <img src=\"");
 out.print(item.get("Image"));
      out.write("\" />");
 out.print(item.get("Name"));
      out.write("</a>\n");
      out.write("                <p class=\"price\">\n");
      out.write("                ");
 out.print(item.get("Price")+"円");
      out.write("                <a href=\"");
 out.print("Add?id="+item.get("ID")+"&price="+item.get("Price")+"&name="+item.get("Name")+"&image="+item.get("Image"));
      out.write("\">カートに加える</a>\n");
      out.write("</p>\n");
      out.write("        </div>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
