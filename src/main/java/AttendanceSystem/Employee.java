package AttendanceSystem;

import java.sql.Time;

public class Employee{
    String name;
    int age;
    String empId;
    float overtimeRate;
    float salaryPerDay;
    Time inTime;
    Time outTime;

    Employee(String name, int age, String empId , float overtimeRate, float salaryPerDay){
        this.name = name;
        this.age = age;
        this.empId = empId;
        this.overtimeRate = overtimeRate;
        this.salaryPerDay = salaryPerDay;
    }
    
}