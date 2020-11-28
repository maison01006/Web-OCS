package com.ocs.osj.model.impl;

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

import com.ocs.osj.model.DrugPrescriptionVO;
import com.ocs.osj.model.InjectionPrescriptionVO;
import com.ocs.osj.model.InjectionVO;

@Repository
public class InjectionPrescriptionDAO{
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<InjectionPrescriptionVO> injectionPrescriptionRowMapper = BeanPropertyRowMapper.newInstance(InjectionPrescriptionVO.class);
	
	public String UPDATE_INJECTION_PRESCRIPTION = "UPDATE injection_prescription SET img =:img WHERE receive_id = :receiveId";
	public String INJECTION_PRESCRIPTION_SELECT = "select s.injec_id, injec_name_kor,img from injection inj inner join (select i.injec_id,img from injection_prescription i inner join receive r on i.receive_id = r.receive_id  where r.receive_id = :receiveId)s on inj.injec_id = s.injec_id";
	public InjectionPrescriptionDAO(DataSource dataSource) {
		this.jdbc= new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("injection_prescription")
				.usingGeneratedKeyColumns("injec_pres_id");
	}
	public void insertInjectionPrescription(InjectionPrescriptionVO vo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(vo);
		insertAction.executeAndReturnKey(params);
	}
	public void updateInjectionPrescription(InjectionPrescriptionVO vo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(vo);
		jdbc.update(UPDATE_INJECTION_PRESCRIPTION, params);
	}
	public List<InjectionPrescriptionVO> getInjectionPrescription(int receiveId){
		Map<String,Integer> params = new HashMap<>();
		params.put("receiveId",receiveId);
		
		return jdbc.query(INJECTION_PRESCRIPTION_SELECT, params,injectionPrescriptionRowMapper);
	}
}
