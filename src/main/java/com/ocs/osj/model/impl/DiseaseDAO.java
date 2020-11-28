package com.ocs.osj.model.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ocs.osj.model.DiseaseVO;
import com.ocs.osj.model.DrugVO;

@Repository
public class DiseaseDAO {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DiseaseVO> diseaseRowMapper = BeanPropertyRowMapper.newInstance(DiseaseVO.class);
	
	public String DISEASE_SELECT = "SELECT * FROM disease WHERE disease_name_kor LIKE :name";
	public String DISEASE_RECEIVE_SELECT = "SELECT disease_name_kor FROM disease d inner join disease_prescription dp on d.disease_id = dp.disease_id WHERE dp.receive_id=:receiveId order by dp.dises_yn;";
	public DiseaseDAO(DataSource dataSource) {
		this.jdbc= new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<DiseaseVO> getDisease(String name){
		Map<String,String> params = new HashMap<>();
		params.put("name","%"+name+"%");
		
		return jdbc.query(DISEASE_SELECT, params,diseaseRowMapper);
	}
	public List<DiseaseVO> getDisease(int receiveId){
		Map<String,Integer> params = new HashMap<>();
		params.put("receiveId",receiveId);
		
		return jdbc.query(DISEASE_RECEIVE_SELECT, params,diseaseRowMapper);
	}
}
