package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Customer;
import com.revature.pojo.Offer;
import com.revature.pojo.User;
import com.revature.util.ConnectionFactory;

public class OfferDAOPostgres implements OfferDAO {
	
	PaymentDAOPostgres pdp = new PaymentDAOPostgres();
	
	UserDAOPostgres udp = new UserDAOPostgres();

	carDAOPostgres cdp = new carDAOPostgres();

	@Override
	public void addOffer(String car, int offer) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		List<User> userIDList = udp.getUserID();
		int userID = userIDList.get(0).getId();
		int carID = cdp.getCarID(car).get(0).getCarID();
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement("insert into offers(user_id,car_id,amount) values(?,?,?)");
			stmt.setInt(1, userID);
			stmt.setInt(2, carID);
			stmt.setInt(3, offer);
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
		pdp.createPayment(car, offer);
	}

	@Override
	public void acceptOffer(String car, int offer) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(
					"update offers set offer_status = 'accepted' where car_id=any(select car_id from cars where car = ?) and amount = ?");
			stmt.setInt(2, offer);
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
		pdp.createPayment(car, offer);
	}

	@Override
	public void rejectOffer(String car, int offer) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(
					"update offers set offer_status = 'rejected' where car_id=any(select car_id from cars where car = ?) and amount = ?");
			stmt.setInt(2, offer);
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
	public List<Offer> viewOffers() {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		List<Offer> offerList = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("select * from offers");
			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				offerList.add(new Offer(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3)));
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
		return offerList;
	}

}
