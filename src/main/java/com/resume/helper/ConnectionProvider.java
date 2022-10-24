package com.resume.helper;
import java.sql.*;
public class ConnectionProvider {

	private static final String DRIVER_CLASS= "com.mysql.cj.jdbc.Driver";
	private static final String URL= "jdbc:mysql://localhost:3306/ideal_resume?allowPublicKeyRetrieval=true&useSSL=false";
	private static final String USER_NAME= "root";
	private static final String PASSWORD= "root";
	private static Connection con=null;

  
	public static  Connection getConnection(){
		try
		{
		if(con==null || con.isClosed()) {
			Class.forName(DRIVER_CLASS);
			con= DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		}
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
		return con;
		
	}
  }
	