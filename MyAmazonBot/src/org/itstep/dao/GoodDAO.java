package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.itstep.model.Good;

public class GoodDAO {

	public ArrayList<String> get() {
		ArrayList<String> array = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet  resultSet = null;
		
		String sql = "SELECT asin FROM goods";

		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery(); // executeQuery shows that it must return something
			while(resultSet.next()) {
				array.add(resultSet.getString("asin"));
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
		return array;
	}
	
}
