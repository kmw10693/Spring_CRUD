package com.umc.kevin.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class GetUserRes {
    private int userIdx;
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

}
