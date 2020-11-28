package com.ocs.osj.model;

import java.util.List;

public interface DiseaseService {

	List<DiseaseVO> getDisease(String name);
	public List<DiseaseVO> getDisease(int receiveId);
}