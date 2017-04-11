package domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Rujiao Xiong on 2017/4/7.
 */
public class User implements Serializable{

    private int id;
    private String username;
    private String emailAddress;
    private String password;
    private String gender;
    private int credits;
    private String lastIP;
    private Date lastVisitTime;


    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }


    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    public String getLastIP() {
        return lastIP;
    }
    public void setLastIP(String lastIP) {
        this.lastIP = lastIP;
    }

    public Date getLastVisitTime() {
        return lastVisitTime;
    }
    public void setLastVisitTime(Date lastVisitTime) {
        this.lastVisitTime = lastVisitTime;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", credits=" + credits
                + ", lastIP=" + lastIP + ", lastVisit=" + lastVisitTime + "]";
    }



}
