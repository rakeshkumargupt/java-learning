package com.rakeshgupta.comparable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by : Rakesh Gupta on 11/23/17
 * Package : com.rakeshgupta.comparable
 */
public class EmployeeUtil {
    public static List<Employee> getEmployeeList(){
        Employee employee = new Employee();
        employee.setEmpId(1009);
        employee.setEmpName("Vishal Kumar");
        employee.setEmpMobile(9919099190L);
        employee.setEmpAddr("Bihar");

        Employee employee2 = new Employee();
        employee2.setEmpId(1001);
        employee2.setEmpName("Shankar Gouda");
        employee2.setEmpMobile(9919099199L);
        employee2.setEmpAddr("Bangalore");

        Employee employee3 = new Employee();
        employee3.setEmpId(201);
        employee3.setEmpName("Ravi Kumar");
        employee3.setEmpMobile(991991999L);
        employee3.setEmpAddr("UP");

        List<Employee> employeeArrayList = new ArrayList<Employee>();
        employeeArrayList.add(employee);
        employeeArrayList.add(employee2);
        employeeArrayList.add(employee3);

        return employeeArrayList;
    }

    public static void printEmployees(List<Employee> employees){
        for (Employee employee : employees){
            System.out.println(employee);
        }
    }
}
