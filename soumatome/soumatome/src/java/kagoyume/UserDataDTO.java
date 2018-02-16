package kagoyume;

import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;


public class UserDataDTO {
    private int userID;
    private String name;
    private String password;
    private Date birthday;
    private String mail;
    private int total;
    private String adress;
    private Timestamp newDate;
    private ArrayList cart;
    private boolean login;
    private String search;
    public boolean getLogin(){
        return this.login;
    }
    public void setLogin(boolean login){
        this.login = login;
    }
    
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getSearch() {
        return search;
    }
    public void setSearch(String search) {
        this.search = search;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public Date getBirthday(){
        return birthday;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
    
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    
    public int getTotal(){
        return this.total;
    }
    public void setTotal(int total){
        this.total = total;
    }
    
    public String getAdress(){
        return adress;
    }
    public void setAdress(String adress){
        this.adress = adress;
    }
    
    public Timestamp getNewDate() {
        return newDate;
    }
    public void setNewDate(Timestamp newDate) {
        this.newDate = newDate;
    }
    public ArrayList getCart() {
        return this.cart;
    }
    public void setCart(ArrayList cart) {
        this.cart = cart;
    }
    public void addCart(HashMap item){
        this.cart.add(item);
    }

}
