package com.OtherFunctionality;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

class PreparedStatementDemo
{
	public static void main(String args[]) throws SQLException
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			String url="jdbc:odbc:mydsn1";
			
			Properties p=new Properties();
			p.put("user", "Rohit");
			p.put("password","Kumar");
			
			Connection con=DriverManager.getConnection(url,p);
			
			System.out.print("Connection Established....");
				
			PreparedStatement ps= con.prepareStatement("insert into Employee (eid,ename,esal,edesg) values(?,?,?,?)");
			
			System.out.println("hiii");

			ps.setInt(1,109);
			ps.setString(2, "KIRRAANNN");
			ps.setInt(3, 500000);
			ps.setString(4, "DIRECTOR");

			System.out.println(" hiiiiiiiiiii");

			int count = ps.executeUpdate();

			System.out.println(" hiiiiiiiiiii");

			System.out.println(count  +"row(s) inserted");



			
			
			
			
			//ps.close();

			

		//	stmt.close();
			con.close(); 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
}
}