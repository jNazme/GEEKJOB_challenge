

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class blackjack extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            abstract class Human{
                public int open(){
                    int sum =0 ;
                    for(int value:this.myCards){
                        if(value > 10){
                                value = 10;
                            }
                            sum += value;
                        }
                    return sum;
                }
                public void  setCard(ArrayList<Integer> list){
                    for (int value:list){
                        this.myCards.add(value);
                    }
                }
                public boolean checkSum(){
                    int sum= 0;
                        for(int value:this.myCards){
                            if(value > 10){
                                value = 10;
                            }
                            sum += value;
                        }
                        return (sum < 17);
                }
                ArrayList<Integer> myCards = new ArrayList<Integer>();
            }
            class Dealer extends Human{
                    ArrayList<Integer> cards = new ArrayList<Integer>();
                    Dealer() {
                        for(int i=1;i<=13;i++){
                            for(int j=0;j<4;j++){
                                this.cards.add(i);
                            }
                        }
                    }
                    public ArrayList<Integer> deal(){
                        Random rnd = new Random();
                        ArrayList<Integer> cardsDealt = new ArrayList<Integer>();
                        for(int j=0;j<2;j++){
                                int ran = rnd.nextInt(this.cards.size());
                                cardsDealt.add(this.cards.get(ran));
                                this.cards.remove(ran);
                            }
                        return cardsDealt;
                    }
                    public ArrayList<Integer> hit(){
                        Random rnd = new Random();
                        ArrayList<Integer> cardsDealt = new ArrayList<Integer>();
                        int ran = rnd.nextInt(this.cards.size());
                        cardsDealt.add(this.cards.get(ran)); 
                        this.cards.remove(ran);
                           
                        return cardsDealt;
                    }
            }
            class User extends Dealer{
                
            }
             out.print("ブラックジャック<br>");

             Dealer oya = new Dealer();
             User ko = new User();
             oya.setCard(oya.deal());
             ko.setCard(oya.deal());
             out.print("ディーラー"+oya.open()+"<br>");
             out.print("プレイヤー"+ko.open()+"<br>");
             while (oya.checkSum()){
                     oya.setCard(oya.hit());
                     out.print("ディーラー"+oya.open()+"<br>");
             }
             while (ko.checkSum()){
                     ko.setCard(ko.hit());
                     out.print("プレイヤー"+ko.open()+"<br>");
             }
             out.print("終了<br>");
             if(ko.open()>21){
                 out.print("ディーラーの勝ち");
             }else if(oya.open()>21){
                 out.print("プレイヤーの勝ち");
             }else if(ko.open()>oya.open()){
                 out.print("プレイヤーの勝ち");
             }else{
                 out.print("ディーラーの勝ち");
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
