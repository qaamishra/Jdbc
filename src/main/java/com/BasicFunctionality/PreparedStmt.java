package com.BasicFunctionality;

import java.sql.PreparedStatement;


public class PreparedStmt extends Connect {

	public String  pStmt() //throws SQLException
	{
		
		getConnection();
		PreparedStatement pstmt=null;
		String sql="INSERT INTO emp_test values(?,?,?)";
		String s = null;
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,654327);
			pstmt.setString(2,"goodman");
			pstmt.setString(3,"california");
			rs=pstmt.executeQuery();
			
			//int count = pstmt.executeUpdate();

			//System.out.println(" hiiiiiiiiiii");

			//System.out.println(count  +"row(s) inserted");

			
			
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
	
	public static void main(String[] args)  {
		
		PreparedStmt p=new PreparedStmt();
		p.pStmt();
		Select s=new Select();
		s.selectStmt();
		
	}

}
