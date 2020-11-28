package com.ocs.osj.model;

import java.util.List;

public interface ReceivePatientService {

	List<ReceivePatientVO> getReceivePatient(String userId);
	List<ReceivePatientVO> getReceiveInjectionPatient(String userId);
	public List<ReceivePatientVO> getReceipt(String name);
	public List<ReceivePatientVO> getReceiveInjection();
}