package jdbcStatement.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetriveStudent {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1", "root", "Gitashree@123");
		//                                         port name
		Statement st=c.createStatement();
		
		// boolean result=st.execute("select * from student");
		// System.out.println(result); ===true(dql command)
		
		ResultSet result = st.executeQuery("select * from student");
		
		
		while(result.next()) {
			System.out.println(result.getInt(1)); //---id
			System.out.println(result.getString(2)); //---name
			System.out.println(result.getInt(3));//---phone no
			System.out.println(result.getString(4));//---email id
			System.out.println(result.getString(5));//----address
			System.out.println("===================================");
			
			System.out.println(result.getInt("id")+" = "+result.getString("name"));
		}c.close();
	}

}





//execute--->dml/dql---boolean(dql--true   dml---false
		//executeupdate-----dml---int----how many rows are affected
		//executequery--->dql----resultset
