package com.sush.first.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sush.first.model.User;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

	public void deleteUser(User user) {
		Query query = getSession().createSQLQuery("delete from User where username = :username");
        query.setString("username", user.getUsername());
        query.executeUpdate();
	}

	public void insertUser(User user) {
		getSession().persist(user);
	}

	public User getUserDetails(String username) {
		Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username",username));
        return (User) criteria.uniqueResult();
	}

	public void updateUser(User user) {
		getSession().update(user);
	}
}
