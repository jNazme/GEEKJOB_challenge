

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 



public class db2 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Connection db_con = null;
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();  
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db", "root", "root");
                PreparedStatement db_st = null;
                //入力するメンバー情報
                int ID = 6;
                String name = "藤田 篤史";
                String tel ="090-1722-8672";
                int age = 28;
                String strDate = "1989/06/16";
                
                //
                SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date date = sdFormat.parse(strDate);
                db_st = db_con.prepareStatement("INSERT INTO test_table(profilesID , name,tel,age,birthday) VALUES (?,?,?,?,?);");
                java.sql.Date d = new java.sql.Date(date.getTime());
                db_st.setInt(1, ID);
                db_st.setString(2,name);
                db_st.setString(3,tel);
                db_st.setInt(4, age);
                db_st.setDate(5, d);
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
