package com.bridgeLabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataIntoDataBase {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		String query="insert into login_validation.Student values('virat',103)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class is loaded and Registered");
		    connection=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=sanju");
		    System.out.println("Connection is established with data base server");
		    statement=connection.createStatement();
		    System.out.println("statement is created");
		    statement.executeUpdate(query);
		    System.out.println("data inserted succefully");
		
		} catch (ClassNotFoundException e) {
			System.out.println(e);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(statement!=null)
			{
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection!=null)
			{
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
