package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Customer;
import com.revature.pojo.Offer;
import com.revature.pojo.Payment;
import com.revature.util.ConnectionFactory;

public class PaymentDAOPostgres implements PaymentDAO {

	@Override
	public void createPayment(String car, int offer) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		try {

			stmt = conn.prepareStatement("insert into payment(car_id,total_amount) values (car_id,?)"
					+ " where car_id=any(select car_id from cars where car=?) and "
					+ "where user_id=any(select user_id from offers where car_id=any(select car_id from cars where car=?))");
			stmt.setInt(1, offer);
			stmt.setString(2, car);
			stmt.setString(3, car);
			ResultSet resultSet = stmt.executeQuery();

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
	public List<Payment> viewPayment() {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		List<Payment> paymentList = new ArrayList<>();
		try {
			stmt = conn
					.prepareStatement("select * from payment where user_id=any(select user_id from users where username=?)");
			stmt.setString(1, Customer.getUsername());
			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				paymentList.add(new Payment(resultSet.getInt(2), resultSet.getInt(3), resultSet.getInt(4)));
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
		return paymentList;
	}

	@Override
	public List<Payment> viewAllPayments() {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		List<Payment> paymentList = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("select * from payment");
			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				paymentList.add(new Payment(resultSet.getInt(2), resultSet.getInt(3), resultSet.getInt(4)));
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
		return paymentList;
	}

}
