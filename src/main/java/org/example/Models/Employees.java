package org.example.Models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employees {

    private int EmployeeID;
    private String fisrt_name;
    private String last_name;
    private String email;
    private double phone;
    private int hire_date;
    private int job_id;
    private int salary;
    private int manage;
    private int department_id;

    public Employees(int employeeID, String fisrt_name, String last_name, String email, double phone, int hire_date, int job_id, int salary, int manage, int department_id) {
        EmployeeID = employeeID;
        this.fisrt_name = fisrt_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.hire_date = hire_date;
        this.job_id = job_id;
        this.salary = salary;
        this.manage = manage;
        this.department_id = department_id;
    }
    public Employees(ResultSet rs) throws SQLException {

        EmployeeID = rs.getInt("EmployeeID");
        fisrt_name = rs.getString("fisrt_name");
        last_name = rs.getString("last_name");
        email = rs.getString("email");
        phone = rs.getDouble("phone");
        hire_date = rs.getInt("hire_date");
        job_id = rs.getInt("job_id");
        salary = rs.getInt("salary");
        manage = rs.getInt("manage");
        department_id = rs.getInt("department_id");



    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getFisrt_name() {
        return fisrt_name;
    }

    public void setFisrt_name(String fisrt_name) {
        this.fisrt_name = fisrt_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPhone() {
        return phone;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }

    public int getHire_date() {
        return hire_date;
    }

    public void setHire_date(int hire_date) {
        this.hire_date = hire_date;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getManage() {
        return manage;
    }

    public void setManage(int manage) {
        this.manage = manage;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeID=" + EmployeeID +
                ", fisrt_name='" + fisrt_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", hire_date=" + hire_date +
                ", job_id=" + job_id +
                ", salary=" + salary +
                ", manage=" + manage +
                ", department_id=" + department_id +
                '}';
    }
}

}
