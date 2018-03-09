package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.itstep.model.Account;

public class GoodAddingDAO {

	public void save(Account account, String asin) {

		Connection connection = null;
		PreparedStatement statement = null;

		String sql = "INSERT INTO goodsadding(good_asin, account_login, add_time, in_cart) VALUES(?,?,?,?)";
		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, asin);
			statement.setString(2, account.getLogin());
			statement.setLong(3, System.currentTimeMillis());
			statement.setBoolean(4, true);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
