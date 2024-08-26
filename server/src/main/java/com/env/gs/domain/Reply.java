package com.env.gs.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tb_reply")
public class Reply {
    @Id
    private Integer ReplyId;
    private Integer userId;
    private Integer commentId;
    private String content;
}
