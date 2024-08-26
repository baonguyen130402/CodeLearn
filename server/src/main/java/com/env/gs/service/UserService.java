package com.env.gs.service;

import com.env.gs.domain.User;
import com.env.gs.request.UserCreateRequest;

import java.util.List;

public interface UserService {

    User findUserByName(String email);
    List<User> getAll();
    User addUser(UserCreateRequest request);
}
