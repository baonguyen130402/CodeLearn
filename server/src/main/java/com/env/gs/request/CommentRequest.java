package com.env.gs.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {

    @Field(name = "UserId")
    private Integer userid;
    @Field(name = "PostId")
    private Integer postId;
    @Field(name = "UpdateDate")
    private Date updateDate;
    @Field(name = "CreateDate")
    private Date createDate;
    @Field(name = "Content")
    private String content;
}
