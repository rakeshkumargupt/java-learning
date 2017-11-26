package com.rakeshgupta.comparable;

/**
 * Created by : Rakesh Gupta on 11/23/17
 * Package : com.rakeshgupta.comparable
 */
public class Employee implements Comparable{
    private int empId;
    private String empName;
    private long empMobile;
    private String empAddr;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public long getEmpMobile() {
        return empMobile;
    }

    public void setEmpMobile(long empMobile) {
        this.empMobile = empMobile;
    }

    public String getEmpAddr() {
        return empAddr;
    }

    public void setEmpAddr(String empAddr) {
        this.empAddr = empAddr;
    }

    public int compareTo(Object o) {
        return (this.empId - ((Employee)o).empId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + empId +
                ", Name='" + empName + '\'' +
                ", Mobile=" + empMobile +
                ", Address='" + empAddr + '\'' +
                '}';
    }
}
