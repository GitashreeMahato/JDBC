package jdbcPrepared.employee;

import java.util.Scanner;

public class EmployeeMain {
	public static void main(String[] args) throws Exception {
		
		System.out.println("===========Welcome=========");
		Scanner sc=new Scanner(System.in);
		EmployeeCurd curd= new EmployeeCurd();
		
		boolean check=true;
		
		
		do {
			System.out.println("Choose your option:\n 1. Save \n 2. Update \n 3. Delete \n 4. Retrive by Id \n 5.Retrive All \n 6. Login \n 7. Exit");

			int choice=sc.nextInt();
			
			
			switch(choice) {
			case 1:{
				System.out.println("Enter the data to save");
				
				System.out.println("Enter id");
				int id=sc.nextInt();
				System.out.println("Enter name");
				String name=sc.next();
				System.out.println("Enter phone");
				String phone=sc.next();
				System.out.println("Enter emailid");
				String emailid=sc.next();
				Employee emp= new Employee();
				emp.setId(id);
				emp.setName(name);
				emp.setPhone(phone);
				emp.setEmailid(emailid);
				curd.saveEmployee(emp);
				
				
				
				System.out.println("**********Inserted***********");
			}break;
			
			case 2:{
				System.out.println("Enter the data to update");
				System.out.println("Enter name");
				String name=sc.next();
				System.out.println("Enter phone");
				String phone=sc.next();
				System.out.println("Enter id");
				int id=sc.nextInt();
				Employee emp= new Employee();
				emp.setName(name);
				emp.setPhone(phone);
				emp.setId(id);
				curd.updateEmployee(emp);
				System.out.println("************Updated*************");
			}break;
			
			case 3:{
				System.out.println("Enter the id to delete the data");
				
				System.out.println("Enter id");
				int id=sc.nextInt();
				curd.deleteEmployee(id);
				System.out.println("************Deleted*************");
				
			}break;
			
			case 4:{
				System.out.println("Enter the id to retrive the data");
				curd.retrieveUser();
			}break;
			case 5:{
				System.out.println("all employee details");
			}break;
			
			case 6:{
				System.out.println("login");
				boolean success =curd.loginUser();
				if(success) {
					System.out.println("logged in successsfully");
				}
				else {
					System.out.println("pls provide correct details");
					curd.loginUser();
				}
			}break;
			
			case 7:{
				 check=false;
				}break;

				default: {
					System.out.println("pls choose the above mentioned numbers");
				}
					break;
				}
			
		}while(check);
		
		System.out.println("============Thank You===========");
		
		
	}

}
