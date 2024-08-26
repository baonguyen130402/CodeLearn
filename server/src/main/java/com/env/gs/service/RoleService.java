package com.env.gs.service;

import com.env.gs.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    Role getById(Integer id);
}
