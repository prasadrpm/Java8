package com.predicate;

import java.util.function.Predicate;

import com.domain.Employee;
import com.domain.EmployeeType;
import com.domain.SexType;


public interface EmployeePredicate {
	
	public static  Predicate<Employee> getEmployeeTypePredicate(){
		return e->e.getEmp_type().equals(EmployeeType.Permanent.toString());
	}

	public static Predicate<Employee> getFemalePredicate(){
		return e->e.getSex().equals(SexType.Female.toString());
	}

	/**
	 *  getting employee greater then passed age
	 * @param age
	 * @return
	 */
	static Predicate<Employee> getAgePrediate(Integer age){
		return e->e.getAge()> age;
	}

}
