package com.bridgeLabz;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class BatchJdbc {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		String query1 = "update login_validation.Employee set name='sunil' where id=100";
		String query2 = "insert into login_validation.Employee values('sss',88,4500.50)";

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=sanju");
			statement = connection.createStatement();
			statement.addBatch(query1);
			statement.addBatch(query2);
			int array[] = statement.executeBatch();
			for (int i : array) {
				System.out.println(i + " ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
