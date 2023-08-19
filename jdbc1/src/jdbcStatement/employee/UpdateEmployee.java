package jdbcStatement.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateEmployee {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//load
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//establish the connection
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1", "root", "Gitashree@123");
		
		//create the statement
	
		Statement st=c.createStatement();
		
		//execute the statement
		st.execute("update employee set name='Khushi' where Emp_id=8");
		
		//close the connection
		st.close();
		c.close();
		
		System.out.println("Updated");
	}

}
