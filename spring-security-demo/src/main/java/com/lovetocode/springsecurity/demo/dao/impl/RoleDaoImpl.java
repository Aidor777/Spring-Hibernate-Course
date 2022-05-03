package com.lovetocode.springsecurity.demo.dao.impl;

import com.lovetocode.springsecurity.demo.dao.RoleDao;
import com.lovetocode.springsecurity.demo.model.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role findByName(String name) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();

            Query<Role> query = currentSession.createQuery("from Role where name = :name", Role.class);
            query.setParameter("name", name);

            return query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

}
