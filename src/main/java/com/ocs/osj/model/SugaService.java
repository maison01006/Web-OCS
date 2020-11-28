package com.ocs.osj.model;

import java.util.List;

public interface SugaService {

	List<SugaVO> getInjecSuga(int receiveId);

	List<SugaVO> getSuga(String fmyn);

}