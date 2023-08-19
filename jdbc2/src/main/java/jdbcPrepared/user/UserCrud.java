package jdbcPrepared.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserCrud {
	
	//creating a method for saving user object
	
	public void saveUser(User u) throws Exception {
		//               user object
		
		Class.forName("com.mysql.cj.Driver");
		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2", "root", "Gitashree@123");
		PreparedStatement pst=c.prepareStatement("insert into user valus (?,?,?,?,?)");
		
		pst.setInt(1, u.getId());
		pst.setString(2, u.getName());
		pst.setString(3, u.getEmail_id());
		pst.setString(4, u.getPassword());
		pst.setLong(5, u.getPhone());
		
		
	}

	public void updateUser(User user) throws Exception {
		
		Class.forName("com.mysql.cj.Driver");
		
		Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2", "root", "Gitashree@123");
		PreparedStatement pst=c.prepareStatement("update user set Email_id=?, Phone=? where id=2");
		
		pst.setInt(3, user.getId());
		pst.setString(1, user.getEmail_id());
		pst.setLong(2, user.getPhone());
		
		pst.execute();
		
		c.close();
		
		
	}
	
	public void deleteUser(String name) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2","root", "Gitashree@123");
		PreparedStatement statement=connection.prepareStatement("delete from user where name=?");
		statement.setString(1, name);
		statement.execute();
		connection.close();
	 
 }
	
	public void retrieveUser() throws Exception{
		 Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2","root", "Gitashree@123");
		PreparedStatement statement=connection.prepareStatement("select * from user");
	ResultSet result= statement.executeQuery();
	while(result.next())
	{
		System.out.println(result.getInt(1));
		System.out.println(result.getString(2));
		System.out.println(result.getString(3));
		System.out.println(result.getString(4));
		
		System.out.println("=========");
	}
			
	 }
}
