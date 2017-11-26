package com.rakeshgupta.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by : Rakesh Gupta on 11/23/17
 * Package : com.rakeshgupta.comparable
 */
public class EmpManagement {
    public static void main(String[] args) {
        List<Employee> employeeArrayList = EmployeeUtil.getEmployeeList();

        Collections.sort(employeeArrayList);

        EmployeeUtil.printEmployees(employeeArrayList);
    }
}
