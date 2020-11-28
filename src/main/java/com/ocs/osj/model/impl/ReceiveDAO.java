package com.ocs.osj.model.impl;

import java.util.Collections;
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
import com.ocs.osj.model.ReceiveVO;

@Repository
public class ReceiveDAO {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ReceiveVO> receiveRowMapper = BeanPropertyRowMapper.newInstance(ReceiveVO.class);
	private RowMapper<PatientVO> patientRowMapper = BeanPropertyRowMapper.newInstance(PatientVO.class);
	
	public String RECEIVE_UPDATE = "UPDATE receive SET treat_status = 'Y' WHERE receive_id = :receiveId";
	public String RECEIVE_INJEC_UPDATE = "UPDATE receive SET injec_yn = 'N' WHERE receive_id = :receiveId";
	public String RECEIVE_RECEIPT_UPDATE = "UPDATE receive SET receipt_yn = 'Y' WHERE receive_id = :receiveId";
	public String RECEIVE_INJECTION_PRESCRIPTION_UPDATE = "UPDATE receive SET injec_yn ='Y', treat_status = 'N' WHERE receive_id=:receiveId";
	public ReceiveDAO(DataSource dataSource) {
		this.jdbc= new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("receive")
				.usingGeneratedKeyColumns("receive_id");
	}
	
	public void insertReceive(ReceiveVO vo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(vo);
		insertAction.executeAndReturnKey(params);
	}
	public void updateReceive(ReceiveVO vo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(vo);
		jdbc.update(RECEIVE_UPDATE, params);
	}
	public void updateReceiveInjection(ReceiveVO vo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(vo);
		jdbc.update(RECEIVE_INJEC_UPDATE, params);
	}
	public void updateReceiveReceipt(ReceiveVO vo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(vo);
		jdbc.update(RECEIVE_RECEIPT_UPDATE, params);
	}
	public void updateReceiveInjectionPrescription(ReceiveVO vo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(vo);
		jdbc.update(RECEIVE_INJECTION_PRESCRIPTION_UPDATE, params);
	}
}
