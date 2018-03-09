package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.itstep.model.Account;


public class AccountDAO {

	public void save(Account account) {

		Connection connection = null;
		PreparedStatement statement = null;

		String sql = "INSERT INTO accounts(login, email, password) VALUES(?, ?, ?)";
		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, account.getLogin());
			statement.setString(2, account.getEmail());
			statement.setString(3, account.getPassword());
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

	public Account get(String login) {
		Account account = new Account();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet  resultSet = null;

		String sql = "SELECT * FROM accounts WHERE login=?";

		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			resultSet = statement.executeQuery(); // executeQuery shows that it must return something
			while(resultSet.next()) {
				account.setLogin(resultSet.getString("login"));
				account.setEmail(resultSet.getString("email"));
				account.setPassword(resultSet.getString("password"));
			}
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
		return account;
	}

	public void update(Account accInDB, Account accUpdated) {

		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "UPDATE accounts SET login = ?, email = ?, password = ? WHERE login=?";

		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, accUpdated.getLogin());
			statement.setString(2, accUpdated.getEmail());
			statement.setString(3, accUpdated.getPassword());
			statement.setString(4, accInDB.getLogin());
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

	public void delete(String login) {
		Connection connection = null;
		PreparedStatement statement = null;

		String sql = "DELETE FROM accounts WHERE login=?";

		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, login);
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
