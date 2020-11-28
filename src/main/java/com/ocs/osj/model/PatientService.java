package com.ocs.osj.model;

import java.util.List;

import javax.sql.DataSource;

public interface PatientService {
	public List<PatientVO> getPatient(String name);
	public void insertPatient(PatientVO vo);
}
