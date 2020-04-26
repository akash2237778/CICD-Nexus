package AttendanceSystem;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyMain {

    public synchronized static void main(String[] args) {
    	System.out.print("Hello");
    	DatabaseReference ref;
    	Firebase obj = new Firebase();
    	ref = obj.setRef("/");
    	
    	  	
    	
    	ref.child("Apple").addValueEventListener(new ValueEventListener() {
  		  @Override
  		  public void onDataChange(DataSnapshot dataSnapshot) {
  		    String s = (String) dataSnapshot.getValue();
  		    System.out.println(s);
  		  }

  		  @Override
  		  public void onCancelled(DatabaseError databaseError) {
  		    System.out.println("The read failed: " + databaseError.getCode());
  		  }
  		});
    	
    	//obj.SleepThread(100000);
    	
    	Employee emp1 = new Employee("name", 25, "empId" , 5.6f, 2.5f);
    	emp1.attendancePunch();
    	obj.SleepThread(1000);
    	emp1.attendancePunch();
    	//emp1.getHrs(0);
    	System.out.println("Salary " + emp1.calSalary());
    	
    	obj.saveData("Emp1", emp1);
    	obj.SleepThread(100000);
    	
    }
}