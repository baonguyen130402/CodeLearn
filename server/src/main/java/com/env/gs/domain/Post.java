package com.env.gs.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Date;
import java.util.List;

@Document(collection = "tb_post")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @Field(name = "_id")
    private String postId;
    @Field(name = "userId")
    private Integer userId;
    @Field(name = "title")
    private String title;
    @Field(name = "desc")
    private String desc;
    @Field(name = "hashtag")
    private List<String> hashtag;
    @Field(name = "thumbnailUrl")
    private String thumbnailUrl;
}
