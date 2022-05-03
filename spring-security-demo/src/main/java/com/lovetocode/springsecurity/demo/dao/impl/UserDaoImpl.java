package com.lovetocode.springsecurity.demo.dao.impl;

import com.lovetocode.springsecurity.demo.dao.UserDao;
import com.lovetocode.springsecurity.demo.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findByUserName(String userName) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();

            Query<User> query = currentSession.createQuery("from User where userName = :userName", User.class);
            query.setParameter("userName", userName);

            return query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public void save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

}
