package com.ocs.osj.model;

import java.util.List;

public interface ReceiveService {
	public void insertReceive(ReceiveVO vo);
	public void updateReceive(ReceiveVO vo);
	public void updateReceiveInjection(ReceiveVO vo);
	public void updateReceiveReceipt(ReceiveVO vo);
	public void updateReceiveInjectionPrescription(ReceiveVO vo);
}