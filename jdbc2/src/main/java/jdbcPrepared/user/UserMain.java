package jdbcPrepared.user;

import java.util.Scanner;

public class UserMain {
	public static void main(String[] args) throws Exception {
		
		UserCrud uc=new UserCrud();
		
		Scanner sc=new Scanner(System.in);
		boolean check=true;
		
		// to execute the code later it can check condition
		
		do {
			System.out.println("Choose your choice\n 1.save \n2.Update \n 3.delete \\n 4.retrieve \\n 5.exit\"");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:{
			System.out.println("Save");
			
			System.out.println("Enter your Id:");
			int id=sc.nextInt();
			System.out.println("Enter your name:");
			String name=sc.next();
			System.out.println("Enter your email id:");
			String email=sc.next();
			System.out.println("Enter your password:");
			String password=sc.next();
			System.out.println("Enter you phone:");
			int phone=sc.nextInt();
			
			User u=new User();
			u.setId(id);
			u.setName(name);
			u.setEmail_id(email);
			u.setPassword(password);
			u.setPhone(phone);
			
			uc.saveUser(u);
			
			System.out.println("=======Inserted========");
			
		}
		break;
		case 2:{
			System.out.println("Update");
			
			System.out.println("Enter your id:");
			int id=sc.nextInt();
			
			System.out.println("Enter your email id:");
			String email=sc.next();
			
			System.out.println("Enter your phone no:");
			int phone=sc.nextInt();
			
			User u=new User();
			u.setId(id);
			u.setEmail_id(email);
			u.setPhone(phone);
			
			uc.updateUser(u);
			
			System.out.println("=======Updated=======");
					
			
			
		}
		break;
		
		case 3:
		{
			System.out.println("Enter id");
			String name=sc.next();
			uc.deleteUser(name);
			System.out.println("=====deleted======");
			
		}break;
		
		case 4:
		{
			
			uc.retrieveUser();
		}
			
		break;
		default:check=false;
		break;
		}
		}
		
	while(check);
		System.out.println("============Thank You============");
	

}
}

	
