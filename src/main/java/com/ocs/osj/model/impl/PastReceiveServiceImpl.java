package com.ocs.osj.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocs.osj.model.PastReceiveService;
import com.ocs.osj.model.PastReceiveVO;

@Service
public class PastReceiveServiceImpl implements PastReceiveService{

	@Autowired
	PastReceiveDAO pastReceiveDAO;
	

	@Override
	public List<PastReceiveVO> getPastReceive(int patientId) {
		List<PastReceiveVO> pastReceiveList = pastReceiveDAO.getPastReceive(patientId);
		return pastReceiveList;
	}

}
