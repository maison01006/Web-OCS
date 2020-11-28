package com.ocs.osj.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocs.osj.model.UserService;
import com.ocs.osj.model.UserVO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;

	@Override
	@Transactional
	public List<UserVO> login(String id, String password) {
		List<UserVO> userList = userDAO.login(id, password);
		return userList;
	}

	@Override
	@Transactional
	public List<UserVO> getMajorUser(int id) {
		List<UserVO> userList = userDAO.getMajorUser(id);
		return userList;
	}

	@Override
	@Transactional
	public List<UserVO> getUserId(String name) {
		List<UserVO> userList = userDAO.getUserId(name);
		return userList;
	}

}
