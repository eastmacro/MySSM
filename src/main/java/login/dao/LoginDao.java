package login.dao;

import domain.LoginLog;
import domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by Rujiao Xiong on 2017/4/7.
 */
@Repository
public class LoginDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String emailAddress,String password) {
        String sql = "select count(*) from user where emailAddress = ? and password = ?";
        //SqlRowSet rowSet =  jdbcTemplate.queryForRowSet(sql, new Object[]{userName,password});
        return jdbcTemplate.queryForObject(sql, Integer.class, emailAddress, password);
    }


    public User getByUserEmail(final String emailAddress) {
        String sqlStr = "select * from user where emailAddress = ?";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{emailAddress},
                new RowCallbackHandler(){

                    public void processRow(ResultSet resultSet) throws SQLException {
                        user.setUsername(resultSet.getString("username"));
                        user.setId(resultSet.getInt("id"));
                        user.setCredits(resultSet.getInt("credits"));
                    }
                });
        return user;
    }

    public void updateLoginInfo(User user) {
        String sql = "update user set lastVisitTime=?,lastIp=?,credits=? where id = ?";
        jdbcTemplate.update(sql,new Object[]{user.getLastVisitTime(),user.getLastIP(),user.getCredits(),user.getId()});
    }


    public void insertLoginLog(LoginLog loginLog) {
        String sql = "insert into login_log (user_id,ip,login_datetime) values(?,?,?)";
        Object[] args = {loginLog.getUserId(),loginLog.getIP(),loginLog.getLoginDate()};;
        jdbcTemplate.update(sql,args);
    }


    public List<User> getAllUsers() {
        String sql = "select * from user ";
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
        List<User> users = jdbcTemplate.query(sql, rowMapper);
        return users;
    }


    public User getUserById(int id) {
        String sql = "select * from user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, User.class);
        return user;
    }
}
