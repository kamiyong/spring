package com.ly.service;

import java.util.List;

import com.ly.entity.Role;

public interface RoleService {

	public Role getRole(int id);
	
	public List<Role> getAllRole();
}
