import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

public class java13 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            class Common {
                protected String userName ="";
                protected String submitStatus1 ="";
                protected String submitStatus2 ="";
                protected String submitStatus3 ="";
                protected String submit="";
                protected String sessionName = "";
                protected ResultSet db_data = null;
                protected HttpSession hs = request.getSession();
                protected HttpServletRequest cRequest=request; 
                protected PreparedStatement db_st = null;
                protected Connection db_con = null;
                Common(){
                 sessionName =(String)this.hs.getAttribute("loginUser");
            }
                public void getSubmitParameters(){
                    try{
                    request.setCharacterEncoding("UTF-8");}
                    catch(Exception e){
                        
                    }

                    this.submitStatus1 =   cRequest.getParameter("name");
                    this.submitStatus2 =   cRequest.getParameter("pass");
                    this.submitStatus3 =   cRequest.getParameter("state");
                    this.submit =   cRequest.getParameter("submit");
                }
                public void mysqlConnect(){
                    try {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();  
                        this.db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db", "root", "root");
                    }catch(Exception e){
                        out.print("f");
                    }
                }
                public String loginNameCheck(){
                    return (String)this.hs.getAttribute("loginUser");
                }
            }
            class whileLogout extends Common {
                public void checkLoginDatabase(){//submitしたnameとpassをデータベースで判定
                    try {
                    this.db_st = this.db_con.prepareStatement("SELECT * FROM user_data  WHERE name = ? and password = ?;");
                    this.db_st.setString(1,this.submitStatus1 );
                    this.db_st.setString(2,this.submitStatus2 );
                    this.db_data = this.db_st.executeQuery();
                    if(this.db_data.next()){
                        this.sessionName = this.db_data.getString("name") ;
                        out.print("ログイン成功");
                    }
                    this.setSessionName();
                    this.db_st.close();
                    this.db_con.close();
                    }catch (Exception e){
                        out.print(e.getMessage());
                    }
                }
                public void setSessionName(){
                    this.hs.setAttribute("loginUser", this.sessionName);
                }
                public void writeLogoutHTML(){
                    out.println("<!DOCTYPE html><html><head><title>session</title></head><body>");
                    out.println(" <form action=\"./java13\" method=\"get\"><input type=\"hidden\" name=\"state\" value=\"out\">"
                    + "name<input type=\"text\" name=\"name\" >pass<input type=\"password\" name=\"pass\" ><input type=\"submit\" name=\"submit\" value=\"login\">");
                    out.println("</form></body>");
                    out.println("</html>");
                }
            }
            class whileLogin extends Common {
                public void methodChoose(){
                    if(this.submit.equals("logout")){
                        this.logout();
                    }else if(this.submit.equals("show")){
                        this.getGoods();
                    }else if(this.submit.equals("add")){
                        this.addGoods();
                    }
                }
                public void logout(){
                    this.hs.setAttribute("loginUser", null);
                }
                public void getGoods(){
                    try {
                    this.db_st = db_con.prepareStatement("SELECT * FROM shohin_data;");
                    this.db_data = this.db_st.executeQuery();
                    out.print("商品一覧<br>");
                    while(db_data.next()){
                        out.print("名前：" + db_data.getString("name") + "<br>");
                    }
                    this.db_st.close();
                    this.db_con.close();
                    }catch (Exception e){
                        out.print("^^");
                    }
                }
                public void addGoods(){
                    try {
                    this.db_st = db_con.prepareStatement("insert into shohin_data (name) values (?);");
                    this.db_st.setString(1,this.submitStatus1 );
                    this.db_st.execute();
                    this.db_st.close();
                    this.db_con.close();
                    }catch (Exception e){
                        out.print("^^");
                    }
                }
                public void writeLoginHTML(String sessionName){
                    out.println("<!DOCTYPE html><html><head><title>session</title></head><body>");
                    out.println(sessionName+"がログイン");
                    out.println(" <form action=\"./java13\" method=\"get\">商品登録:商品名<input type=\"text\" name=\"name\" ><input type=\"submit\" name=\"submit\" value=\"add\"><br>");
                    out.println(" 商品一覧<input type=\"submit\" name=\"submit\" value=\"show\"><br><input type=\"submit\" name=\"submit\" value=\"logout\"><input type=\"hidden\" name=\"state\" value=\"in\">");
                    out.println("</form></body>");
                    out.println("</html>");
                }
            }
            
            try {
                Common c = new Common();
                c.getSubmitParameters();
                whileLogout a = new whileLogout();//非ログイン時の処理
                whileLogin b = new whileLogin();//ログイン時の処理
                if(c.submitStatus3!=null){
                if(c.submitStatus3.equals("in")){
                   b.getSubmitParameters();
                   b.mysqlConnect();
                   b.methodChoose();
                }else if(c.submitStatus3.equals("out")){
                   a.getSubmitParameters();
                   a.mysqlConnect();
                   a.checkLoginDatabase();
                }}
                if(c.loginNameCheck() == null){
                    a.writeLogoutHTML();
                }else{
                    b.writeLoginHTML(c.loginNameCheck());
                }

              
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


