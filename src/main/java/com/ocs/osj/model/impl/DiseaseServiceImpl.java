package com.ocs.osj.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocs.osj.model.DiseaseService;
import com.ocs.osj.model.DiseaseVO;
import com.ocs.osj.model.DrugVO;

@Service
public class DiseaseServiceImpl implements DiseaseService{
	
	@Autowired
	DiseaseDAO diseaseDAO;

	@Override
	@Transactional
	public List<DiseaseVO> getDisease(String name) {
		List<DiseaseVO> diseaseList = diseaseDAO.getDisease(name);
		return diseaseList;
	}

	@Override
	public List<DiseaseVO> getDisease(int receiveId) {
		List<DiseaseVO> diseaseList = diseaseDAO.getDisease(receiveId);
		return diseaseList;
	}
	
	
}
