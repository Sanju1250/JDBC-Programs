package com.bridgeLabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedRetrive 
{
    public static void main(String[] args) {
		Connection connection=null;
		java.sql.PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=sanju");
			preparedStatement=connection.prepareStatement("select * from login_validation.Employee");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				String name=resultSet.getString("name");
				int id=resultSet.getInt(2);
				double salary=resultSet.getDouble(3);
				System.out.println(name+" "+id+" "+salary);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
