package com.bridgeLabz;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetriveDataFromDataBase {
	public static void main(String[] args) {
		java.sql.Connection connection = null;
		Statement statement = null;
		String query = "select * from login_validation.Student";
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is registered and loaded");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=sanju");
			System.out.println("connection is established with database ");
			statement = connection.createStatement();
			System.out.println("statement is created");
			resultSet = statement.executeQuery(query);
			System.out.println("executed successfully");
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				int id = resultSet.getInt("id");
				System.out.println("name =" + name + "   id = " + id);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

}
