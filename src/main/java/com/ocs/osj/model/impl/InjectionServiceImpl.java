package com.ocs.osj.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocs.osj.model.InjectionService;
import com.ocs.osj.model.InjectionVO;

@Service
public class InjectionServiceImpl implements InjectionService {

	@Autowired
	InjectionDAO injectionDAO;
	
	@Override
	public List<InjectionVO> getInjection(String name) {
		List<InjectionVO> injectionList = injectionDAO.getInjection(name);
		return injectionList;
	}

	



	
	
}
