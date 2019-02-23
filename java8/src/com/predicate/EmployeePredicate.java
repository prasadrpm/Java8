package com.predicate;

import java.util.function.Predicate;

import com.domain.Employee;
import com.domain.EmployeeType;
import com.domain.SexType;

public class EmployeePredicate {
	
	public static Predicate<Employee> employeeTypePredicate(){
		return e->e.getEmp_type().equals(EmployeeType.Permanent.toString());
	}

	public static Predicate<Employee> femalePredicate(){
		return e->e.getSex().equals(SexType.Female.toString());
	}
	
}
