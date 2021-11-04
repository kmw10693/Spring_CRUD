package com.umc.kevin.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@JsonAutoDetect
public class PostUserReq {
    private String name;
    private String password;
    private String phoneNum;
    private String grade;
    private String email;
    private String profileUrl;
    private String mailReceive;
    private String smsReceive;
    private String status;
    private String address;
    public PostUserReq()
    {

    }
}
