package com.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeFactory {
	
	
	public static List<Employee> getEmployeeList() {
		List<Employee> employeeList = new ArrayList<Employee>();

		Employee e1 = new Employee();
		e1.setId("1051068");
		e1.setFirst_Name("Arunprasad");
		e1.setLast_Name("A");
		e1.setPhone_Number("+91 9600328257");
		e1.setEmp_type(EmployeeType.Permanent.toString());
		e1.setSex(SexType.Male.toString());
		employeeList.add(e1);

		Employee e2 = new Employee();
		e2.setId("1051066");
		e2.setFirst_Name("Prasad");
		e2.setLast_Name("A");
		e2.setPhone_Number("+91 9600328259");
		e2.setEmp_type(EmployeeType.Permanent.toString());
		e2.setSex(SexType.Male.toString());
		employeeList.add(e2);

		Employee e3 = new Employee();
		e3.setId("1051070");
		e3.setFirst_Name("Kumar");
		e3.setLast_Name("A");
		e3.setPhone_Number("+91 9600328267");
		e3.setEmp_type(EmployeeType.Temporary.toString());
		e3.setSex(SexType.Male.toString());
		employeeList.add(e3);

		Employee e4 = new Employee();
		e4.setId("1051071");
		e4.setFirst_Name("Sarvesh");
		e4.setLast_Name("A");
		e4.setPhone_Number("+91 9600328287");
		e4.setEmp_type(EmployeeType.Temporary.toString());
		e4.setSex(SexType.Male.toString());
		employeeList.add(e4);

		Employee e5 = new Employee();
		e5.setId("10510");
		e5.setFirst_Name("Janani");
		e5.setLast_Name("A");
		e5.setPhone_Number("+91 9600328277");
		e5.setEmp_type(EmployeeType.Permanent.toString());
		e5.setSex(SexType.Female.toString());
		employeeList.add(e5);
		
		
		Employee e6 = new Employee();
		e6.setId("105100");
		e6.setFirst_Name("Janani");
		e6.setLast_Name("A");
		e6.setPhone_Number("+91 9600328277");
		e6.setEmp_type(EmployeeType.Permanent.toString());
		e6.setSex(SexType.Female.toString());
		employeeList.add(e6);
		
		return employeeList;
	}

	public static Map<String, Employee> getEmployeeMap() {
		Map<String , Employee> empMap = new HashMap<>();
		
		Employee e1 = new Employee();
		e1.setId("1051068");
		e1.setFirst_Name("Arunprasad");
		e1.setLast_Name("A");
		e1.setPhone_Number("+91 9600328257");
		e1.setEmp_type(EmployeeType.Permanent.toString());
		e1.setSex(SexType.Male.toString());
		empMap.put("1051068", e1);

		Employee e2 = new Employee();
		e2.setId("1051066");
		e2.setFirst_Name("Prasad");
		e2.setLast_Name("A");
		e2.setPhone_Number("+91 9600328259");
		e2.setEmp_type(EmployeeType.Permanent.toString());
		e2.setSex(SexType.Male.toString());
		empMap.put("1051066", e2);

		Employee e3 = new Employee();
		e3.setId("1051070");
		e3.setFirst_Name("Kumar");
		e3.setLast_Name("A");
		e3.setPhone_Number("+91 9600328267");
		e3.setEmp_type(EmployeeType.Temporary.toString());
		e3.setSex(SexType.Male.toString());
		empMap.put("1051070", e3);

		Employee e4 = new Employee();
		e4.setId("1051071");
		e4.setFirst_Name("Sarvesh");
		e4.setLast_Name("A");
		e4.setPhone_Number("+91 9600328287");
		e4.setEmp_type(EmployeeType.Temporary.toString());
		e4.setSex(SexType.Male.toString());
		empMap.put("1051071", e4);

		Employee e5 = new Employee();
		e5.setId("10510");
		e5.setFirst_Name("Janani");
		e5.setLast_Name("A");
		e5.setPhone_Number("+91 9600328277");
		e5.setEmp_type(EmployeeType.Permanent.toString());
		e5.setSex(SexType.Female.toString());
		empMap.put("10510", e5);
		
		
		Employee e6 = new Employee();
		e6.setId("105100");
		e6.setFirst_Name("Janani");
		e6.setLast_Name("A");
		e6.setPhone_Number("+91 9600328277");
		e6.setEmp_type(EmployeeType.Permanent.toString());
		e6.setSex(SexType.Female.toString());
		empMap.put("105100", e6);
		
		
		
		return empMap;
	}
}
