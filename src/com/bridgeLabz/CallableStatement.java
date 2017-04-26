package com.bridgeLabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
public class CallableStatement 
{
    public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
    System.out.println("enter the Student id");
    int id=scanner.nextInt();
	Connection connection=null;
	java.sql.CallableStatement callableStatement=null;
	String query="{call login_validation.newproc(?,?)}";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=sanju");
		callableStatement=connection.prepareCall(query);
		callableStatement.setInt(1, id);
		callableStatement.execute();
		callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
		String name=callableStatement.getString(2);
		System.out.println(name);
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	scanner.close();
	}
}
