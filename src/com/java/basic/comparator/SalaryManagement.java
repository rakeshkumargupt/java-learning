package com.rakeshgupta.comparator;

import com.rakeshgupta.comparable.Employee;
import com.rakeshgupta.comparable.EmployeeUtil;

import java.util.Collections;
import java.util.List;

/**
 * Created by : Rakesh Gupta on 11/23/17
 * Package : com.rakeshgupta.comparator
 */
public class SalaryManagement {
    public static void main(String[] args) {
        List<Employee> employeeList = EmployeeUtil.getEmployeeList();
        Collections.sort(employeeList, new SalaryComparator());
        EmployeeUtil.printEmployees(employeeList);
    }
}
