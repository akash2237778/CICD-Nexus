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
    public int workingHrs;
    public Date startDay;
    public int totalDays;
    public int totalHrsWorked;
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
        workingHrs = 8;
        startDay = new Date();
    }
    
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public float getOvertimeRate() {
		return overtimeRate;
	}

	public void setOvertimeRate(float overtimeRate) {
		this.overtimeRate = overtimeRate;
	}

	public float getSalaryPerDay() {
		return salaryPerDay;
	}

	public void setSalaryPerDay(float salaryPerDay) {
		this.salaryPerDay = salaryPerDay;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public Boolean getIsWorking() {
		return isWorking;
	}

	public void setIsWorking(Boolean isWorking) {
		this.isWorking = isWorking;
	}

	public List<Date> getInTimeList() {
		return inTimeList;
	}

	public void setInTimeList(List<Date> inTimeList) {
		this.inTimeList = inTimeList;
	}

	public List<Date> getOutTimeList() {
		return outTimeList;
	}

	public void setOutTimeList(List<Date> outTimeList) {
		this.outTimeList = outTimeList;
	}

	public List<Long> getHrsWorked() {
		return hrsWorked;
	}

	public void setHrsWorked(List<Long> hrsWorked) {
		this.hrsWorked = hrsWorked;
	}

	public int getWorkingHrs() {
		return workingHrs;
	}

	public void setWorkingHrs(int workingHrs) {
		this.workingHrs = workingHrs;
	}

	public Date getStartDay() {
		return startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public int getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}

	public int getTotalHrsWorked() {
		return totalHrsWorked;
	}

	public void setTotalHrsWorked(int totalHrsWorked) {
		this.totalHrsWorked = totalHrsWorked;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public int getDaysWorked() {
		return daysWorked;
	}

	public void setDaysWorked(int daysWorked) {
		this.daysWorked = daysWorked;
	}

	public void setOverTimeHrs(int overTimeHrs) {
		this.overTimeHrs = overTimeHrs;
	}
    
    
    
    public boolean attendancePunch() {
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
    	return isWorking;
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
    	totalDays = (int)diffDays;
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
             totalHrsWorked  = totalHrsWorked +  ((Long)iterator.next()).intValue();
         }
    	return totalHrsWorked;
    } 
    
    public int getOverTimeHrs() {
    	overTimeHrs = getTotalHrs() - getDays()*workingHrs;
    	return overTimeHrs;
    }
    
    public long calSalary() {
    	salary = (long) (getOverTimeHrs()*overtimeRate + getDays()*salaryPerDay);
    	return salary<0? 0 : salary;
    }
    
    
}