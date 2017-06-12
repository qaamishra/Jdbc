package com.BasicFunctionality;


import java.sql.ResultSetMetaData;

public class ResultsetMetadata extends Connect {

	public void rsmdTrial()
	{
		getConnection();
		try
		{
			String sql="select * from emp_test";
			rs=stmt.executeQuery(sql);
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
		  //  int rowCount = 1;
		    
		    //press ctrl+7 to add or remove comment
		    
//it gives info about the coulumn's and detail data
//		     while (rs.next()) {
//		        System.out.println("Row " + rowCount + ":  ");
//		        
//		        for (int i = 1; i <= numberOfColumns; i++) 
//		        {
//		        	
//		        	System.out.println("Information about column " + i);
//	                System.out.println("   Name..........: " + rsmd.getColumnName(i));
//	                System.out.println("   Data Type.....: " + rsmd.getColumnType(i) +  
//	                		
//	                					"column Type"+
//	                		
//	                                   " ( " + rsmd.getColumnTypeName(i) + " )");
//	                System.out.println("   Precision.....: " + rsmd.getPrecision(i));
//	             
//
//		          System.out.print("   Column " + i + ":  ");
//		          System.out.println(rs.getString(i));
//		        }
//		        System.out.println("");
//		        rowCount++;
//
//		    }
		    
		    
//it gives info about the coulmn's only
//		     for (int i = 1; i <= numberOfColumns; i++) 
//	        {
//	        	
//	        	System.out.println("Information about column " + i);
//                System.out.println("   Name..........: " + rsmd.getColumnName(i));
//                System.out.println("   Data Type.....: " + rsmd.getColumnType(i) +  
//                		
//                					"column Type"+
//                		
//                                   " ( " + rsmd.getColumnTypeName(i) + " )");
//                System.out.println("   Precision.....: " + rsmd.getPrecision(i));
//             
//
//	          System.out.print("   Column " + i + ":  ");
//	          
//	        }
		  
//little detailed way of the above commented code
		    System.out.println("Name|"+"Precision"+"|ColumnType");
		    System.out.println("-------------------------");
		    for (int i = 1; i <= numberOfColumns; i++) 
	        {
	        	
	        	//System.out.println("Information about column " + i);
               
                System.out.println( rsmd.getColumnName(i)+"\t"+ 
                					rsmd.getPrecision(i)+ "\t"+ 
			                   		rsmd.getColumnTypeName(i)); 
                		
                System.out.println( "\t");     
	          
	        }
		    
		    
		    
				    
		}
		
		catch(Exception e){
			System.out.println(e);
		}
		finally
		{
		
		}
				
	}
	
	
	
	public static void main(String[] args) {
		
		ResultsetMetadata r=new ResultsetMetadata();
		r.rsmdTrial();
		
		
	}
}
