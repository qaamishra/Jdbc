package com.OtherFunctionality;

import java.sql.*;
import java.util.Properties;

class MetaDataDemo
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
				
			PreparedStatement ps= con.prepareStatement("select * from Employee where eid=?");

			ps.setInt(1, Integer.parseInt(args[0]));
			
			ResultSet rs= ps.executeQuery();

			ResultSetMetaData rm= rs.getMetaData();

			int cols = rm.getColumnCount();

			System.out.println();

			for(int i=1; i<=cols ; i++)
			{
				System.out.println(rm.getColumnName(i)+"\t");
			}

			System.out.println();
			
						while(rs.next())
			{
							for(int i=1; i<=cols; i++)
				{
								System.out.print(rs.getString(i)+"\t");
				}
			}
			System.out.println();
			ps.close(); 

			
			

		//	stmt.close();
			con.close(); 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
}
}