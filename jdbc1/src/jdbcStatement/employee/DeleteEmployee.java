package jdbcStatement.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEmployee {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1", "root", "Gitashree@123");
		Statement st=c.createStatement();
		st.execute("delete from employee where name='Khushi'");
		c.close();
		
		System.out.println("Deleted the data");
		
	}

	}


