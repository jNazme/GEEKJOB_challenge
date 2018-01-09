import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class session2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        HttpSession hs = request.getSession();
        String name = (String)hs.getAttribute("name");
        String gender = (String)hs.getAttribute("sex");
        String hobby = (String)hs.getAttribute("hobby");
             out.println("<!DOCTYPE html><html><head><title>session</title></head><body>");
            out.println(" <form action=\"./session2\" method=\"get\">"
                    + "<input type=\"text\" name=\"name\" value=\""+name+"\">"
                    + "<input type=\"text\" name=\"sex\" value=\""+gender+"\">"
                    + "<input type=\"text\" name=\"hobby\" value=\""+hobby+"\">"
                    + "<input type=\"submit\" name=\"submit\">");
            out.println("</form></body>");
            out.println("</html>");
        request.setCharacterEncoding("UTF-8");
        hs.setAttribute("name", request.getParameter("name"));
        hs.setAttribute("sex", request.getParameter("sex"));
        hs.setAttribute("hobby", request.getParameter("hobby"));
       
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}