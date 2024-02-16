package usw.pop;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {
    private int employeeID;
    private String employeeName;
    private String address;
    private BigDecimal salary;
    private int phoneNum;

    private final Date joinDate;
    private boolean leftCompany = false;
    private Date leaveDate;

    public Employee(String employeeName, String address, BigDecimal salary, int phoneNum) {
        joinDate = new Date();
        this.employeeName = employeeName;
        this.address = address;
        this.salary = salary;
        this.phoneNum = phoneNum;
    }

    public void leftCompany() {
        leftCompany = true;
        leaveDate = new Date();
    }

    // Getters
    public int getEmployeeID() {
        return employeeID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
