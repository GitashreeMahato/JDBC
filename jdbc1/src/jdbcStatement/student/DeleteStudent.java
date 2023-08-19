package jdbcStatement.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//delete the row
public class DeleteStudent {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	//load the driver
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	//establish the connection
	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1", "root", "Gitashree@123");
	
	//create the statement
	Statement st=c.createStatement();
	
	//execute the statement
	int a=st.executeUpdate("delete from student where name='Sham'");
// executeUpdate- calculate the row	
	
	//close the connection
	c.close();
	
	System.out.println(a);
}
}
