package com.ocs.osj.model.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.ocs.osj.model.PatientVO;

@Repository
public class PatientDAO {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<PatientVO> patientRowMapper = BeanPropertyRowMapper.newInstance(PatientVO.class);
	
	public String PATIENT_SELECT = "SELECT * FROM patient WHERE name=:name";
	
	public PatientDAO(DataSource dataSource) {
		this.jdbc= new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("patient")
				.usingGeneratedKeyColumns("id");
	}
	
	public List<PatientVO> getPatient(String name){
		Map<String,String> params = new HashMap<>();
		params.put("name", name);
		return jdbc.query(PATIENT_SELECT, params,patientRowMapper);
	}
	public void insertPatient(PatientVO vo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(vo);
		insertAction.executeAndReturnKey(params);
	}
}
