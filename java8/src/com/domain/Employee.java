package com.domain;

import java.util.Date;
import java.util.StringJoiner;


public class Employee implements Comparable<Employee>{
//public class Employee {

	
	private String id;
	
	private String first_Name;
	
	private String last_Name;
	
	private String phone_Number;

	private String emp_type;
	
	private String sex;

	private Integer age;

	private Date date_of_birth;
	
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
	
	public String getEmp_type() {
		return emp_type;
	}
	public void setEmp_type(String emp_type) {
		this.emp_type = emp_type;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}


	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Override
	public String toString() {
		StringJoiner sj = new StringJoiner(",","{","}");
		sj.add("id: ").add(this.id).add("firstName : ").add(this.first_Name).
				add("LastName : ").add(this.last_Name).add("Phone Number : ").add(this.phone_Number).
				add("Age : ").add(this.age.toString());


		return sj.toString();
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