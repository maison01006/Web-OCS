package com.ocs.osj.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocs.osj.model.DrugPrescriptionService;
import com.ocs.osj.model.DrugPrescriptionVO;

@Service
public class DrugPrescriptionServiceImpl implements DrugPrescriptionService{

	@Autowired
	DrugPrescriptionDAO drugPrescriptionDAO;
	
	@Override
	public void insertReceive(DrugPrescriptionVO vo) {
		drugPrescriptionDAO.insertReceive(vo);
	}

}
