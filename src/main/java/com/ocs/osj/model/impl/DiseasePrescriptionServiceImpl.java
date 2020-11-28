package com.ocs.osj.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocs.osj.model.DiseasePrescriptionService;
import com.ocs.osj.model.DiseasePrescriptionVO;

@Service
public class DiseasePrescriptionServiceImpl implements DiseasePrescriptionService{
	
	@Autowired
	DiseasePrescriptionDAO diseasePrescriptionDAO;

	@Override
	public List<DiseasePrescriptionVO> getDiseasePrescription(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void insertDiseasePrescription(DiseasePrescriptionVO vo) {
		diseasePrescriptionDAO.insertDiseasePrescription(vo);
		
	}
}
