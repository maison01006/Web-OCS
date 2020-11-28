package com.ocs.osj.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocs.osj.model.PrescriptionService;
import com.ocs.osj.model.PrescriptionVO;

@Service
public class PrescriptionServiceImpl  implements PrescriptionService {

	@Autowired
	PrescriptionDAO prescriptionDAO;

	@Override
	@Transactional
	public void insertRescription(PrescriptionVO vo) {
		
		prescriptionDAO.insertRescription(vo);
	}
	
	


}
