package com.ly.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ly.entity.Role;
import com.ly.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	private static final Logger logger = Logger.getLogger(RoleController.class);
	@Autowired
	RoleService service;
	
	
	
	
	@RequestMapping(value = "/getRoleById", method = RequestMethod.GET)
	@ResponseBody
	public Role getRole(int id) {
		long s = System.currentTimeMillis();
		Role role = service.getRole(id);
		long time = System.currentTimeMillis() - s;
		logger.info("Time cost to query one : " + (time) + "ms");
		return role;
	}
	
	@RequestMapping(value = "/getAllRole", method = RequestMethod.GET)
	@ResponseBody
	public List<Role> getRoles() {
		long s = System.currentTimeMillis();
		List<Role> list = service.getAllRole();
		long time = System.currentTimeMillis() - s;
		logger.info("Time cost to query all : " + (time) + "ms");
		return list;
	}
	
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
}
