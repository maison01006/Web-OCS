package com.ocs.osj.model.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ocs.osj.model.ReceivePatientVO;

@Repository
public class ReceivePatientDAO {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ReceivePatientVO> receivePatientRowMapper = BeanPropertyRowMapper.newInstance(ReceivePatientVO.class);
	
	public String RECEIVE_PATIENT_SELECT = "select gender,age,regno,address,etc,blood,name,fmyn,patient_id,receive_id from (select * from patient ) s inner join receive r on s.id = r.patient_id where r.treat_status ='n' AND r.receipt_yn ='n' AND r.injec_yn is null AND r.user_id=:userId";
	public String RECEIVE_INJECTION_PATIENT_SELECT = "select gender,age,regno,address,etc,blood,name,fmyn,patient_id,receive_id from (select * from patient ) s inner join receive r on s.id = r.patient_id where r.treat_status ='n' AND r.injec_yn = 'y' AND r.user_id=:userId";
	public String RECEIPT_SELECT = "select patient_id, name, gender, age, regno, tel, address,fmyn,receive_id  from receive r inner join patient p on r.patient_id = p.id where treat_status = 'Y' and receipt_yn = 'N' and name =:name";
	public String RECEIVE_INJECTION_SELECT = "select name, gender, age, regno, blood,receive_id from (select * from patient ) s inner join receive r on s.id = r.patient_id where r.treat_status ='Y' AND r.injec_yn = 'N' and r.receipt_yn = 'N'";
	
	public ReceivePatientDAO(DataSource dataSource) {
		this.jdbc= new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ReceivePatientVO> getReceivePatient(String userId){
		Map<String,String> params = new HashMap<>();
		
		params.put("userId", userId);
		return jdbc.query(RECEIVE_PATIENT_SELECT, params,receivePatientRowMapper);
	}
	public List<ReceivePatientVO> getReceiveInjectionPatient(String userId){
		Map<String,String> params = new HashMap<>();
		
		params.put("userId", userId);
		return jdbc.query(RECEIVE_INJECTION_PATIENT_SELECT, params,receivePatientRowMapper);
	}
	public List<ReceivePatientVO> getReceipt(String name){
		Map<String,String> params = new HashMap<>();
		
		params.put("name", name);
		return jdbc.query(RECEIPT_SELECT, params,receivePatientRowMapper);
	}
	public List<ReceivePatientVO> getReceiveInjection(){
		Map<String,String> params = new HashMap<>();

		return jdbc.query(RECEIVE_INJECTION_SELECT, params,receivePatientRowMapper);
	}
}
