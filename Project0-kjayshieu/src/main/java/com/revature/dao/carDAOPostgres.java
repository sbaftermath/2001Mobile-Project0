package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Car;
import com.revature.pojo.Customer;
import com.revature.pojo.User;
import com.revature.util.ConnectionFactory;

public class carDAOPostgres implements carDAO {

	@Override
	public void createCar(String car) {
		// TODO Auto-generated method stub
		
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("insert into cars(car) values (?)");
			stmt.setString(1, car);
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
	public void removeCar(String car) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("delete from cars where car=?");
			stmt.setString(1, car);
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
	public List<Car> viewCars() {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		List<Car> carList = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("select * from cars where user_id is null");
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				carList.add(new Car(resultSet.getString(3), resultSet.getInt(1), resultSet.getInt(2)));
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
		return carList;
		
	}

	@Override
	public List<Car> viewOwnedCars(String username) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		List<Car> carList = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("select * from cars where user_id=any(select user_id from users where username= ?)");
			stmt.setString(1, Customer.getUsername());
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				carList.add(new Car(resultSet.getString(3), resultSet.getInt(1), resultSet.getInt(2)));
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
		return carList;
	}

	public static List<Car> getCarID(String car) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		List<Car> carList = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("select * from cars where car=?");
			stmt.setString(1, car);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				carList.add(new Car(resultSet.getString(3), resultSet.getInt(1), resultSet.getInt(2)));
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
		System.out.println(carList);
		return carList;
	}
}
