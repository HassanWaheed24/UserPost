package com.task.user.response;

import com.task.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

    private String respCode;
    private String respDes;
    private Long id;
    private String title;
    private String content;
    private Date createdDate;
    private Date updatedDate;
    private String status;
    private User author;

    public PostResponse(String respCode, String respDes) {
        this.respCode = respCode;
        this.respDes = respDes;
    }
}
