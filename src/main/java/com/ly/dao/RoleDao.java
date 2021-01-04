package com.ly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ly.entity.Role;

public interface RoleDao {
	
	public Role getRole(@Param("id")Integer id);
	
	public List<Role> getAllRoleList();
}
