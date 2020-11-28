package com.ocs.osj.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocs.osj.model.PatientService;
import com.ocs.osj.model.PatientVO;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientDAO patientDAO;

	@Override
	@Transactional
	public List<PatientVO> getPatient(String name) {
		List<PatientVO> patientList = patientDAO.getPatient(name);
		return patientList;
	}

	@Override
	@Transactional
	public void insertPatient(PatientVO vo) {
		patientDAO.insertPatient(vo);
	}
	
	
}
