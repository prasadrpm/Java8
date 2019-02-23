package com.domain;

public class Employee implements Comparable<Employee>{
//public class Employee {

	
	private String id;
	
	private String first_Name;
	
	private String last_Name;
	
	private String phone_Number;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getPhone_Number() {
		return phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		this.phone_Number = phone_Number;
	}
	
	@Override
	public String toString() {
		
		return "{id-->"+this.id+" fistName-->"+this.first_Name+
				" LastName-->"+this.last_Name+" phoneNumber-->"+this.phone_Number+"}";
	}



	@Override
	public int compareTo(Employee o) {
		return this.id.compareTo(o.id);
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return new Integer(this.id).intValue();
	}

}