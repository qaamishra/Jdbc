package com.BasicFunctionality;

public class insert extends Connect {
	
	public int insertStmt(String data)
	{
		getConnection();
		int n=0;
		String sql="INSERT INTO emp_test values(" +data+ ")";
	
		try
		{
			n=stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			closeConnection();
		}	
		System.out.println(n+" row inserted successfully");
		return n;
	}

	public static void main(String[] args) {
		insert i=new insert();
		String data="654323,'charm','london'";
		i.insertStmt(data);
	}
}
