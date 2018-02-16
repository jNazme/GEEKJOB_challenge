/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import base.DBManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jun
 */
public class UserDataDAO {
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    public UserDataDTO login(String name,String password) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            UserDataDTO resultUd = new UserDataDTO();
            con = DBManager.getConnection();
            String sql = "SELECT * FROM user_t WHERE name=? and password=?";
            st =  con.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, password);
            ResultSet rs = st.executeQuery(); 
            boolean result = rs.next();
            if (result && rs.getInt("deleteFlg")==0) {
                resultUd.setUserID(rs.getInt("userID"));
                resultUd.setName(rs.getString("name"));
                resultUd.setPassword(rs.getString("password"));
                resultUd.setNewDate(rs.getTimestamp("newDate"));
                resultUd.setMail(rs.getString("mail"));
                resultUd.setAdress(rs.getString("adress"));
                resultUd.setTotal(rs.getInt("total"));
                resultUd.setLogin(true);
            } else {
                resultUd.setLogin(false);
            }
            return resultUd;
        }catch(SQLException e){
            System.out.println("エラー"+e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    public UserDataDTO register(String name,String password ,String mail,String adress) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            String sql = "INSERT INTO `user_t` (`userID`, `name`, `password`, `mail`, `adress`, `total`, `newDate`, `deleteFlg`) VALUES (NULL, ?, ?, ?, ?, '0', ?, '0')";
            st =  con.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, password);
            st.setString(3, mail);
            st.setString(4, adress);
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            return this.login(name, password);
        }catch(SQLException e){
            System.out.println("エラー"+e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    public void delete(int userID) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            String sql = "UPDATE `user_t` SET `deleteFlg` = 1 WHERE userID = ?";
            st =  con.prepareStatement(sql);
            st.setInt(1, userID);
            st.executeUpdate(); 
        }catch(SQLException e){
            System.out.println("エラー"+e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    public void update(String name,String password ,String mail,String adress,int userID) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            UserDataDTO resultUd = new UserDataDTO();
            con = DBManager.getConnection();
            String sql = "UPDATE `user_t` SET `name` = ?,`password` = ?,`mail` = ?,`adress` = ? WHERE userID = ?";
            st =  con.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, password);
            st.setString(3, mail);
            st.setString(4, adress);
            st.setInt(5, userID);
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println("エラー"+e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    public void purchase(int userID,String itemCode,String type) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            UserDataDTO resultUd = new UserDataDTO();
            con = DBManager.getConnection();
            String sql = "INSERT INTO `buy_t` (`buyID`, `userID`, `itemCode`, `type`, `buyDate`) VALUES (NULL, ?, ?, ?, ?)";
            st =  con.prepareStatement(sql);
            st.setInt(1, userID);
            st.setString(2, itemCode);
            st.setString(3, type);
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println("エラー"+e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    public ArrayList getPurchasedItem(int userID) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            ArrayList items = new ArrayList();
            UserDataDTO resultUd = new UserDataDTO();
            con = DBManager.getConnection();
            String sql = "SELECT * FROM buy_t WHERE userID = ?";
            st =  con.prepareStatement(sql);
            st.setInt(1, userID);
            ResultSet rs = st.executeQuery(); 
            while (rs.next()) {
                items.add(rs.getString("itemCode"));
            }
            return items;
        }catch(SQLException e){
            System.out.println("エラー"+e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
}
