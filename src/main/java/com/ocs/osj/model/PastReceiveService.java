package com.ocs.osj.model;

import java.util.List;

public interface PastReceiveService {

	public List<PastReceiveVO> getPastReceive(int patientId);

}