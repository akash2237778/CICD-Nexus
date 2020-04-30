package AttendanceSystem;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    //protected Date inTime;
    public long inTimeStr;
    //protected Date outTime;
    public long outTimeStr;
    public Boolean isWorking;
    public List<Long> inTimeList;
    public List<Long> outTimeList;
    public List<Long> hrsWorked;
    public int workingHrs;
    private long startDay;
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
        inTimeList = new ArrayList<Long>();
        outTimeList = new ArrayList<Long>();
        hrsWorked = new ArrayList<Long>();
        workingHrs = 8;
        startDay = new Date().getTime();
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

/*	public Date getInTime() {
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
	}*/

	public Boolean getIsWorking() {
		return isWorking;
	}

	public void setIsWorking(Boolean isWorking) {
		this.isWorking = isWorking;
	}

	public List<Long> getInTimeList() {
		return inTimeList;
	}

	public void setInTimeList(List<Long> inTimeList) {
		this.inTimeList = inTimeList;
	}

	public List<Long> getOutTimeList() {
		return outTimeList;
	}

	public void setOutTimeList(List<Long> outTimeList) {
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

	public Long getStartDay() {
		return startDay;
	}

	public void setStartDay(Long startDay) {
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
    		Date outTime = new Date();
    		outTimeStr = outTime.getTime();
    		outTimeList.add(outTimeStr);
    		isWorking = false;
    		System.out.println("Exit " + name + " : " + outTime.toString());
    	}else {
    		Date inTime = new Date();
    		inTimeStr = inTime.getTime();
    		inTimeList.add(inTimeStr);
    		isWorking = true;
    		System.out.println("In Time " + name + " : " + inTime.toString());
    	}
    	return isWorking;
    }
    
    public void getHrs(int index) {
    	long diff = 0;
			diff = outTimeList.get(index) - inTimeList.get(index);
		long diffHours = diff / (60 * 60 * 1000);
		hrsWorked.add(diffHours);
		//System.out.println(diff);
    }
    
    //Days Worked
    public int getDays() {
    	Date currentDay = new Date();
    	long diff = 0;
			diff = currentDay.getTime() - startDay;
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