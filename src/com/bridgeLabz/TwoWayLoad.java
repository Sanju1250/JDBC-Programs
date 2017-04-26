package com.bridgeLabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class TwoWayLoad {
	public static void main(String[] args) {
		Connection connection=null;
		
		try {
		    Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			//Class.forName("com.mysql.jdbc.Driver"); //to load the driver
			DriverManager.deregisterDriver(driver);//remove the spacified driver from Driver manager class
			System.out.println("loaded and registered");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=sanju");
			System.out.println("connection established");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
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
