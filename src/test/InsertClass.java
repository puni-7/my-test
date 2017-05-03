package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertClass 
{
	Connection con=null;
	Connection con1=null;
	Connection con2=null;
	Connection con3=null;
	boolean b=false;
	public void connection(int facilityID,int pickupLocationID,int merchantID)
	{
		int service_area_id=0;
		try
		{  
			Class.forName("com.mysql.jdbc.Driver"); 
			 con=DriverManager.getConnection(  
			"jdbc:mysql://10.85.39.64:3306/facilities","root","");  
			Statement stmt=con.createStatement();
			String type="pickupLocationMapping";
			String query="Insert into service_areas(type,type_id,value,code,active) Values("+"'"+type+"'"+","+pickupLocationID+","+"'"+type+"'"+","+merchantID+","+1+")";
			String query1="Select id from service_areas where type_id="+pickupLocationID+" "+"AND"+" "+"code="+merchantID;
			//System.out.println(query);
			//System.out.println(query1);
			int rs=stmt.executeUpdate(query);
			System.out.println(rs+" rows inserted in service_areas");
			ResultSet rs1=stmt.executeQuery(query1);
			while(rs1.next())
			{
				service_area_id=rs1.getInt(1); 
			}
			//System.out.println(i);
			String query2="Insert into facility_service_area_mappings(facility_id,service_area_id,small,medium,large,active) VALUES ("+facilityID+","+service_area_id+","+1+","+1+","+0+","+1+")";
			//System.out.println(query2);
			int rs2=stmt.executeUpdate(query2);
			System.out.println(rs2+" rows inserted in facility_service_area_mapping");
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}  
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	public boolean merchantCheck(int merchantID)
	{
		b=false;
		try
		{
		Class.forName("com.mysql.jdbc.Driver"); 
		
		con1=DriverManager.getConnection(  
				"jdbc:mysql://10.85.39.78:3306/merchant","root","");
		String merchantQuery="Select * from merchants WHERE id="+merchantID;
		Statement stmt1=con1.createStatement();
		ResultSet merchantResultSet=stmt1.executeQuery(merchantQuery);
		if(merchantResultSet.next())
		{
			b=true;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			if(con1!=null)
			{
				try {
					con1.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	return b;
	}
	public boolean pickupLocationCheck(int merchantID,int pickupLocationID)
	{
		b=false;
		try
		{
		Class.forName("com.mysql.jdbc.Driver"); 
		
		con2=DriverManager.getConnection(  
				"jdbc:mysql://10.85.39.78:3306/merchant","root","");
		String pickupLocationQuery="Select * from pickup_locations WHERE id="+pickupLocationID+" "+"AND"+" "+"merchant_id="+merchantID;
		//System.out.println(pickupLocationQuery);
		Statement stmt2=con2.createStatement();
		ResultSet pickupResultSet=stmt2.executeQuery(pickupLocationQuery);
		if(pickupResultSet.next())
		{
			b=true;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			if(con2!=null)
			{
				try {
					con2.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	return b;
	}
	public boolean facilityCheck(int facilityID)
	{
		b=false;
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			 con3=DriverManager.getConnection(  
			"jdbc:mysql://10.85.39.64:3306/facilities","root","");
		String facilityQuery="Select * from facilities WHERE id="+facilityID;
		//System.out.println(facilityQuery);
		Statement stmt3=con3.createStatement();
		ResultSet facilityResultSet=stmt3.executeQuery(facilityQuery);
		if(facilityResultSet.next())
		{
			b=true;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			if(con3!=null)
			{
				try {
					con3.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	return b;
	}
}

