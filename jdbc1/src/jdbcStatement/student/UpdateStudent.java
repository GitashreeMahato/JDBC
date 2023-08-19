package jdbcStatement.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStudent {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//load the register
		Class.forName("com.mysql.cj.jdbc.Driver");
		//establish the connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1","root","Gitashree@123");
		//create statement
		Statement statement=connection.createStatement();
		//execute the statement
		statement.execute("Update student set name='Honey' where Id=1");
		//close
		statement.close();
		connection.close();
		
		System.out.println("Updated");
	}

}
