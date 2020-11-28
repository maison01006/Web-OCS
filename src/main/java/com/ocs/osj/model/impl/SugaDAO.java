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

import com.ocs.osj.model.DiseaseVO;
import com.ocs.osj.model.PatientVO;
import com.ocs.osj.model.ReceiveVO;
import com.ocs.osj.model.SugaVO;

@Repository
public class SugaDAO{
	private NamedParameterJdbcTemplate jdbc;

	private RowMapper<SugaVO> sugaRowMapper = BeanPropertyRowMapper.newInstance(SugaVO.class);
	public String INJECTION_SUGA_SELECT = "select suga_id, suga_name_kor, unit_cost, pay_nonpay,class_num from suga where suga_name_kor = (select injec_name_kor from (select injec_id from injection_prescription i inner join receive r on i.receive_id = r.receive_id where i.receive_id = :receiveId) a inner join injection inj on a.injec_id = inj.injec_id)";
	public String SUGA_SELECT = "select * from suga where suga_id = :sugaId";
	
	
	public SugaDAO(DataSource dataSource) {
		this.jdbc= new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<SugaVO> getInjecSuga(int receiveId){
		Map<String,Integer> params = new HashMap<>();
		params.put("receiveId",receiveId);
		
		return jdbc.query(INJECTION_SUGA_SELECT, params,sugaRowMapper);
	}
	public List<SugaVO> getSuga(String fmyn){
		Map<String,String> params = new HashMap<>();
		if(fmyn.equals("√ ¡¯")) {
			params.put("sugaId","AA155");
		}else {
			params.put("sugaId","AA255");
		}
		return jdbc.query(SUGA_SELECT, params,sugaRowMapper);
	}
}
