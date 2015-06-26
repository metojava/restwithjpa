package com.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService {

	EntityManagerFactory emfactory = Persistence
			.createEntityManagerFactory("elink_JPA");

	EntityManager entityManager = emfactory.createEntityManager();
	UserDao userDao = new UserDao(entityManager);

	@POST
	@Consumes(MediaType.TEXT_XML)
	public User createUser(User user) {
		return userDao.createUser(user);
	}

	@GET
	@Path("/users")
	@Produces(MediaType.TEXT_XML)
	public List<User> getUsers() {
		// change return type to String and use gson
		// Gson gson = new Gson();
		// String users = gson.toJson(userDao.findAllUsers());
		List<User> users = new ArrayList<User>();
		users.addAll(userDao.findAllUsers());
		return users;
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_XML)
	public User getUser(@PathParam("id") int id) {
		// change return type to String and use gson
		// Gson gson = new Gson();
		// String offices = gson.toJson(userDao.findUser(id));

		return userDao.findUser(id);
	}

	@DELETE
	@Path("{id}")
	public void delUser(@PathParam("id") int id) {

		userDao.removeUser(id);
	}

}
