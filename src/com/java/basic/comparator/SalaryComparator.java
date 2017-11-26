package com.java.basic.comparator;

import com.java.basic.comparable.*;

import java.util.Comparator;

/**
 * Created by : Rakesh Gupta on 11/27/17
 * Package : com.java.basic.comparable
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
