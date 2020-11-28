package com.ocs.osj.model.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.ocs.osj.model.DrugPrescriptionVO;
import com.ocs.osj.model.ReceiveVO;

@Repository
public class DrugPrescriptionDAO {
	private SimpleJdbcInsert insertAction;
	private RowMapper<DrugPrescriptionVO> receiveRowMapper = BeanPropertyRowMapper.newInstance(DrugPrescriptionVO.class);
	
	public DrugPrescriptionDAO(DataSource dataSource) {
		
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("drug_prescription")
				.usingGeneratedKeyColumns("drug_pres_id");
	}
	public void insertReceive(DrugPrescriptionVO vo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(vo);
		insertAction.executeAndReturnKey(params);
	}
}
