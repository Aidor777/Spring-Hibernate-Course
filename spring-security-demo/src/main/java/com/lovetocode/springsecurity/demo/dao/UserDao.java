package com.lovetocode.springsecurity.demo.dao;

import com.lovetocode.springsecurity.demo.model.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User user);

}
