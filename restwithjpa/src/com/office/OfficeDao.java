package com.office;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class OfficeDao {

	protected EntityManager entityManager;

	public OfficeDao(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public Office createOffice(int oid, String name)
	{
		Office office = new Office(oid,name);
		entityManager.persist(office);
		return office;
		
	}

	public Office createOffice(Office office)
	{
		
		entityManager.persist(office);
		return office;
		
	}
	
	public Office findOffice(int id) {

		return entityManager.find(Office.class, id);

	}
	
	
	public void removeOffice(int id) {

		Office office = entityManager.find(Office.class, id);
		entityManager.remove(office);

	}
	public List<Office> findAllOffices()
	{
		Query q = entityManager.createQuery("select o from Office o");
		@SuppressWarnings("unchecked")
		List<Office> offices = new ArrayList<Office>(q.getResultList());
		return offices;
		
	}

}
