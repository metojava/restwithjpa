package com.office;

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

@Path("/OfficeService")
public class OfficeService {

	EntityManagerFactory emfactory = Persistence
			.createEntityManagerFactory("elink_JPA");

	EntityManager entityManager = emfactory.createEntityManager();

	OfficeDao officeDao = new OfficeDao(entityManager);

	@POST
	@Consumes(MediaType.TEXT_XML)
	public void createOffice(Office office) {
		officeDao.createOffice(office);
	}

	@GET
	@Path("/offices")
	@Produces(MediaType.TEXT_XML)
	public List<Office> getOffices() {
		// change return type to String and use gson
		// Gson gson = new Gson();
		// String offices = gson.toJson(officeDao.findAllOffices());
		List<Office> offices = new ArrayList<Office>();
		offices.addAll(officeDao.findAllOffices());
		return offices;
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_XML)
	public Office getOffice(@PathParam("id") int id) {
		// change return type to String and use gson
		// Gson gson = new Gson();
		// String offices = gson.toJson(officeDao.findOffice());

		return officeDao.findOffice(id);
	}

	@DELETE
	@Path("{id}")
	public void delOffice(@PathParam("id") int id) {

		officeDao.removeOffice(id);
	}

}
