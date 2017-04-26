package com.bridgeLabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginValidation {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		String query = "select * from login_validation.JDBCLogin";
		ResultSet resultSet = null;
		Scanner scanner = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=sanju");
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			System.out.println("enter the user name");
			String username = scanner.next();
			System.out.println("enter the pass word");
			String password = scanner.next();
			while (resultSet.next()) {
				String username1 = resultSet.getString("username");
				String password1 = resultSet.getString("password");
				if (username1.equals(username) && password1.equals(password)) {
					System.out.println("Hi welcome " + username);
					return;
				}
			}
			System.out.println("Invalid user name");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
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
