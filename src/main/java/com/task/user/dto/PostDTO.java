package com.task.user.dto;

import com.task.user.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private Date createdDate;
    private Date updatedDate;
    private String status;

    private User user;
}
