package com.rk.tables.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonBaseDao {

	@Autowired
	protected SessionFactory sessionFactory;

	protected void saveorUpdate(Object entity) {
		getSession().saveOrUpdate(entity);
	}

	protected void delete(Object entity) {
		getSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	protected <T> T getWithId(Class<T> type, Serializable id) {
		return (T) getSession().get(type, id);
	}

	@SuppressWarnings("unchecked")
	protected <T> List<T> getAll(String query) {
		return getSession().createQuery(query).list();
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
