package AttendanceSystem;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Employee{
    public String name;
    public int age;
    public String empId;
    public float overtimeRate;
    public float salaryPerDay;
    public Date inTime;
    public Date outTime;
    public Boolean isWorking;
    public List<Date> inTimeList;
    public List<Date> outTimeList;
    public List<Long> hrsWorked;
    public int WorkingHrs;
    public Date startDay;
    public int TotalDays;
    public int TotalHrsWorked;
    public int overTimeHrs;
    public long salary;
    public int daysWorked;

    Employee(String name, int age, String empId , float overtimeRate, float salaryPerDay){
        this.name = name;
        this.age = age;
        this.empId = empId;
        this.overtimeRate = overtimeRate;
        this.salaryPerDay = salaryPerDay;
        isWorking = false;
        inTimeList = new ArrayList<Date>();
        outTimeList = new ArrayList<Date>();
        hrsWorked = new ArrayList<Long>();
        WorkingHrs = 8;
        startDay = new Date();
    }
    
    public void attendancePunch() {
    	if(isWorking) {
    		//exit
    		outTime = new Date();
    		outTimeList.add(outTime);
    		isWorking = false;
    		System.out.println("Exit " + name + " : " + outTime.toString());
    	}else {
    		inTime = new Date();
    		inTimeList.add(inTime);
    		isWorking = true;
    		System.out.println("In Time " + name + " : " + inTime.toString());
    	}
    }
    
    public void getHrs(int index) {
    	long diff = outTimeList.get(index).getTime() - inTimeList.get(index).getTime(); 
		long diffHours = diff / (60 * 60 * 1000);
		hrsWorked.add(diffHours);
		//System.out.println(diff);
    }
    
    //Days Worked
    public int getDays() {
    	Date currentDay = new Date();
    	long diff = currentDay.getTime() - startDay.getTime(); 
    	long diffDays = diff / (24 * 60 * 60 * 1000);
    	TotalDays = (int)diffDays;
    	daysWorked = inTimeList.size();
		//System.out.println(diff);
		return daysWorked;
    	
    }
    
    public int getTotalHrs() {
    	int i=0;
    	while(i < outTimeList.size()) {
    		getHrs(i);
    		i++;
    	}
    	Iterator iterator = hrsWorked.iterator();
    	while(iterator.hasNext()) {
             TotalHrsWorked  = TotalHrsWorked +  ((Long)iterator.next()).intValue();
         }
    	return TotalHrsWorked;
    } 
    
    public int getOverTimeHrs() {
    	overTimeHrs = getTotalHrs() - getDays()*WorkingHrs;
    	return overTimeHrs;
    }
    
    public long calSalary() {
    	salary = (long) (getOverTimeHrs()*overtimeRate + getDays()*salaryPerDay);
    	return salary<0? 0 : salary;
    }
    
    
}