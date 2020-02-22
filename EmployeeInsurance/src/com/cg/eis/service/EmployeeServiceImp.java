package com.cg.eis.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import com.cg.eis.bean.Employee;

public class EmployeeServiceImp implements EmployeeService {
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader buff = new BufferedReader(isr);
	HashMap<Long, Employee> hm = new HashMap<Long, Employee>();

	@Override
	public void addEmployee(long id, String name, String designation, double salary) {

		Employee emp = new Employee(id, name, salary, designation);
		hm.put(id, emp);

	}

	@Override
	public void findInsuranceScheme(Long id) {
		if (hm.containsKey(id)) {
			hm.forEach((k, emp) -> {
				if (emp.getSALARY() > 5000 && emp.getSALARY() < 20000
						&& emp.getDESIGNATION().equalsIgnoreCase("System Associate"))
					System.out.println("Scheme C");
				else if (emp.getSALARY() >= 20000 && emp.getSALARY() < 40000
						&& emp.getDESIGNATION().equalsIgnoreCase("Programmer"))
					System.out.println("Scheme B");
				else if (emp.getSALARY() >= 40000 && emp.getDESIGNATION().equalsIgnoreCase("Manager"))
					System.out.println("Scheme A");
				else
					System.out.println("No Scheme");
			});

		}
		else
		{
			System.out.println("NO Such ID exists!!");
		}
	}

	@Override
	public void printDetails(Long id) {
		if (hm.containsKey(id)) {
			hm.forEach((k, employee) -> {
				System.out.println(employee.getNAME()+"\n"+employee.getDESIGNATION()+"\n"+employee.getSALARY());
			});
		}

	}

}
