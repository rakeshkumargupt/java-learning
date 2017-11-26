package com.rakeshgupta.comparator;

import com.rakeshgupta.comparable.Employee;

import java.util.Comparator;

/**
 * Created by : Rakesh Gupta on 11/23/17
 * Package : com.rakeshgupta.comparator
 */
public class SalaryComparator implements Comparator{
    Employee employee, employee2;
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Employee && o2 instanceof Employee){
            employee = ((Employee) o1);
            employee2 = ((Employee) o2);
        }
        return employee.getEmpName().compareTo(employee2.getEmpName());
    }
}
