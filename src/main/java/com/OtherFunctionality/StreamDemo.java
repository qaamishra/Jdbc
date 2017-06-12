package com.OtherFunctionality;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

class StreamDemo
{
	public static void main(String args[]) throws SQLException
	{
		try
		{
			char ch='y';
			Connection con=null;
			while(ch=='y'||ch=='Y')
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");


							String url="jdbc:odbc:mydsn1";
			
								Properties p=new Properties();
								p.put("user", "Rohit");
								p.put("password","Kumar");
			
				con=DriverManager.getConnection(url,p);
				
				PreparedStatement pst= con.prepareStatement("insert into Employee values(?,?,?,?)");

				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

				System.out.println("Enter eid");

				int r=Integer.parseInt(br.readLine());
				System.out.println("Enter ename");
				String nm=br.readLine();

				System.out.println("Enter Esal:");
				int sal=Integer.parseInt(br.readLine());

				System.out.println("Enter Designation");
				String desg=br.readLine();

				pst.setInt(1,r);
				pst.setString(2,nm);
				pst.setInt(3,sal);
				pst.setString(4,desg);

				pst.executeUpdate();

				System.out.println("Record Inserted:");
				System.out.println(" Do want to Cont....(y/n)");
				ch=(char)br.read();
			}
			Statement stmt= con.createStatement();
			String query="select * from Employee";
			ResultSet rs=stmt.executeQuery(query);
			System.out.println("Eid\tName\t\tEsal\t\tEdesg\n");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getString(4));
			}

con.close();
stmt.close();
	}
		catch (Exception e)
		{
			e.printStackTrace();
		}
}
}


