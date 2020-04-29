package AttendanceSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Organisation {
	public HashMap<String,Employee> allEmp;
	public int id;
	public List<Employee> currentlyWorking;
	
	
	
	public Organisation(){
		allEmp = new HashMap<String,Employee>();
		currentlyWorking = new ArrayList<Employee>();
	}
	public Organisation(List<Employee> currentlyWorking , int id ,HashMap<String,Employee> allEmp ){
		this.allEmp = allEmp;
		this.currentlyWorking = currentlyWorking;
		this.id = id;
	}
		
	
	public void addEmp(String name, int age,  float overtimeRate, float salaryPerDay) {
		allEmp.put("empId"+ id , new Employee(name, age, "empId"+ id , overtimeRate, salaryPerDay));
		id++;
		System.out.println("Added !!");
	}
	
	public void setAllEmp(HashMap<String,Employee> allEmp) {
		this.allEmp = allEmp;	
	}
	
	public void setId(int id) {
		this.id = id;	
	}
	
	public void setCurrentlyWorking(List<Employee> currentlyWorking) {
		this.currentlyWorking = currentlyWorking;	
	}

	public HashMap<String,Employee> getAllEmp() {
		return allEmp;	
	}
	
	
	public int getId() {
		return id;
	}
	public List<Employee> getCurrentlyWorking() {
		return currentlyWorking;	
	}
	
	public void punch(String empid) {
		if (allEmp.containsKey(empid)) { 
			
			if(allEmp.get(empid).attendancePunch()) {			
				currentlyWorking.add(allEmp.get(empid));
           }else {
        	   currentlyWorking.remove(allEmp.get(empid));
           }
		}
	}
}
