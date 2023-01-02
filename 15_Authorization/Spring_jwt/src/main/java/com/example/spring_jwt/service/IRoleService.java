package com.example.spring_jwt.service;

import com.example.spring_jwt.model.Role;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
