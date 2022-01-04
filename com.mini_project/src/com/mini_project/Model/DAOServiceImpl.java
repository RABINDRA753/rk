package com.mini_project.Model;

import java.sql.*;

public class DAOServiceImpl implements DAOservice {
	private Connection con;
	private Statement stmnt;

	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "test");
			stmnt = con.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean verifyCredentials(String email, String password) {
		try {
			ResultSet result = stmnt
					.executeQuery("select * from login where email='" + email + "' and password='" + password + "'");
			return result.next();

		} catch (Exception e) {
		}

		return false;
	}

	@Override
	public void saveReg(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate(
					"insert into registration values('" + name + "','" + city + "','" + email + "','" + mobile + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet getReg() {
		try {

			ResultSet result = stmnt.executeQuery("select * from registration");
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public void deleteReg(String email) {
		try {
			stmnt.executeUpdate("delete from registration where email='" + email + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateReg(String email, String mobile) {
		try {
			stmnt.executeUpdate("UPDATE registration set mobile='"+mobile+"' where email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}
		
	}

}
