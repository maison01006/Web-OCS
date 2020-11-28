package com.ocs.osj.model;

import java.util.List;

public interface DiseasePrescriptionService {

	List<DiseasePrescriptionVO> getDiseasePrescription(String name);

	void insertDiseasePrescription(DiseasePrescriptionVO vo);

}