package com.masai.ui;

import java.util.List;
import java.util.Scanner;

import com.masai.entities.Department;
import com.masai.exceptions.DepartmentNotFound;
import com.masai.exceptions.EmployeeNotFound;
import com.masai.exceptions.SomeThingWentWrongException;
import com.masai.services.DepartmentService;
import com.masai.services.DepartmentServiceImpl;
import com.masai.services.EmployeeService;
import com.masai.services.EmployeeServiceImpl;

public class AdminUI {
	
	static DepartmentService departmentService = new DepartmentServiceImpl();
	static EmployeeService employeeService = new EmployeeServiceImpl();
	
	
	
	static void adminLogin(Scanner sc) throws SomeThingWentWrongException, DepartmentNotFound, EmployeeNotFound {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		if(username.equals("admin") && password.equals("admin")) {
			adminMenu(sc);
		}else {
			System.out.println("Invalid Credentials");
		}
	}
	
	static void displayAdminMenu() {
		System.out.println("1. Add a Department");
		System.out.println("2. View All the Departments");
		System.out.println("3. Update the Department name");
		System.out.println("4. Register a new Employee");
		System.out.println("5. Change the Department of an Employee");
		System.out.println("6. Approve or Deny Leave requests");
		System.out.println("7. Fire an Employee");
		System.out.println("0. Logout");
	}
	
	static void adminMenu(Scanner sc) throws SomeThingWentWrongException, DepartmentNotFound, EmployeeNotFound {
	    int choice = 0;

	    try {
			
	    	do {
		        displayAdminMenu();
		        System.out.print("Enter selection: ");
		        choice = sc.nextInt();
		        
		        switch (choice) {
		            case 1:
		                addDepartment();
		                break;
		            case 2:
		                viewDepartment();
		                break;
		            case 3:
		                updateDepartmentName();
		                break;
		            case 4:
		                registerEmployee();
		                break;
		            case 5:
		                changeDepartment();
		                break;
		            case 6:
		                approveLeaveRequest();
		                break;
		            case 7:
		                fireEmployee();
		                break;
		            case 0:
		                System.out.println("Bye Bye, Admin!");
		                break;
		            default:
		                System.out.println("Invalid selection. Please try again.");
		        }
		    } while (choice != 0);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	

	
	static void addDepartment() throws SomeThingWentWrongException {
		//DepartmentService departmentService = new DepartmentServiceImpl();
		departmentService.addDepartment();
		System.out.println("Department Added");
	}
	
	static void viewDepartment() throws DepartmentNotFound, SomeThingWentWrongException {
		//DepartmentService departmentService = new DepartmentServiceImpl();
		List<Department> departmentList = departmentService.viewDepartment();
		System.out.println(departmentList.toString());
	}
	
	static void updateDepartmentName() throws DepartmentNotFound, SomeThingWentWrongException {
		//DepartmentService departmentService = new DepartmentServiceImpl();
		departmentService.updateDepartmentName();
	}

	static void registerEmployee() throws DepartmentNotFound, SomeThingWentWrongException, EmployeeNotFound {
		//DepartmentService departmentService = new DepartmentServiceImpl();
		employeeService.registerEmployee();
	}

	static void changeDepartment() throws DepartmentNotFound, SomeThingWentWrongException, EmployeeNotFound {
		//DepartmentService departmentService = new DepartmentServiceImpl();
		departmentService.changeDepartment();
	}
	
	
	static void approveLeaveRequest() {
		//DepartmentService departmentService = new DepartmentServiceImpl();
		employeeService.approveLeaveRequest();
	}

	static void fireEmployee(){
		//DepartmentService departmentService = new DepartmentServiceImpl();
		employeeService.fireEmployee();
	}
}
