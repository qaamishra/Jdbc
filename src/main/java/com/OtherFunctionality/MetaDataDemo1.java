package com.OtherFunctionality;

import java.sql.*;
import java.util.Properties;

class MetaDataDemo1
{
	private static String salDisplay;

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
			
			while (rs.next())
			{
				int eid=rs.getInt(1);
				String ename=rs.getString(2);
				int esal=rs.getInt(3);
				String edesg= rs.getString(4);
				if(rs.wasNull())
					  salDisplay = " No Pay or Null";
				else
					salDisplay = String.valueOf(esal);
				System.out.println(eid+"\t"+ename+"\t"+esal+"\t"+edesg+salDisplay);
			}			
	System.out.println();
	//rs.close();
	ps.close(); 
	con.close(); 
	}
		catch (Exception e)
		{
			e.printStackTrace();
		}
}
}


