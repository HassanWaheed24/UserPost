package com.task.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String respCode;
    private String respDes;
    private Long userId;
    private String userName;
    private String email;
    private String password;
    private String name;
    private Date dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String addressStreet;
    private String addressCity;
    private String addressStateProvince;
    private String addressPostalCode;
    private String addressCountry;
    private String profilePictureUrl;
    private String role;
    private Date registrationDate;
    private Date lastLoginDate;
    private String status;
    private String block;
}
