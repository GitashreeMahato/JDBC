package jdbcStatement.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// inserting the data

public class InsertStudent {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// load or register
		Class.forName("com.mysql.cj.jdbc.Driver");
		//establish the connection
		
		String url="jdbc:mysql://localhost:3306/jdbc1";
		//Connection connection=DriveManager.getConnection();
				String user="root";
		String password="Gitashree@123";
	Connection connection=DriverManager.getConnection(url, user, password);
	                                                
	// creation the statement
	Statement statement=connection.createStatement();
	
	// 4. execute the statement
	
	String query="insert into student values(46,'Monika',40000,'m@gmail.com','Amsterdam')";
	
	statement.execute(query);
	
	//close
	
	connection.close();
	
	
	System.out.println("inserted");
	}
	

}
