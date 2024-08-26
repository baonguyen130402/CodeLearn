package com.env.gs.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Date;

@Document(collection = "tb_comment")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @Field(name = "CommentId")
    private Integer commentId;
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
