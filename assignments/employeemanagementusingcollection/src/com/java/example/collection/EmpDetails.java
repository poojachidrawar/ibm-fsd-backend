package com.java.example.collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
//import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;





public class EmpDetails implements Comparable<EmpDetails>, java.io.Serializable {
	
	private static final long serialVersionUID = -7987392421065096695L;
	
	@FunctionalInterface
    public interface ValidateEmployee{
		public boolean check(EmpDetails emp);
	}
	
	public boolean validate(EmpDetails emp, ValidateEmployee validator) {
		return validator.check(emp);
	}
	
	static Scanner in = new Scanner(System.in);
	//EmpDetails emps = new EmpDetails();
     Set<EmpDetails> emp = new TreeSet<>();
	
/*
	   	LocalDate date1 = ((EmpDetails)emp).getDob();
	    
	    LocalDate date2= LocalDate.now();
	    
	    Period period = Period.between(date1, date2);
	    int ages = period.getYears();
*/

     
	private int Eid;
	private String name;
	private int age;
	private int salary;
	private String designation;
	private LocalDate Dob;
	
	public EmpDetails() {
		//System.out.println("default constructor");
		
        
		
		EmpDetails emp1 = new EmpDetails(1,"John",22,343234,"manager",LocalDate.parse("1996-01-23"));
		EmpDetails emp2 = new EmpDetails(2,"bob",22,33232,"tester",LocalDate.parse("1996-02-04"));
		EmpDetails emp3 = new EmpDetails(3,"Jack",23,35000,"developer",LocalDate.parse("1995-03-30"));
		EmpDetails emp4 = new EmpDetails(4,"Tom",24,45000,"developer",LocalDate.parse("1994-04-15"));
		EmpDetails emp5 = new EmpDetails(5,"Roger",23,46000,"manager",LocalDate.parse("1995-06-18"));
	
		emp.add(emp1);
		emp.add(emp2);
		emp.add(emp3);
		emp.add(emp4);
		emp.add(emp5);
		
	
	}
	
	public LocalDate getDob() {
		return Dob;
	}

	public void setDob(LocalDate dob) {
		Dob = dob;
		
	}
	
	
	public EmpDetails(int id, String name, int age, int salary, String designation, LocalDate Dob) {
		super();
		this.Eid = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.designation = designation;
		this.Dob = Dob;
		
	}
	

	@Override
	public String toString() {
		return (Eid+" "+name+" "+age+" "+salary+" "+designation+" "+Dob);
		
	}

	public int getEid() {
		return Eid;
	}

	public void setEid(int eid) {
		Eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public void printDetails() {
		
     	for(Object o:emp) {
     			
	       System.out.format("%d\t %s\t %d\t %d\t  %s\t %s\t \n", ((EmpDetails)o).getEid(), ((EmpDetails)o).getName(), 
	    		   ((EmpDetails)o).getAge(), ((EmpDetails)o).getSalary(), ((EmpDetails)o).getDesignation(), ((EmpDetails)o).getDob());
			//System.out.println(o);       
	       //System.out.println("Period is:"+ages);
		}
		
		
	}
	
	public void deleteDetails(int Eid) {
		EmpDetails empl=null;
		for(EmpDetails e:emp) {
			if(e.getEid()==Eid) {
				empl = e;
			}
		}
		if(empl!=null) {
			emp.remove(empl);
			System.out.println("employee deleted successfully");
		}else {
			System.out.println("employee not available");
		}
		
	}
	
	
	public void updateDetails(int id1) {
		for(EmpDetails e:emp) {
			if(e.getEid()==id1) {
			
				
		
				System.out.println("enter name :");
				String name = in.next();
						
				System.out.println("Enter age :");
				int age = in.nextInt();
							
				System.out.println("enter salary :");
				int salary = in.nextInt();
				
				System.out.println("enter designation :");
				String des = in.next();
				
			     
			    System.out.println("Employee updated successfully");
			    
			    e.setName(name);
			    e.setAge(age);
			    e.setSalary(salary);
			    e.setDesignation(des);

			    //EmpDetails e1 = new EmpDetails(id1,name, age, salary, des);	
			    //emp.add(e1);
			}
		}
	}
	
	public void showEmployee(int id) {
		for(EmpDetails e:emp) {
			if(e.getEid() == id) {
				System.out.println(e);
			}
		}	
	}
	
	public void showEmpByDesignation(String designation) {
		for(EmpDetails e:emp) {
			if(e.getDesignation() == designation) {
				System.out.println(emp);
			}
		}	
	}
	
	public void showEmpByAge(int age) {
		for(EmpDetails e:emp) {
			if(e.getAge()==age) {
				System.out.println(e);
				
			}
		}
		//System.out.println(emp.size());
	}
	
	
	public void statistics() {
		List count = new ArrayList();
		
		//get employee list greater  than age 23
	    count = emp.stream().filter(e->e.getAge()>23).map(e->e.getEid()).collect(Collectors.toList());
	    System.out.println("\n List of employees whose age greater than 23 are :"+count);
	    
	    //designations with more No. of employees
	    count = emp.stream().collect(Collectors.groupingBy(EmpDetails::getDesignation, Collectors.counting()))
	    .entrySet().stream().filter(e->e.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
	    System.out.println("\n designations with more No. of employees: "+count);
	    
	    //count = count2.entrySet().stream().filter(e->e.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
	    
	    //employee name starts with given letter
	    count = emp.stream().filter(e->e.getName().startsWith("J")).collect(Collectors.toList());
	    System.out.println("\n employees starts with letter 'J' :"+count);
	    
	    //No. of employees whose age greater than 23
		long count1;
	    count1 = emp.stream().filter(e->e.getAge()>23).count();
	    System.out.println("\n No. of employees whose age greater than 23 are :"+count1);
	    
	    
	    
	    Map count2 = new TreeMap();
	    
	    //designation wise count of employees
	    count2 = emp.stream().collect(Collectors.groupingBy(EmpDetails::getDesignation, Collectors.counting()));
	    System.out.println("\n designation wise count of employees :"+count2);
	    
	    //designation wise average salary
	    count2 = emp.stream()
	    		.collect(Collectors.groupingBy(EmpDetails::getDesignation, Collectors.averagingInt(EmpDetails::getSalary)));
	    System.out.println("\n avg salary by designation is:"+count2);
	    
	    //count of employees with sorted designation
	    count2 = emp.stream().sorted(Comparator.comparing(EmpDetails::getDesignation))
	    		.collect(Collectors.groupingBy(EmpDetails::getDesignation, TreeMap::new, Collectors.counting()));
	    System.out.println("\n count of employees with sorted designation :"+count2);
	    
	    //Total salary of all employees
	    int totalsal = emp.stream().map(EmpDetails::getSalary).reduce(0, (a,b) -> a.intValue() + b.intValue()).intValue();
	    System.out.println("\n Total salary of all employees :"+totalsal);
	    
	    //Average salary of all employees
	    int avgSalary = emp.stream().collect(Collectors.averagingInt(EmpDetails::getSalary)).intValue();
	    System.out.println("\n Average salary of all employees :"+avgSalary);
			
	    
	    
	}
	
	
	public void addEmp() {
		
		//EmpDetails[] emp = new EmpDetails[2];
		
		
		System.out.println("Enter details");
		
		
		System.out.println("enter id :");
		int id = in.nextInt();
		//System.out.println("id is:"+id);
		
		System.out.println("enter name :");
		String name = in.next();
		//System.out.println("name: "+name);
		
		System.out.println("Enter age :");
		int age = in.nextInt();
		//System.out.println("age is: "+age);
		
		System.out.println("enter salary :");
		int salary = in.nextInt();
		//System.out.println("salary is :" +salary);
		
		System.out.println("enter designation :");
		String des = in.next();
		//System.out.println("designation :"+des);
		
		System.out.println("enter dob");
		String dob = in.next();
		LocalDate date = LocalDate.parse(dob);
		
		EmpDetails e1 = new EmpDetails(id, name, age, salary, des, date);	
		/*
        boolean valStatus = e1.validate(e1, e-> e.getAge()>0 && e.getSalary()>0);
		
		if(valStatus) {
		System.out.println("Employee details saved");
	
		}else {
			System.out.println("invalid employee details entered");
		}*/
		
	    emp.add(e1);
	    System.out.println("Employee added successfully");
		}
	
	public void exportData() {
		
		EmpDetails emps = new EmpDetails();
		try {
			FileOutputStream fileOut = new FileOutputStream("C:\\FileIO\\employees.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(emps);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in : C:\\FileIO\\employees.txt");
		} catch (IOException i) {
			i.printStackTrace();
		}

	}
	
	public void importData() {
		EmpDetails e = null;
		try {
	         FileInputStream fileIn = new FileInputStream("C:\\FileIO\\employees.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e =  (EmpDetails) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
          System.out.println("Deserialized Employee...");
////          System.out.println("Id: " + e.Eid);
////          System.out.println("Name: " + e.name);
////	      System.out.println("Age: "+e.age);
////	      System.out.println("Salary: "+e.salary);
////	      System.out.println("Designation: "+e.designation);
////	      System.out.println("DOB: "+e.Dob);
////	      
          for(Object o:emp) {
   			
   	       System.out.format("%d\t %s\t %d\t %d\t  %s\t %s\t \n", ((EmpDetails)o).getEid(), ((EmpDetails)o).getName(), 
   	    		   ((EmpDetails)o).getAge(), ((EmpDetails)o).getSalary(), ((EmpDetails)o).getDesignation(), ((EmpDetails)o).getDob());
          }

	}
//

	
//	public synchronized void bulkImport() {
//		int counter = 0;
//		try(Scanner in = new Scanner(new FileReader("C:\\FileIO\\employees.txt")))
//	}
//	
	@Override
	public int compareTo(EmpDetails emp) {
			if(Eid>emp.Eid) {
			    return 1;
		    }else if(Eid<emp.Eid) {
			    return -1;
		    }else {
			   return 0;
		    }
	
	 }
	
}

