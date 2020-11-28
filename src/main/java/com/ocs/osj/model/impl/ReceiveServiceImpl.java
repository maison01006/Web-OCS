package com.ocs.osj.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocs.osj.model.PatientVO;
import com.ocs.osj.model.ReceiveService;
import com.ocs.osj.model.ReceiveVO;

@Service
public class ReceiveServiceImpl implements ReceiveService{

	@Autowired
	ReceiveDAO receiveDAO;
	
	@Override
	@Transactional
	public void insertReceive(ReceiveVO vo) {
		receiveDAO.insertReceive(vo);
		
	}
	@Override
	@Transactional
	public void updateReceive(ReceiveVO vo) {
		receiveDAO.updateReceive(vo);
	}
	@Override
	@Transactional
	public void updateReceiveInjection(ReceiveVO vo) {
		receiveDAO.updateReceiveInjection(vo);
		
	}
	@Override
	public void updateReceiveReceipt(ReceiveVO vo) {
		receiveDAO.updateReceiveReceipt(vo);
		
	}
	@Override
	public void updateReceiveInjectionPrescription(ReceiveVO vo) {
		receiveDAO.updateReceiveInjectionPrescription(vo);
		
	}
	
}
