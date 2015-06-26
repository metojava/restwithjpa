package com.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserDao {

	protected EntityManager entityManager;

	public UserDao(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public User createUser(int id,String fname,String Lname,String address,Date birthDate)
	{
		User user = new User( id, fname, Lname, address, birthDate);
		entityManager.persist(user);
		return user;
		
	}

	public User findUser(int id) {

		return entityManager.find(User.class, id);

	}
	
	public User findUserById(int id) {

		Query q = entityManager.createNamedQuery("findUserById");
		q.setParameter("id", id);
		User u = (User)q.getResultList().get(0);
		return u;

	}
	public void removeUser(int id) {

		User user = entityManager.find(User.class, id);
		entityManager.remove(user);

	}
	public List<User> findAllUsers()
	{
		Query q = entityManager.createQuery("select u from User u");
		@SuppressWarnings("unchecked")
		List<User> users = new ArrayList<User>(q.getResultList());
		return users;
		
	}

	public User createUser(User user) {

		entityManager.persist(user);
		return user;
		
	}
}
