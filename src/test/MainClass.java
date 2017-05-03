package test;

import java.util.Scanner;

public class MainClass
{   
	@SuppressWarnings("resource")
	public static void main(String args[])
	{ 
		try
		{
		InsertClass ic=new InsertClass();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter merchant id");
		int merchantID=sc.nextInt();
		boolean b=ic.merchantCheck(merchantID);
		if(b)
		{
			System.out.println("Enter pickup location id"+" "+"Changes");
			int pickupLocationID=sc.nextInt();
			boolean b1=ic.pickupLocationCheck(merchantID, pickupLocationID);
			if(b1)
			{
				System.out.println("Enter facility ID to be mapped to this pickup location");
				int facilityID=sc.nextInt();
				boolean b2=ic.facilityCheck(facilityID);
				if(b2)
				{
						ic.connection(facilityID, pickupLocationID, merchantID);
				}
				else
				{
					System.out.println("Enetered facility id is not valid");
				}
			}
			else
			{
				System.out.println("Entered pickup location id is not valid");
			}
		}
		else
		{
			System.out.println("Entered merchant id is not valid");
		}
		}
		catch(Exception e)
		{
			System.out.println("Last entered ID is not in correct format");
		}
	}
}  