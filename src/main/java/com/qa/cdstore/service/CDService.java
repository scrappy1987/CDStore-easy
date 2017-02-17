package com.qa.cdstore.service;

public interface CDService {

	String getAllCDs();

	String addNewCD(String cdJson);

	String updateCD(Integer id, String updatedCd);

	String deleteCD(Integer id);

}