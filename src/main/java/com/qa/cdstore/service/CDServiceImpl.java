package com.qa.cdstore.service;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;


@ApplicationScoped
@Alternative
public class CDServiceImpl implements CDService {
	
		private static final Logger LOGGER = Logger.getLogger(CDServiceImpl.class);
		private final int INITIAL_COUNT = 1;
		private Map<Integer, CD> CdMap;
		private int id;

		@Inject
		private JSONUtil util;

		public CDServiceImpl() {
			this.CdMap = new HashMap<Integer, CD>();
			id = INITIAL_COUNT;
			initCDStore();
		}

		@Override
		public String getAllCDs() {
			return util.getJSONForObject(CdMap.values());
		}

		@Override
		public String addNewCD(String CDJson) {
			id++;
			CD newCD = util.getObjectForJSON(CDJson, CD.class);
			LOGGER.info("In add CD method about to add to map");
			CdMap.put(id, newCD);
			LOGGER.info("Add a CD to the map");
			return CDJson;
		}

		@Override
		public String updateCD(Integer ID, String updatedCD) {
			CD newCD = util.getObjectForJSON(updatedCD, CD.class);
		CdMap.put(ID, newCD);
			return updatedCD;
		}

		@Override
		public String deleteCD(Integer ID) {
			LOGGER.info("In delete CD method about to CD");
			CdMap.remove(ID);
			LOGGER.info("In delete cd method CD removed");
			return "{\"message\": \"CD removed\"}";
		}

		private void initCDStore() {
			CD aCD = new CD("Don't let the sun go down", "George Micheal", "Ladies and Gentlemen", "2011");
			CdMap.put(1, aCD);
			CD bCD = new CD("I don't wana live forever", "Zayn & Taylor Swift", "Fifty shades Darker soundtrack", "2017");
			CdMap.put(2, bCD);
			CD cCD = new CD("Still take you Home", "Arctic Monkeys", "Whatever people say i am, That's what i'm not", "2006");
			CdMap.put(3, cCD);
			CD dCD = new CD("Halo", "Beyonce", "Halo-EP", "2009");
			CdMap.put(4, dCD);
			CD eCD = new CD("still DRE", "Dr. Dre", "2001", "1999");
			CdMap.put(5, eCD);
			CD fCD = new CD("F**k You", "DR. Dre", "2001", "1999");
			CdMap.put(6, fCD);
			CD gCD = new CD("Know Yourself", "Drake", "If you're reading this its too late", "2015");
			CdMap.put(7, gCD);
			CD hCD = new CD("Faith", "George Micheal", "Ladies and Gentlemen", "2011");
			CdMap.put(8, hCD);
			CD iCD = new CD("Runaway", "Ed Sheeran", "x", "2014");
			CdMap.put(9, iCD);
			CD jCD = new CD("The Way I Am", "Eminem", "The Marshall Mathers LP", "2000");
			CdMap.put(10, jCD);
		}

	}



