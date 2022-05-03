package com.lovetocode.springsecurity.demo.service;

import com.lovetocode.springsecurity.demo.model.CrmUser;
import com.lovetocode.springsecurity.demo.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);

}
