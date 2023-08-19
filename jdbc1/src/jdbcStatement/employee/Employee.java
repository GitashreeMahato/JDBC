package jdbcStatement.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//inserting the data

public class Employee {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// load the register
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//establish the connection
		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1", "root", "Gitashree@123");
		                                  
		//create the statement
		Statement st=c.createStatement();
		
		// Execute the statement
		String query="insert into employee values (8,'Rhea','Exective',4892349,'IBM')";
		
		st.execute(query);
		
		System.out.println("Inserted the data");
		
	}

}
