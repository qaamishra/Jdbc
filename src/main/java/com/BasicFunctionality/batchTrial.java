package com.BasicFunctionality;



public class batchTrial extends Connect {
	
	public int[] batchStmt()
	{
		getConnection();
		
		try
		{
			String sql="INSERT INTO emp_test values(654325,'jon','australia' )";
			stmt.addBatch(sql);
			String sql1="INSERT INTO emp_test values(654324,'lane','australia' )";
			stmt.addBatch(sql1);
			
			//int[] count= stmt.executeBatch();
			
			
			//System.out.println(count);
			//for (int i=0;i<=count.length ;i++)
			//{
			//	System.out.println(count);
			//}
			
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			//closeConnection();
		}
		return null;
		
	
	}
	
	
	
	public static void main(String[] args) {
		batchTrial b=new batchTrial();
		b.batchStmt();
		Select s=new Select();
		s.selectStmt();
		
		
	}

}
