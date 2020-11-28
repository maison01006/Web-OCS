package com.ocs.osj.model.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.ocs.osj.model.PrescriptionVO;
import com.ocs.osj.model.ReceiveVO;

@Repository
public class PrescriptionDAO {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<PrescriptionVO> rescriptionRowMapper = BeanPropertyRowMapper.newInstance(PrescriptionVO.class);
	
	
	public PrescriptionDAO(DataSource dataSource) {
		this.jdbc= new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("prescription")
				.usingGeneratedKeyColumns("prescription_id");
	}
	public void insertRescription(PrescriptionVO vo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(vo);
		insertAction.executeAndReturnKey(params);
	}
}


