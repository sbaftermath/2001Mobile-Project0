package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Customer;
import com.revature.pojo.Offer;
import com.revature.pojo.User;
import com.revature.util.ConnectionFactory;

public class UserDAOPostgres implements UserDAO {

	@Override
	public void createUser(String username, String password) {
		// TODO Auto-generated method stub

		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("insert into users(username, user_password) values (?,?)");
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<User> loginUser(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		List<User> userList = new ArrayList<User>();

		try {
			stmt = conn.prepareStatement("select * from users where username=? and user_password=?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				userList.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getBoolean(4)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}

	public List<User> getUserID() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		List<User> userList = new ArrayList<User>();
		try {
			stmt = conn.prepareStatement("select * from users where username=?");
			stmt.setString(1, Customer.getUsername());
			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				userList.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getBoolean(4)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}
	
	@Override
	public void setEmployee() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCustomer() {
		// TODO Auto-generated method stub

	}

}
