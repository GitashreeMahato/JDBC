package jdbcPrepared.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import jdbcPrepared.user.User;

public class BatchExecution {
public static void main(String[] args) throws Exception {
	
	User u1=new User();
	
	u1.setId(67);
	u1.setName("Pragya");
	u1.setEmail_id("p@gmail.com");
	u1.setPhone(837498327);
	u1.setPassword("422");
	
	
	User u2=new User();
	
	
	u2.setId(45);
	u2.setName("Lali");
	u2.setEmail_id("l@gmail.com");
	u2.setPhone(8949783);
	u2.setPassword("234");
	
	User u3=new User();
	
	u3.setId(97);
	u3.setName("Abhi");
	u3.setEmail_id("a@gmail.com");
	u3.setPhone(23458327);
	u3.setPassword("123");
	
	User u4=new User();
	
	u4.setId(67);
	u4.setName("Pragya");
	u4.setEmail_id("p@gmail.com");
	u4.setPhone(837498327);
	u4.setPassword("422");
	
	User u5=new User();
	
	u5.setId(67);
	u5.setName("Pragya");
	u5.setEmail_id("p@gmail.com");
	u5.setPhone(837498327);
	u5.setPassword("422");
	
	
	List<User>list=new ArrayList<User>();
	
	list.add(u1);
	list.add(u2);
	list.add(u3);
	list.add(u4);
	list.add(u5);
	
	// load the register
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	// establish the connection
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/userBatch", "root", "Gitashree@123");
	
	// create the statement
	PreparedStatement statement= connection.prepareStatement("insert into userBatch values (?,?,?,?,?)");
	for(User user:list) {
		statement.setInt(1, user.getId());
		statement.setString(2, user.getName());
		statement.setString(3, user.getEmail_id());
		statement.setString(4, user.getPassword());
		statement.setLong(5, user.getPhone());
		System.out.println("Inserted");
		statement.addBatch();
	}
	
	//execute
	statement.execute();
	
	// close the connection
	connection.close();
	
}
}
