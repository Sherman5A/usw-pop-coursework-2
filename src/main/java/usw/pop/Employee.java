package usw.pop;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Class representing Employee of travel agency
 */
public class Employee {
    private final LocalDate joinDate;
    private int employeeID;
    private String employeeName;
    private String address;
    private BigDecimal salary;
    private int phoneNum;
    private boolean leftCompany = false;
    private LocalDate leaveDate;

    /**
     * @param employeeName
     * @param address
     * @param salary
     * @param phoneNum
     * Creates an instance of employee
     */
    public Employee(String employeeName, String address, BigDecimal salary, int phoneNum) {
        // EmployeeID would be autogenerated
        joinDate = LocalDate.now();
        this.employeeName = employeeName;
        this.address = address;
        this.salary = salary;
        this.phoneNum = phoneNum;
    }

    /**
     * Changes status of employee to left company and records the leaving time
     */
    public void leftCompany() {
        leftCompany = true;
        leaveDate = LocalDate.now();
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
