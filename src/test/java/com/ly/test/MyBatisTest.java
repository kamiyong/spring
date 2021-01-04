package com.ly.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ly.entity.Role;

public class MyBatisTest {

	public static void main(String[] args) {
		run();
		
	}
	
	private static void run() {
		
		try {
			Reader reader = Resources.getResourceAsReader("");
			if (reader == null) {
				System.out.println("Reader is null.");
				return;
			}
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = factory.openSession();
			
			System.out.println("query one.");
			Role role = session.selectOne("role.getRoleById", 1000);
			System.out.println(role.toString());
			System.out.println("query list.");
			List<Role> roles = session.selectList("role.getAllRoleAsList");
			for (Role r : roles) {
				System.out.println(r.toString());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
