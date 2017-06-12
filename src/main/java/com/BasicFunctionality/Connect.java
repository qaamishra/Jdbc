package com.BasicFunctionality;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Connect 
{

	public Connection con=null;
	public Statement stmt=null;
	public ResultSet rs=null;
	String url="jdbc:oracle:thin:@172.23.76.110:1521:NALANDA";
	String userName="train";
	String password="train";
	
	public void getConnection()
	{
		try
		{
			//Class.forName( ) to register the Oracle driver:
			/*Dynamic loading is a technique for programmatically invoking the functions of a
class loader at run time. Let us look at how to load classes dynamically.

Class.forName (String className); //static method which returns a Class

The above static method returns the class object associated with the class
name. The string className can be supplied dynamically at run time. Unlike the
static loading, the dynamic loading will decide whether to load the class Car or
the class Jeep at runtime based on a properties file and/or other runtime
conditions. Once the class is dynamically loaded the following method returns an
instance of the loaded class. It�s just like creating a class object with no
arguments*/
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,userName,password);
			System.out.println("Connected");
			stmt=con.createStatement();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
		
	
	public void closeConnection()
	{
		try
		{
			if(rs!=null) 
				rs.close();
		

			if(stmt!=null) 
				stmt.close();

			if(con!=null) 
				con.close();
			System.out.println("connection closed");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public static void main(String[] args) 
		
	{
		Connect t=new Connect();
		//t.getConnection();
		t.closeConnection();
	}
}
