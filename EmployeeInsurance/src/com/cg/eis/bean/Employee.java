package com.cg.eis.bean;

public class Employee {
	private long ID;
	private String NAME, DESIGNATION;
	private double SALARY;
	private String INSURANCE_SCHEME;
	
	public Employee(long id,String name,double salary,String designation)
	{
		setDESIGNATION(designation);
		setID(id);
		setNAME(name);
		setSALARY(salary);
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getDESIGNATION() {
		return DESIGNATION;
	}

	public void setDESIGNATION(String dESIGNATION) {
		DESIGNATION = dESIGNATION;
	}

	public double getSALARY() {
		return SALARY;
	}

	public void setSALARY(double sALARY) {
		SALARY = sALARY;
	}

	public String getINSURANCE_SCHEME() {
		return INSURANCE_SCHEME;
	}

	public void setINSURANCE_SCHEME(String iNSURANCE_SCHEME) {
		INSURANCE_SCHEME = iNSURANCE_SCHEME;
	}

}
