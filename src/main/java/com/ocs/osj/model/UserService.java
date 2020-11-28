package com.ocs.osj.model;

import java.util.List;
import com.ocs.osj.model.*;
public interface UserService {
	public List<UserVO> login(String id, String password);
	public List<UserVO> getMajorUser(int id);
	public List<UserVO> getUserId(String name);
}
