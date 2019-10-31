package com.fine.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModelDAO {
	static  Connection connection;
	public static Connection openConnection(){
		String drivername="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="system";
		//String employeeTable="create table employeeTable(oracleId integer, name varchar(20), fine double, timesLate integer)";
		try{
			Class.forName(drivername);
			connection=DriverManager.getConnection(url, username, password);
	        /*PreparedStatement preparedStatement=connection.prepareStatement(employeeTable);
	        preparedStatement.execute();*/
		}catch(Exception e){
			System.out.println("sql exception");
		}
		return connection;
	}
	
	public static void closeConnection(){
		try{
			if(connection!=null)
				connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
