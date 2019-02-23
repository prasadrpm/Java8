package com.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.domain.Employee;
import com.domain.EmployeeType;
import com.domain.SexType;
import com.predicate.EmployeePredicate;

public class SampleLambdas {
	
	private List<Employee> employeeList;
	
	/*static {
		System.out.println("Static Block ");
		
	}*/

	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public SampleLambdas() {
		System.out.println("Constructing Employee List  ");
		
		employeeList = new ArrayList<Employee>();
		
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
		employeeList.add(e5);
		
		System.out.println("Construction of Employee List done");

	}
	
	
	public static void main(String[] args) {
		SampleLambdas lambdas = new SampleLambdas();
		
		//Java 8 Code
		List<Employee> a =  lambdas.employeeList.stream().sorted().collect(Collectors.toList());
		a.forEach(b->System.out.println(b));
		
		
/*	Stream.sorted() it won't modify the order in original list 	
 * Output // Sorted by id based on Comparable
 * 		{id-->10510 fistName-->Janani LastName-->A phoneNumber-->+91 9600328277}
		{id-->1051066 fistName-->Prasad LastName-->A phoneNumber-->+91 9600328259}
		{id-->1051068 fistName-->Arunprasad LastName-->A phoneNumber-->+91 9600328257}
		{id-->1051070 fistName-->Kumar LastName-->A phoneNumber-->+91 9600328267}
		{id-->1051071 fistName-->Sarvesh LastName-->A phoneNumber-->+91 9600328287}
*/
		System.out.println("--------------");
		lambdas.employeeList.stream().forEach(b->System.out.println(b));

/*	Output		
 * {id-->1051068 fistName-->Arunprasad LastName-->A phoneNumber-->+91 9600328257}
		{id-->1051066 fistName-->Prasad LastName-->A phoneNumber-->+91 9600328259}
		{id-->1051070 fistName-->Kumar LastName-->A phoneNumber-->+91 9600328267}
		{id-->1051071 fistName-->Sarvesh LastName-->A phoneNumber-->+91 9600328287}
		{id-->10510 fistName-->Janani LastName-->A phoneNumber-->+91 9600328277}
*/
		//Older code : which will modify the order in orginal list
		/*Collections.sort(lambdas.getEmployeeList());
		for (Employee e : lambdas.getEmployeeList()) {
			System.out.println(e);
		}*/
		System.out.println("--------------sequential Stream------------");
		Long start = System.currentTimeMillis();
		System.out.println(lambdas.employeeList.stream().filter(EmployeePredicate.employeeTypePredicate()).collect(Collectors.toList()));
		Long end = System.currentTimeMillis();
		System.out.println("Sequential Time Taken --->"+String.valueOf(end-start));

		System.out.println("--------------ParalllelStream---------");
		Long start1 = System.currentTimeMillis();
		System.out.println(lambdas.employeeList.parallelStream().filter(EmployeePredicate.employeeTypePredicate()).collect(Collectors.toList()));
		Long end1 = System.currentTimeMillis();
		System.out.println("ParalllelStream Time Taken --->"+String.valueOf(end1-start1));

		
		
		//Output
		//[{id-->1051068 fistName-->Arunprasad LastName-->A phoneNumber-->+91 9600328257}, {id-->1051066 fistName-->Prasad LastName-->A phoneNumber-->+91 9600328259}, {id-->10510 fistName-->Janani LastName-->A phoneNumber-->+91 9600328277}]

		//Multiple Filters
		System.out.println(lambdas.employeeList.stream().filter(EmployeePredicate.employeeTypePredicate()).filter(EmployeePredicate.femalePredicate()).collect(Collectors.toList()));
		//Output
		//[{id-->10510 fistName-->Janani LastName-->A phoneNumber-->+91 9600328277}]

		System.out.println("--------------Distinct---------");

		//Distinct
		lambdas.employeeList.stream().distinct().forEach(System.out::println);

/*		Dublicate of Employee 'Janani' will removed from Stream
		{id-->10510 fistName-->Janani LastName-->A phoneNumber-->+91 9600328277}*/
	}
}