package com.bridgeLabz;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.DatabaseMetaData;
public class MetaData {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Connection connection=null;
		Statement statement=null;
		String query="select * from login_validation.Employee";
		ResultSet resultSet=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=sanju");
			DatabaseMetaData databaseMetaData=(DatabaseMetaData) connection.getMetaData();
			System.out.println("Driver name "+databaseMetaData.getDriverName());
			System.out.println("Driver version "+databaseMetaData.getDriverVersion());
	        statement=connection.createStatement();
	        resultSet=statement.executeQuery(query);
	        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
	        System.out.println("total no col ="+resultSetMetaData.getColumnCount());
	        System.out.println("name of 3rd column "+resultSetMetaData.getColumnName(2));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(resultSet!=null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(statement!=null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			}
		scanner.close();
	}
}
