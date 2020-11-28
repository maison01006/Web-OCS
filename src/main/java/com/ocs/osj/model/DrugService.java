package com.ocs.osj.model;

import java.util.List;

public interface DrugService {
	public List<DrugVO> getDrug(String name);
	public List<DrugVO> getDrug(int receiveId);
}
