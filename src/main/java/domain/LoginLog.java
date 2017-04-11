package domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Rujiao Xiong on 2017/4/7.
 */
public class LoginLog implements Serializable {

    private int id;
    private int userId;
    private String IP;
    private Date loginDate;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getIP() {
        return IP;
    }
    public void setIP(String iP) {
        IP = iP;
    }
    public Date getLoginDate() {
        return loginDate;
    }
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }





}
