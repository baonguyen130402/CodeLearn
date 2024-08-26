package com.env.gs.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {
    @Field("UserName")
    private String fullName;
    @Field("Email")
    private String email;
    @Field("Password")
    private String password;
    @Field("RoleId")
    private Integer roleId;
}
