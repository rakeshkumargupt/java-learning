package com.java.basic.comparator;

import com.java.basic.comparable.*;

import java.util.Collections;
import java.util.List;

/**
 * Created by : Rakesh Gupta on 11/27/17
 * Package : com.java.basic.comparable
 */
public class SalaryManagement {
    public static void main(String[] args) {
        List<Employee> employeeList = EmployeeUtil.getEmployeeList();
        Collections.sort(employeeList, new SalaryComparator());
        EmployeeUtil.printEmployees(employeeList);
    }
}
