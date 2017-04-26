package com.bridgeLabz;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class JdbcTranscation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		java.sql.Connection connection = null;
		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;
		Savepoint savepoint = null;
		String query1 = "insert into login_validation.Employee values(?,?,?)";
		String query2 = "insert into login_validation.Student values(?,?)";
		System.out.println("enter the name");
		String name = scanner.next();
		System.out.println("enter the id");
		int id = scanner.nextInt();
		System.out.println("enter the salary");
		double salary = scanner.nextDouble();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=sanju");
			connection.setAutoCommit(false);
			savepoint = connection.setSavepoint();

			preparedStatement1 = connection.prepareStatement(query1);
			preparedStatement1.setString(1, name);
			System.out.println("hi sunil");
			preparedStatement1.setInt(2, id);
			savepoint = connection.setSavepoint();
			preparedStatement1.setDouble(3, salary);
			preparedStatement1.executeUpdate();
			System.out.println("Employee details are executed successfully");

			System.out.println("233");
			preparedStatement2 = connection.prepareStatement(query2);
			preparedStatement2.setString(1, name);
			preparedStatement2.setInt(2, id);
			preparedStatement2.executeUpdate();
			System.out.println("Student details are executed succefully");
			connection.commit();
		} catch (ClassNotFoundException | SQLException e) {
			try {
				connection.rollback(savepoint);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println("all the database operation are rolled back");
		}

		finally {

			if (preparedStatement2 != null) {
				try {
					preparedStatement2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement1 != null) {
				try {
					preparedStatement1.close();
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

		scanner.close();
	}

}
