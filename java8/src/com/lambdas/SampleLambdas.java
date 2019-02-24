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
import com.domain.EmployeeFactory;
import com.domain.EmployeeType;
import com.domain.SexType;
import com.predicate.EmployeePredicate;

public class SampleLambdas {

	private static List<Employee> employeeList;

	
	  static { System.out.println("Static Block ");
	  	employeeList=EmployeeFactory.getEmployeeList();
	  }
	 

	public List<Employee> getEmployeeList() {
		return employeeList;
	}



	public static void main(String[] args) {
		SampleLambdas lambdas = new SampleLambdas();

		// Java 8 Code
		List<Employee> a = lambdas.employeeList.stream().sorted().collect(Collectors.toList());
		a.forEach(b -> System.out.println(b));

		/*
		 * Stream.sorted() it won't modify the order in original list Output // Sorted
		 * by id based on Comparable {id-->10510 fistName-->Janani LastName-->A
		 * phoneNumber-->+91 9600328277} {id-->1051066 fistName-->Prasad LastName-->A
		 * phoneNumber-->+91 9600328259} {id-->1051068 fistName-->Arunprasad
		 * LastName-->A phoneNumber-->+91 9600328257} {id-->1051070 fistName-->Kumar
		 * LastName-->A phoneNumber-->+91 9600328267} {id-->1051071 fistName-->Sarvesh
		 * LastName-->A phoneNumber-->+91 9600328287}
		 */
		System.out.println("--------------");
		lambdas.employeeList.stream().forEach(b -> System.out.println(b));

		/*
		 * Output {id-->1051068 fistName-->Arunprasad LastName-->A phoneNumber-->+91
		 * 9600328257} {id-->1051066 fistName-->Prasad LastName-->A phoneNumber-->+91
		 * 9600328259} {id-->1051070 fistName-->Kumar LastName-->A phoneNumber-->+91
		 * 9600328267} {id-->1051071 fistName-->Sarvesh LastName-->A phoneNumber-->+91
		 * 9600328287} {id-->10510 fistName-->Janani LastName-->A phoneNumber-->+91
		 * 9600328277}
		 */
		// Older code : which will modify the order in orginal list
		/*
		 * Collections.sort(lambdas.getEmployeeList()); for (Employee e :
		 * lambdas.getEmployeeList()) { System.out.println(e); }
		 */
		System.out.println("--------------sequential Stream------------");
		Long start = System.currentTimeMillis();
		System.out.println(lambdas.employeeList.stream().filter(EmployeePredicate.employeeTypePredicate())
				.collect(Collectors.toList()));
		Long end = System.currentTimeMillis();
		System.out.println("Sequential Time Taken --->" + String.valueOf(end - start));

		System.out.println("--------------ParalllelStream---------");
		Long start1 = System.currentTimeMillis();
		System.out.println(lambdas.employeeList.parallelStream().filter(EmployeePredicate.employeeTypePredicate())
				.collect(Collectors.toList()));
		Long end1 = System.currentTimeMillis();
		System.out.println("ParalllelStream Time Taken --->" + String.valueOf(end1 - start1));

		// Output
		// [{id-->1051068 fistName-->Arunprasad LastName-->A phoneNumber-->+91
		// 9600328257}, {id-->1051066 fistName-->Prasad LastName-->A phoneNumber-->+91
		// 9600328259}, {id-->10510 fistName-->Janani LastName-->A phoneNumber-->+91
		// 9600328277}]

		// Multiple Filters
		System.out.println(lambdas.employeeList.stream().filter(EmployeePredicate.employeeTypePredicate())
				.filter(EmployeePredicate.femalePredicate()).collect(Collectors.toList()));
		// Output
		// [{id-->10510 fistName-->Janani LastName-->A phoneNumber-->+91 9600328277}]

		System.out.println("--------------Distinct---------");

		// Distinct
		lambdas.employeeList.stream().distinct().forEach(System.out::println);

		/*Output
		 * Dublicate of Employee 'Janani' will removed from Stream {id-->10510
		 * fistName-->Janani LastName-->A phoneNumber-->+91 9600328277}
		 */
		
		System.out.println("--------------Map Interface---------");
		EmployeeFactory.getEmployeeMap().forEach((key,value)->{System.out.println("Key : " + key + " Value : " + value);});
		System.out.println("--------------Map Interface---------");
		EmployeeFactory.getEmployeeMap().entrySet().forEach(entry -> {
		    System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		});
		
	}
}