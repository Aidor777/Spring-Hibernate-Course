package com.lovetocode.springsecurity.demo.service.impl;

import com.lovetocode.springsecurity.demo.dao.RoleDao;
import com.lovetocode.springsecurity.demo.dao.UserDao;
import com.lovetocode.springsecurity.demo.model.CrmUser;
import com.lovetocode.springsecurity.demo.model.RoleEnum;
import com.lovetocode.springsecurity.demo.model.entity.Role;
import com.lovetocode.springsecurity.demo.model.entity.User;
import com.lovetocode.springsecurity.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    @Transactional
    public void save(CrmUser crmUser) {
        var user = new User();
        user.setUserName(crmUser.getUserName());
        user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
        user.setFirstName(crmUser.getFirstName());
        user.setLastName(crmUser.getLastName());
        user.setEmail(crmUser.getEmail());

        // Give user default role of "employee"
        var roles = new LinkedList<Role>();
        Role employeeRole = roleDao.findByName(RoleEnum.EMPLOYEE.toSecurityRole());
        roles.add(employeeRole);

        if (!RoleEnum.EMPLOYEE.toSecurityRole().equals(crmUser.getRole())) {
            roles.add(roleDao.findByName(crmUser.getRole()));
        }
        user.setRoles(roles);

        userDao.save(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        var user = userDao.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet()));
    }

}
