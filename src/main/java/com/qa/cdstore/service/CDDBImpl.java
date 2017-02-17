package com.qa.cdstore.service;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Default
public class CDDBImpl implements CDService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

}
