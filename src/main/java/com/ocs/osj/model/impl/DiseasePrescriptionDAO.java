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

import com.ocs.osj.model.DiseasePrescriptionVO;
import com.ocs.osj.model.PatientVO;

@Repository
public class DiseasePrescriptionDAO {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<DiseasePrescriptionVO> diseasePrescriptionRowMapper = BeanPropertyRowMapper.newInstance(DiseasePrescriptionVO.class);
	
public String PATIENT_SELECT = "SELECT disease_pres_id, receive_id, disease_id, dises_yn FROM disease_prescription dp WHERE receive_id IN (SELECT receive_id FROM receive WHERE patient_id =:name);";

	public DiseasePrescriptionDAO(DataSource dataSource) {
		this.jdbc= new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("Disease_Prescription")
				.usingGeneratedKeyColumns("Disease_Pres_Id");
	}
	
	public List<DiseasePrescriptionVO> getDiseasePrescription(int name){
		Map<String,Integer> params = new HashMap<>();
		params.put("name", name);
		return jdbc.query(PATIENT_SELECT, params,diseasePrescriptionRowMapper);
	}
	public void insertDiseasePrescription(DiseasePrescriptionVO vo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(vo);
		insertAction.executeAndReturnKey(params);
	}
}
