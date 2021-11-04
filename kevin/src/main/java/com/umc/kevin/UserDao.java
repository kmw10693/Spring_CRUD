package com.umc.kevin;

import com.umc.kevin.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<GetUserRes> userRes(){
        return this.jdbcTemplate.query("Select * from User",
                (rs, rowNum) -> new GetUserRes(
                        rs.getInt("userIdx"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("phoneNum"),
                        rs.getString("grade"),
                        rs.getString("email"),
                        rs.getString("profileUrl"),
                        rs.getString("mailReceive"),
                        rs.getString("smsReceive"),
                        rs.getString("status"),
                        rs.getString("address"))




        );
    }

    public int addUser(PostUserReq postuserReq){
        String createUserQuery = "insert into User (name, password, phoneNum, grade, email, profileUrl, mailReceive, smsReceive, status, address) VALUES (?,?,?,?,?,?,?,?,?,?)";
        Object[] createUserParams = new Object[]{
                postuserReq.getName(), postuserReq.getPassword(), postuserReq.getPhoneNum(), postuserReq.getGrade(), postuserReq.getEmail(), postuserReq.getProfileUrl(), postuserReq.getMailReceive(), postuserReq.getSmsReceive(), postuserReq.getStatus(), postuserReq.getAddress()
        };
        this.jdbcTemplate.update(createUserQuery, createUserParams);

        return this.jdbcTemplate.queryForObject("select last_insert_id()",int.class);
    }
}