package com.lambdas;

import java.util.List;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.domain.Employee;
import com.domain.EmployeeFactory;
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
		List<Employee> a = employeeList.stream().sorted().collect(Collectors.toList());
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
		employeeList.stream().forEach(System.out::println);

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
		System.out.println(employeeList.stream().
				filter(EmployeePredicate.getEmployeeTypePredicate()).
				collect(Collectors.toList()));
		Long end = System.currentTimeMillis();
		System.out.println("Sequential Time Taken --->" + (end - start));

		System.out.println("--------------ParalllelStream---------");
		Long start1 = System.currentTimeMillis();
		System.out.println(employeeList.parallelStream().
				filter(EmployeePredicate.getEmployeeTypePredicate()).
				collect(Collectors.toList()));
		Long end1 = System.currentTimeMillis();
		System.out.println("ParalllelStream Time Taken --->" + (end1 - start1));

		// Output
		// [{id-->1051068 fistName-->Arunprasad LastName-->A phoneNumber-->+91
		// 9600328257}, {id-->1051066 fistName-->Prasad LastName-->A phoneNumber-->+91
		// 9600328259}, {id-->10510 fistName-->Janani LastName-->A phoneNumber-->+91
		// 9600328277}]

		// Multiple Filters
		System.out.println(employeeList.stream().filter(EmployeePredicate.getEmployeeTypePredicate())
				.filter(EmployeePredicate.getFemalePredicate()).collect(Collectors.toList()));
		// Output
		// [{id-->10510 fistName-->Janani LastName-->A phoneNumber-->+91 9600328277}]

		System.out.println("--------------Distinct---------");

		// Distinct
		employeeList.stream().distinct().forEach(System.out::println);

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

		System.out.println("---------Group by start-----------");
		List<Employee> employees = EmployeeFactory.getEmployeeList();

		Map<Integer,List<Employee>> e =
				employees.stream().filter(EmployeePredicate.getAgePrediate(25)).
				collect(
						Collectors.groupingBy(Employee::getAge)
				);

		System.out.println(e);
		/**
		 * {28=[{id-->1051068 fistName-->Arunprasad LastName-->A phoneNumber-->+91 9600328257}], 45=[{id-->105100 fistName-->Janani LastName-->A phoneNumber-->+91 9600328277}], 29=[{id-->1051066 fistName-->Prasad LastName-->A phoneNumber-->+91 9600328259}], 30=[{id-->1051070 fistName-->Kumar LastName-->A phoneNumber-->+91 9600328267}]}
		 */

		//getting Employee count based on age greater then 25
		Map<Integer,Long> e1 =
				employees.stream().filter(EmployeePredicate.getAgePrediate(25)).
						collect(
								Collectors.groupingBy(
										Employee::getAge,
										Collectors.counting()
								)
						);

		System.out.println(e1);
		/**
		 * {28=1, 45=1, 29=1, 30=1}
		 */
		//getting Employee Names based on age greater then 25
		Map<Integer,List<String>> e2 =
				employees.stream().filter(EmployeePredicate.getAgePrediate(25)).
						collect(
								Collectors.groupingBy(
										Employee::getAge,
										Collectors.mapping(
												Employee::getFirst_Name,Collectors.toList()
										)
								)
						);
		System.out.println(e2);

		/**
		 * {28=[Arunprasad], 45=[Janani], 29=[Prasad], 30=[Kumar]}
		 */

		//getting Employee Names based on age greater then 25
		Map<Integer,String> e3 =
				employees.stream().filter(EmployeePredicate.getAgePrediate(25)).
						collect(
								Collectors.groupingBy(
										Employee::getAge,
										Collectors.mapping(
											Employee::getFirst_Name,
												Collectors.joining(",","(",")")
												)
								)
						);
		System.out.println(e3);
		System.out.println("---------Group by End-----------");

	}
}