package com.java.basic.comparable;

import java.util.Collections;
import java.util.List;

/**
 * Created by : Rakesh Gupta on 11/27/17
 * Package : com.java.basic.comparable
 */
public class EmpManagement {
    public static void main(String[] args) {
        List<Employee> employeeArrayList = EmployeeUtil.getEmployeeList();

        Collections.sort(employeeArrayList);

        EmployeeUtil.printEmployees(employeeArrayList);
    }
}
