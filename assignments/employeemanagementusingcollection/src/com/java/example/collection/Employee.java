package com.java.example.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class Employee {
    static Scanner sc = new Scanner(System.in);
    
    
	public static void main(String[] args) {
		EmpDetails e1 = new EmpDetails();
		Set<EmpDetails> emp = new TreeSet<>();
		Employee empl = new Employee();
		
    
		//e1.addEmp();
		//e1.printDetails();
		//int choice;
		while(true) {
			System.out.println("\n");
			System.out.println("*********Employee Management Application*********");
			System.out.println();
			System.out.println("1. Add new employee");
			System.out.println("2. View all employees details");
			System.out.println("3. delete employee");
			System.out.println("4. update employee details");
			System.out.println("5. view employee detail");
			System.out.println("6. view employee by age");
			System.out.println("7. print statistics");
			System.out.println("8. Export data");
			System.out.println("9. Import data");
			System.out.println("Enter choice : ");
			int choice = sc.nextInt();
			if(choice == 0) {
				break;
			}
			switch(choice) {
			case 1:
				e1.addEmp();
				break;
				
			case 2:
				System.out.format("Eid\t name\t age\t salary\t  designation\t  DOB \n");
				System.out.println("-------------------------------------------------------");
				e1.printDetails();
			    break;
			    
			case 3:
				System.out.println("enter employee to be deleted");
				int id = sc.nextInt();
				e1.deleteDetails(id);
			    break;
			 
			case 4:
				System.out.println("enter employee to update");
				int id1 = sc.nextInt();
				e1.updateDetails(id1);
			    break;
			    
			case 5:
				System.out.println("enter employee to view details");
				int id2 = sc.nextInt();
				e1.showEmployee(id2);
				break;
	 		
			case 6:
				System.out.println("enter employee to view details");
				int id3 = sc.nextInt();
				e1.showEmpByAge(id3);
				break;
				
			case 7:
				e1.statistics();
				break;
				
			case 8:
				e1.exportData();
				break;
			
			case 9: 
				e1.importData();
								
				break;
				
			
			default:
				System.out.println("enter valid choice");
			}
		}
	}

}
