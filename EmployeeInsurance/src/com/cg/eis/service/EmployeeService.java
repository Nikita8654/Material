package com.cg.eis.service;

public interface EmployeeService {
	
	public void addEmployee(long id,String name,String designation,double salary);
	public void findInsuranceScheme(Long id);
	public void  printDetails(Long id);

}
