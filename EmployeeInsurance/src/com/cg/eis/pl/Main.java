package com.cg.eis.pl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

import com.cg.eis.service.EmployeeServiceImp;

public class Main {
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader buff = new BufferedReader(isr);
	EmployeeServiceImp obj=new EmployeeServiceImp();

	public void initData() {

		System.out.println("Enter the id:");
		try {
			Long id = Long.parseLong(buff.readLine());
			System.out.println("Enter the name:");
			String name = buff.readLine();
			System.out.println("Enter the salary:");
			double salary = Double.parseDouble(buff.readLine());
			System.out.println("Enter the designation:");
			String designation = buff.readLine();
			System.out.println("check");
			obj.addEmployee(id, name, designation, salary);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void displayMenu() {
			do {
	System.out.println("1.Get employee details from user\n2.Find insurance scheme\n3.Display user details ");
				try {
				int ch = Integer.parseInt(buff.readLine());
				switch (ch) {
				case 1:
					initData();
					break;
				case 2:
					System.out.println("Enter the id:");
					long id = Long.parseLong(buff.readLine());
					obj.findInsuranceScheme(id);
					break;
				case 3:
					System.out.println("Enter the id:");
					long Id = Long.parseLong(buff.readLine());
					obj.printDetails(Id);
				}

			
		} catch (Exception e) {
			System.out.println(e);
		}} while (true);
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.displayMenu();
	}

}
