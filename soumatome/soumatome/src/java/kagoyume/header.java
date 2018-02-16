/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author jun
 */
public class header {
    public header(HttpSession hs,HttpServletRequest hsr){
        UserDataDTO udt = new UserDataDTO();
        if (hs.getAttribute("udt") instanceof UserDataDTO) {
            udt = (UserDataDTO)hs.getAttribute("udt");
        }
        this.setCurrentPath(hsr);
        if(udt == null){
            this.headerMessage = this.showHeaderLogout();
        }else{
        if(this.loginCheck(udt)){
            this.headerMessage = this.showHeaderLogin();
        }else{
            this.headerMessage = this.showHeaderLogout();
        }
        }
    }
    private String headerMessage="";
    private String pageURL ="";
    final private String myURL="mydata.jsp";
    final private String cartURL = "Cart";
    final private String loginURL = "login.jsp";
    final private String indexURL = "index.jsp";
    private String userName = "";    
    public void setCurrentPath(HttpServletRequest hsr){
        this.pageURL = this.whetherReturnItsPage(this.pageURL);
        this.pageURL = hsr.getServletPath().substring(1);
        if(this.checkURLifNeedServlet(this.pageURL)){
            this.pageURL=this.correctURL(this.pageURL);
        }
    }
    public boolean checkURLifNeedServlet(String URL){
        if(URL.equals("cart.jsp")){
         return true;
        }
        return false;
        
    }
    public String whetherReturnItsPage(String URL){
        if(URL.equals("cart.jsp")||URL.equals("search.jsp")){
            return URL;
        }
        return "index.jsp";
    }
    public String correctURL(String URL){
        URL = URL.substring(0, 1).toUpperCase() + URL.substring(1);
        int _len = URL.length();
        URL = URL.substring(0,_len-4);
        return URL;
    }
    public String showHeaderLogin(){
        return "<a href='"+this.indexURL+"'>TOPページ</a>&nbsp;<a href='"+this.myURL+"'>"+this.userName+"</a>がログインしています。<a href='"+this.cartURL+"?page="+this.pageURL+"&log=in'>カートへ移動</a>  <a href='"+this.loginURL+"?page="+this.pageURL+"&log=out'>ログアウト</a>";
    }
    public String showHeaderLogout(){
        return "<a href='"+this.indexURL+"'>TOPページ</a>   <a href='"+this.loginURL+"?page="+this.pageURL+"&log=in'>ログイン/新規登録</a>";
    }
    public boolean loginCheck(UserDataDTO udt){
        if(udt.getName()==null){
            return false;
        }else{
            this.userName =udt.getName();
            return true;
        }
    }
    public String getHeaderMessage(){
        return this.headerMessage;
    }
    
}

