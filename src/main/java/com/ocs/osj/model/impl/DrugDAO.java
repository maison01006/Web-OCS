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

import com.ocs.osj.model.DrugVO;
import com.ocs.osj.model.PatientVO;

@Repository
public class DrugDAO {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DrugVO> drugRowMapper = BeanPropertyRowMapper.newInstance(DrugVO.class);
	
	public String DRUG_SELECT = "SELECT * FROM drug WHERE drug_name LIKE :name";
	public String DRUG_RECEIVE_SELECT = "select drug_name from drug d inner join drug_prescription dp on d.drug_id=dp.drug_id where dp.receive_id=:receiveId ;";
	
	public DrugDAO(DataSource dataSource) {
		this.jdbc= new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<DrugVO> getDrug(String name){
		Map<String,String> params = new HashMap<>();
		params.put("name","%"+name+"%");
		
		return jdbc.query(DRUG_SELECT, params,drugRowMapper);
	}
	public List<DrugVO> getDrug(int receiveId){
		Map<String,Integer> params = new HashMap<>();
		params.put("receiveId",receiveId);
		
		return jdbc.query(DRUG_RECEIVE_SELECT, params,drugRowMapper);
	}
}
