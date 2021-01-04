package com.ly.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ly.entity.Role;


public class Connector {
	
	private Connection connection;
	public Connector() {
		// TODO Auto-generated constructor stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/game?"
					+ "serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=utf8",
					"root", "123456");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public Connection getConnection() {
		return connection;
	}
	
	public static void main(String[] args) throws SQLException {
		Connector connector = new Connector();
		Connection conn = connector.getConnection();
		Statement statement = conn.createStatement();
		ResultSet set = statement.executeQuery("select * from role");
		
		while (set.next()) {
			int id = set.getInt("ROLE_ID");
			String name = set.getString("ROLE_NAME");
			int sex = set.getInt("ROLE_SEX");
			System.out.println(new Role(id,  name, sex).toString());
		}
	}
	
}
