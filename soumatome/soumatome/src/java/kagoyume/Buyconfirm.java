
package kagoyume;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.HashMap;


public class Buyconfirm extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Cookie[] cs = request.getCookies();
            HttpSession hs = request.getSession();
            UserDataDTO udt;
            udt = (UserDataDTO)hs.getAttribute("udt");
            ArrayList cartItems = new ArrayList();
            if (cs != null) {
                for (int i = 1;i< cs.length;i++) {
                    String itemName =cs[i].getValue();
                    String j = cs[i].getName().substring(6);
                    if (j.equals(String.valueOf(udt.getUserID())) && !(itemName.equals(""))) {
                        cartItems.add(xmlReader.getXMLFromHttp(Boolean.FALSE , cs[i].getValue()));
                    }
                }
            }
            request.setAttribute("cartItems", cartItems);
            request.getRequestDispatcher("/buyconfirm.jsp").forward(request, response);  
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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