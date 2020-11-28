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
import com.ocs.osj.model.InjectionVO;

@Repository
public class InjectionDAO{
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<InjectionVO> injectionRowMapper = BeanPropertyRowMapper.newInstance(InjectionVO.class);
	
	public String INJECTION_SELECT = "SELECT * FROM injection WHERE injec_name_kor LIKE :name";
	
	
	public InjectionDAO(DataSource dataSource) {
		this.jdbc= new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<InjectionVO> getInjection(String name){
		Map<String,String> params = new HashMap<>();
		params.put("name","%"+name+"%");
		
		return jdbc.query(INJECTION_SELECT, params,injectionRowMapper);
	}
	
}
