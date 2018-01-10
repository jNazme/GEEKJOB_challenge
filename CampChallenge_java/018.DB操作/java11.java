
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
 



public class java11 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html><head><title>session</title></head><body>");
            out.println(" <form action=\"./java11\" method=\"get\">"
                    + "ID<input type=\"number\" name=\"profilesID\" >name<input type=\"text\" name=\"name\" >tel<input type=\"text\" name=\"tel\" >age<input type=\"number\" name=\"age\" >birthday<input type=\"text\" name=\"birthday\" ><input type=\"submit\" name=\"submit\">");
            out.println("</form></body>");
            out.println("</html>");
            Connection db_con = null;
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();  
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db", "root", "root");
                PreparedStatement db_st = null; 
                request.setCharacterEncoding("UTF-8");
                int ID =   Integer.parseInt(request.getParameter("profilesID"));
                int age =   Integer.parseInt(request.getParameter("age"));
                String tel =   request.getParameter("tel");
                String birthday =   request.getParameter("birthday");
                String name =   request.getParameter("name");
                db_st = db_con.prepareStatement("INSERT INTO test_table (profilesID,name, age, tel, birthday)  VALUES (?, ?,?,?,?);");
                db_st.setInt(1,ID );
                db_st.setString(2,name );
                db_st.setInt(3,age );
                db_st.setString(4,tel );
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date formatDate = sdf.parse(birthday);
                java.sql.Date d2 = new java.sql.Date(formatDate.getTime());
                db_st.setDate(5,d2 );
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