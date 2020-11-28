package com.ocs.osj.model.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.ocs.osj.model.PastReceiveVO;

@Repository
public class PastReceiveDAO{

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<PastReceiveVO> receiveRowMapper = BeanPropertyRowMapper.newInstance(PastReceiveVO.class);
	
	public String PAST_RECEIVE_SELECT = "select drug_name, disease_name_kor, injec_name_kor, receive_id from (select drug_id, disease_id, injec_id,dp.receive_id from drug_prescription d inner join disease_prescription dp on d.receive_id = dp.receive_id inner join receive r on dp.receive_id = r.receive_id inner join injection_prescription ip on d.receive_id = ip.receive_id where r.patient_id=:patientId and dp.dises_yn ='m') ddi inner join drug dr on ddi.drug_id = dr.drug_id inner join disease di on ddi.disease_id = di.disease_id inner join injection inj on ddi.injec_id = inj.injec_id";
	
	public PastReceiveDAO(DataSource dataSource) {
		this.jdbc= new NamedParameterJdbcTemplate(dataSource);
	}
	public List<PastReceiveVO> getPastReceive(int patientId){
		Map<String,Integer> params = new HashMap<>();
		params.put("patientId",patientId);
		
		return jdbc.query(PAST_RECEIVE_SELECT, params,receiveRowMapper);
	}
}
