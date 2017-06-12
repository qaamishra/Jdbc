package com.BasicFunctionality;

public class Select extends Connect{
	
	public String selectStmt()
	{
		getConnection();
		//int n=0;
		String sql="select * from emp_test";
		String s="invalid";
		try
		{
			
			rs=stmt.executeQuery(sql);
			System.out.println(s);
			while (rs.next())
			{
//				System.out.println(rs.getInt(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(3));
//				System.out.println(rs.getInt(1));
				s=rs.getInt(1) + "," 
				+ rs.getString(2) + "," 
				+ rs.getString(3) ;
				System.out.println(s);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			//closeConnection();
		}
		
		return s;
	}

	public static void main(String[] args) {
		Select s=new Select();
		s.selectStmt();
	}
}
