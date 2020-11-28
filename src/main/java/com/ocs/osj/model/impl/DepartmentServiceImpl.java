package com.ocs.osj.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocs.osj.model.DepartmentService;
import com.ocs.osj.model.DepartmentVO;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	DepartmentDAO departmentDAO;

	@Override
	@Transactional
	public List<DepartmentVO> getDepartment() {
		List<DepartmentVO> departmentList = departmentDAO.getDepartment();
		return departmentList;
	}
}
