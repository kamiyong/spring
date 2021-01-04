package com.ly.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.dao.RoleDao;
import com.ly.entity.Role;
import com.ly.service.RoleService;

@Service("RoleService")
public class RoleServiceImpl implements RoleService{
	private static final Logger LOGGER = Logger.getLogger(RoleServiceImpl.class);
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Role getRole(int id) {
		LOGGER.info("Get role by id");
		return roleDao.getRole(id);
	}

	
	@Override
	public List<Role> getAllRole() {
		LOGGER.info("Get All role.");
		return roleDao.getAllRoleList();
	}
}
