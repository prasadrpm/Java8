package com.predicate;

import java.util.function.Predicate;

import com.domain.Employee;
import com.domain.EmployeeType;

public class EmployeePredicate {
	
	public static Predicate<Employee> employeeTypePredicate(){
		return e->e.getEmp_type().equals(EmployeeType.Permanent.toString());
	}

	
	
}
