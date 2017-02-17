package com.qa.cdstore.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;


@Stateless
@Default
public class CDDBImpl implements CDService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	@SuppressWarnings("unchecked")
	@Override
	public String getAllCDs() {
		Query query = em.createQuery("SELECT e FROM CD e");
		Collection<CD> cds = (Collection<CD>) query.getResultList();
		return util.getJSONForObject(cds);
	}

	@Override
	public String addNewCD(String CDJson) {
		CD newCD = util.getObjectForJSON(CDJson, CD.class);
		em.persist(newCD);
		return CDJson;
	}

	@Override
	public String updateCD(Integer id, String updatedCD) {
		CD updateCD = util.getObjectForJSON(updatedCD, CD.class);
		CD cd = findCD(new Integer(id));
		if (cd != null) {
			cd = updateCD;
			em.merge(cd);
		}
		return "{\"message\": \"CD updated\"}";
	}

	@Override
	public String deleteCD(Integer id) {
		CD cd = findCD(new Integer (id));
		if (cd != null) {
			em.remove(cd);
		}
		return "{\"message\": \"CD removed\"}";
	}

	private CD findCD(Integer id) {
		return em.find(CD.class, id); 
	}

}
