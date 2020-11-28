package com.ocs.osj.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocs.osj.model.InjectionPrescriptionService;
import com.ocs.osj.model.InjectionPrescriptionVO;
import com.ocs.osj.model.InjectionVO;

@Service
public class InjectionPrescriptionServiceImpl implements InjectionPrescriptionService{

	@Autowired
	InjectionPrescriptionDAO injectionPrescriptionDAO;
	
	@Override
	@Transactional
	public void insertInjectionPrescription(InjectionPrescriptionVO vo) {
		injectionPrescriptionDAO.insertInjectionPrescription(vo);
		
	}

	@Override
	@Transactional
	public void updateInjectionPrescription(InjectionPrescriptionVO vo) {
		injectionPrescriptionDAO.updateInjectionPrescription(vo);
		
	}

	@Override
	public List<InjectionPrescriptionVO> getInjectionPrescription(int receiveId) {
		List<InjectionPrescriptionVO> injectionPrescriptionList = injectionPrescriptionDAO.getInjectionPrescription(receiveId);
		return injectionPrescriptionList;
	}


}
