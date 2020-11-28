package com.ocs.osj.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocs.osj.model.SugaService;
import com.ocs.osj.model.SugaVO;

@Service
public class SugaServiceImpl implements SugaService{

	@Autowired
	SugaDAO sugaDAO;
	
	@Override
	@Transactional
	public List<SugaVO> getInjecSuga(int receiveId) {
		
		List<SugaVO> injecSugaList = sugaDAO.getInjecSuga(receiveId);
		return injecSugaList;
		
	}

	@Override
	@Transactional
	public List<SugaVO> getSuga(String fmyn) {
		List<SugaVO> sugaList = sugaDAO.getSuga(fmyn);
		return sugaList;
	}

}
