package com.OtherFunctionality;

import java.sql.*;
import java.util.Properties;

class ResultSetDemo
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
				
			
			Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = stmt.executeQuery("select * from Employee");
			rs.moveToInsertRow();

			rs.updateInt("eid", 107);
			rs.updateString("ename", "KIRTI");
			rs.updateInt("esal" , 35000);
			rs.updateString("edesg", " Engineer");
			rs.insertRow();


			while(rs.next())
			{
				System.out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getInt(3)+""+rs.getString(4));
			}


			rs.absolute(5);
			rs.updateString("ename", "KKR");
			rs.updateRow();
			System.out.println("row inserted");
			
			
			
			rs.close();

			

			stmt.close();
			con.close(); 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
}
}