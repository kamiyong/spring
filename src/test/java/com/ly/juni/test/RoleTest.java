package com.ly.juni.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ly.entity.Role;
import com.ly.service.RoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class RoleTest {

	
	private static final Logger LOGGER = Logger.getLogger(RoleTest.class);
	
	@Autowired
	private RoleService roleService;
	
	
	@Test
	public void testGetRole() {
		Role role = roleService.getRole(1000);
		if (role != null) {			
			LOGGER.info(role.toString());
		} else {
			LOGGER.info("Failed to query.");
		}
		
		LOGGER.info("------------------------");
		
		List<Role> roleList = roleService.getAllRole();
		if (roleList != null) {
			for (Role r : roleList) {
				if(r != null) {
					LOGGER.info(r.toString());
				}
			}
		} else {
			LOGGER.info("Failed to get all role.");
		}
		
		
		
	}
	
}
