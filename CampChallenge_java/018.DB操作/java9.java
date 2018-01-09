import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
 



public class java9 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html><head><title>session</title></head><body>");
            out.println(" <form action=\"./java9\" method=\"get\">"
                    + "ID<input type=\"number\" name=\"id\" ><input type=\"submit\" name=\"submit\">");
            out.println("</form></body>");
            out.println("</html>");
            Connection db_con = null;
            try {
                request.getParameter("id");
                Class.forName("com.mysql.jdbc.Driver").newInstance();  
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db", "root", "root");
                PreparedStatement db_st = null; 
                int id =   Integer.parseInt(request.getParameter("id"));
                db_st = db_con.prepareStatement("DELETE FROM test_table  where profilesID = ?");
                db_st.setInt(1,id );
                db_st.execute();
                db_st.close();
                db_con.close();
            }catch(Exception e){
                out.println(e.getMessage());
            }
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