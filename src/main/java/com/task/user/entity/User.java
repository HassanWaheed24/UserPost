package com.task.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="[user]")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @Column(name ="user_id",updatable = false, nullable = false)
    private Long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "gender")
    private String gender;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address_street")
    private String addressStreet;
    @Column(name = "address_city")
    private String addressCity;
    @Column(name = "address_state_province")
    private String addressStateProvince;
    @Column(name = "address_postal_code")
    private String addressPostalCode;
    @Column(name = "address_country")
    private String addressCountry;
    @Column(name = "profile_picture_url")
    private String profilePictureUrl;
    @Column(name = "role")
    private String role;
    @Column(name = "registration_date")
    private Date registrationDate;
    @Column(name = "last_login_date")
    private Date lastLoginDate;
    @Column(name = "status")
    private String status;
    @Column(name = "user_block")
    private String block;

    @OneToMany(mappedBy = "author")
    private List<Post> posts = new ArrayList<>();
}
