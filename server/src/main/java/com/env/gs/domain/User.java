package com.env.gs.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "m_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Field(name = "userId")
    private Integer userId;
    @Field(name = "userName")
    private String fullName;
    @Field(name = "email")
    private String email;
    @Field(name = "password")
    private String password;
    @Field(name = "roleId")
    private Integer roleId;
}
