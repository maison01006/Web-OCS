package com.ocs.osj.model.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ocs.osj.model.DepartmentVO;


@Repository
public class DepartmentDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DepartmentVO> departmentRowMapper = BeanPropertyRowMapper.newInstance(DepartmentVO.class);
	
	public String DEPARTMENT_SELECT = "SELECT * FROM department ";
	
	public DepartmentDAO(DataSource dataSource) {
		this.jdbc= new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<DepartmentVO> getDepartment(){
		Map<String,String> params = new HashMap<>();
		
		return jdbc.query(DEPARTMENT_SELECT, params,departmentRowMapper);
	}
}
