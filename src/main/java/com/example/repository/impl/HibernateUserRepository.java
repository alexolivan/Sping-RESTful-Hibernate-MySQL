/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.repository.impl;

import com.example.domain.User;
import com.example.repository.UserRepository;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alex
 */
@Transactional
@Repository
public class HibernateUserRepository implements UserRepository {
    
    @Autowired
    private SessionFactory sessionFactory;
       
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    } 
    
    private Criteria createEntityCriteria() {
        return getSession().createCriteria(User.class);
    }     

    @Override
    public List<User> getAll() {        
        String hql = "from User";
        Query query = getSession().createQuery(hql);        
        return query.list();
    }

    @Override
    public User getUserById(int userID) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("userID", userID));
        List<User> users = (List<User>) criteria.list();
        return users.get(0);
    }
    
    @Override
    public User getUserByUsername(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        List<User> users = (List<User>) criteria.list();
        return users.get(0);
    }
       
    @Override
    public void add(User user) {
        getSession().saveOrUpdate(user);
    }


    @Override
    public void update(User user) {
        getSession().merge(user);
    }

    @Override
    public void delete(int userID) {
        User target = getUserById(userID);
        getSession().delete(target);
    }
    
}
