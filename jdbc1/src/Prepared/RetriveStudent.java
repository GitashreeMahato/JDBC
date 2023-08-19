package Prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RetriveStudent {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("to get your data please provide your id");
		int Id=sc.nextInt();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1", "root", "Gitashree@123");
		PreparedStatement pst=c.prepareStatement("select * from preparedstudent where Id=?");
		pst.setInt(1, Id);
		
		ResultSet rs=pst.executeQuery(); //
		
		while (rs.next()) {
			//rs.next() ----> to get the boolean value 
			System.out.println(rs.getInt(1)+ "=====" + rs.getString(2)+ "=====" + rs.getInt(3) + "====" + rs.getString(4) + "======" + rs.getString(5));
			
		}
	
		c.close();
		
	}
}


