package com.ocs.osj.model;

import java.util.List;

public interface InjectionPrescriptionService {

	void insertInjectionPrescription(InjectionPrescriptionVO vo);
	public void updateInjectionPrescription(InjectionPrescriptionVO vo);
	public List<InjectionPrescriptionVO> getInjectionPrescription(int receiveId);
}