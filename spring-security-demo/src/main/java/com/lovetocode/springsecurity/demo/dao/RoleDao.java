package com.lovetocode.springsecurity.demo.dao;

import com.lovetocode.springsecurity.demo.model.entity.Role;

public interface RoleDao {

    Role findByName(String name);

}
