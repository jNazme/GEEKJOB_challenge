/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;
import java.io.Serializable;


/**
 *
 * @author jun
 */
public class UserDataBeans implements Serializable {
    void TestBeans() {}
    private String name = "";
    private String month = "";
    private String day = "";
    private String type = "";
    private String tell = "";
    private String comment ="";
    private String year ="";
    public String getName() { return this.name; }
    public void setName(String n) { this.name = n; }
    public String getMonth() { return this.month; }
    public void setMonth(String n) { this.month = n; }
    public String getDay() { return this.day; }
    public void setDay(String n) { this.day = n; }
    public String getType() { return this.type; }
    public void setType(String n) { this.type = n; }
    public String getYear() { return this.year; }
    public void setYear(String n) { this.year = n; }
    public String getTell() { return this.tell; }
    public void setTell(String n) { this.tell = n; }
    public String getComment() { return this.comment; }
    public void setComment(String n) { this.comment = n; }
}
