package jdbcPrepared.employee;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class EmployeeCurd {
	
	Scanner sc = new Scanner(System.in);
	public Connection getConnection() throws Exception{
//		Class.forName("com.mysql.cj.jdbc.Driver");
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
	FileInputStream stream= new FileInputStream("file.properties");
	Properties properties=new Properties();
   properties.load(stream);
   Connection c= DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("jdbc2"),properties.getProperty("pwd"));
   return c;
	}
	public void saveEmployee(Employee emp) throws Exception
	{
		Connection c=getConnection();
		PreparedStatement s= c.prepareStatement("insert into employee values(?,?,?,?)");
		s.setInt(1, emp.getId());
		s.setString(2,emp.getName());
		s.setString(3, emp.getPhone());
		s.setString(4, emp.getEmailid());
		s.execute();
		c.close();
		
		
	}
	public boolean loginUser() throws Exception {

		System.out.println("enter your email");
		String email = sc.next();
		System.out.println("enter your password");
		String pwd = sc.next();
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from employee where email = ?");
		statement.setString(1, email);
    
		ResultSet result = statement.executeQuery();
		String emppwd = null;
		String empemail = null;

		while (result.next()) {
			empemail = result.getString(4);
			emppwd = result.getString(5);
		}

		if (pwd.equals(emppwd) && email.equals(empemail)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void updateEmployee(Employee emp)throws Exception
	{
		
		Connection connection = getConnection();		
		PreparedStatement s= connection.prepareStatement("update employee set name=?,phone=? where id=?");
		s.setString(1, emp.getName());
		s.setString(2, emp.getPhone());
		s.setInt(3, emp.getId());
		s.execute();
		connection.close();
		
	}
	
	public void deleteEmployee(int id) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c= getConnection();
		PreparedStatement s= c.prepareStatement("delete from employee where id=?");
		s.setInt(1,id);
		s.execute();
		c.close();
		
	}
	public void retrieveUser()throws  Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c= getConnection();
		PreparedStatement s= c.prepareStatement("select * from employee");
		ResultSet result= s.executeQuery();
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