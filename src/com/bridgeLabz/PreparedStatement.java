package com.bridgeLabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatement {
	public static void main(String[] args) {
		Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		String query = "insert into login_validation.Employee values(?,?,?)";
		Scanner scanner=new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=sanju");
			preparedStatement = connection.prepareStatement(query);
			System.out.println("Enter the name");
			String name=scanner.next();
			preparedStatement.setString(1, name);
			System.out.println("enter the id");
			int id=scanner.nextInt();
			preparedStatement.setInt(2, id);
			System.out.println("enter the salary");
			double salary=scanner.nextDouble();
			preparedStatement.setDouble(3, salary);
			preparedStatement.executeUpdate();
//			preparedStatement.setString(1, "virat");
//			preparedStatement.setInt(2, 103);
//			preparedStatement.setDouble(3, 8500.00);
//			preparedStatement.executeUpdate();
			System.out.println("Data is inserted successfully");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
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
