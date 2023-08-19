package Prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteStudent {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Please provide your email id to delete your data");
		String Email_id=sc.next();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1", "root", "Gitashree@123");
		
		PreparedStatement pst=c.prepareStatement("delete from preparedstudent where Email_id=?");
		
		pst.setString(1, Email_id);
		
		int a = pst.executeUpdate(); //to check how many rows are affected
		
		c.close();
		
		System.out.println("Your" +Email_id+ "Linked account is deleted");
	}

}
