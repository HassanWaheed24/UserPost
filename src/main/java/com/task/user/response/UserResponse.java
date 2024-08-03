package com.task.user.response;


import com.task.user.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

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

    private List<PostDTO> posts;

    public UserResponse(String respCode, String respDes) {
        this.respCode = respCode;
        this.respDes = respDes;
    }
}
