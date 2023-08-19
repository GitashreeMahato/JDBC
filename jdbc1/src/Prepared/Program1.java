package Prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Scanner;

public class Program1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	//taking the values from the users	
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the Id:");
		int Id=sc.nextInt();
	
		System.out.println("Enter the Name:");
		String Name=sc.next();
		
		System.out.println("Enter the Phone number:");
		int Phone_No=sc.nextInt();
		
		System.out.println("Enter the Email Id");
		String Email_Id=sc.next();
		
		System.out.println("Enter the address");
		String Address=sc.next();
		
		//Class.forName("com.mysql.cj.jdbc.Driver");//without the class method program can run
		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1", "root", "Gitashree@123");
		//                                                      port no        schema name    
		String query="insert into preparedstudent values(?,?,?,?,?)";
		PreparedStatement pst=c.prepareStatement(query);
// in the preparedStatement we can the provide the values dynamically and taking the values from the users		
		
		pst.setInt(1, Id);
		pst.setString(2, Name);
		pst.setInt(3, Phone_No);
		pst.setString(4, Email_Id);
		pst.setString(5, Address);
		
		
		pst.execute();
		
		c.close();
		
		System.out.println("Inserted" +Name+ "Data");
		
		
	}

}
