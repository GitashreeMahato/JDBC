package Prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Program2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Id:");
		int Id=sc.nextInt();
		
		System.out.println("==========Follow the updated data=================");
		
		System.out.println("Enter name");
		String Name=sc.next();
		
		System.out.println("Enter Phone No:");
		int Phone_No=sc.nextInt();
		
		System.out.println("Enter Email Id:");
    	String Email_Id=sc.next();
		
		System.out.println("Enter Address:");
		String Address=sc.next();
	
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1", "root", "Gitashree@123");
		
		PreparedStatement Pst=c.prepareStatement("update preparedstudent set Name=?, Phone_No=? where Id=?");
		
		Pst.setInt(3, Id);
		//                place holder
		Pst.setString(1, Name);
		Pst.setInt(2, Phone_No);
	//	Pst.setString(3, Email_Id);
	//	Pst.setString(4, Address);
		
		Pst.execute();
		
		c.close();
		
		System.out.println(Id + "Your date has updated");
	}

}
