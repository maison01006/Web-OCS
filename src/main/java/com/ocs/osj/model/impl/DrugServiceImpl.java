package com.ocs.osj.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocs.osj.model.DrugService;
import com.ocs.osj.model.DrugVO;

@Service
public class DrugServiceImpl implements DrugService{
	
	@Autowired
	DrugDAO drugDAO;

	@Override
	@Transactional
	public List<DrugVO> getDrug(String name) {
		List<DrugVO> drugList = drugDAO.getDrug(name);
		return drugList;
	}

	@Override
	public List<DrugVO> getDrug(int receiveId) {
		List<DrugVO> drugList = drugDAO.getDrug(receiveId);
		return drugList;
	}
	
	
}
