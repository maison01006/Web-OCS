package com.ocs.osj.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocs.osj.model.ReceivePatientService;
import com.ocs.osj.model.ReceivePatientVO;

@Service
public class ReceivePatientServiceImpl implements ReceivePatientService{

	@Autowired
	ReceivePatientDAO receivePatientDAO;
	
	@Override
	@Transactional
	public List<ReceivePatientVO> getReceivePatient(String userId) {
		List<ReceivePatientVO> receivePatientList = receivePatientDAO.getReceivePatient(userId);
		return receivePatientList;
	}

	@Override
	@Transactional
	public List<ReceivePatientVO> getReceiveInjectionPatient(String userId) {
		List<ReceivePatientVO> receivePatientList = receivePatientDAO.getReceiveInjectionPatient(userId);
		return receivePatientList;
	}

	@Override
	public List<ReceivePatientVO> getReceipt(String name) {
		List<ReceivePatientVO> receiptList = receivePatientDAO.getReceipt(name);
		return receiptList;
	}

	@Override
	public List<ReceivePatientVO> getReceiveInjection() {
		List<ReceivePatientVO> receivePatientList = receivePatientDAO.getReceiveInjection();
		return receivePatientList;
	}

}
