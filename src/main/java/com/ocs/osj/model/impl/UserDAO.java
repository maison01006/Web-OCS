package com.ocs.osj.model.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ocs.osj.model.UserVO;
@Repository
public class UserDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<UserVO> userRowMapper = BeanPropertyRowMapper.newInstance(UserVO.class);
	
	public String USER_SELECT = "SELECT * FROM user WHERE id=:id AND password=:password";
	public String MAJOR_USER_SELECT = "SELECT * FROM user WHERE major_id=:id ";
	public String USER_ID_SELECT = "SELECT * FROM user WHERE name=:name";
	public UserDAO(DataSource dataSource) {
		this.jdbc= new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<UserVO> login(String id, String password) {
		Map<String, String> params=new HashMap<>();
		params.put("id", id);
		params.put("password", password);
		return jdbc.query(USER_SELECT, params,userRowMapper);
	}
	public List<UserVO> getMajorUser(int id) {
		Map<String, Integer> params=new HashMap<>();
		params.put("id", id);
		
		return jdbc.query(MAJOR_USER_SELECT, params,userRowMapper);
	}
	public List<UserVO> getUserId(String name) {
		Map<String, String> params=new HashMap<>();
		params.put("name", name);
		return jdbc.query(USER_ID_SELECT, params,userRowMapper);
	}
}
