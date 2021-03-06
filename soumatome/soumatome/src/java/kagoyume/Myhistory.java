
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


public class Myhistory extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            HttpSession hs = request.getSession();
            UserDataDTO udt;
            udt = (UserDataDTO)hs.getAttribute("udt");
            ArrayList purchasedItemIDs = new ArrayList();
            purchasedItemIDs = UserDataDAO .getInstance().getPurchasedItem(udt.getUserID());
            ArrayList purchasedItems = new ArrayList();
            String contents = purchasedItemIDs.toString();
                            int e = purchasedItemIDs.size();
                            
            for (int i = 0;i < e;i++) {
                    String d = (String)purchasedItemIDs.get(i);
                    purchasedItems.add(xmlReader.getXMLFromHttp(Boolean.FALSE , d));
                }
            request.setAttribute("cartItems", purchasedItems);
            request.getRequestDispatcher("/myhistory.jsp").forward(request, response);  
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