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
	public static Organisation org1;

    public synchronized static void main(String[] args) {
    //	System.out.print("Hello");
    	DatabaseReference ref;
    	Firebase obj = new Firebase();
    	ref = obj.setRef("/");
    	//org1 = new Organisation();
    	
    	System.out.println("1");	
    	
    	ref.addValueEventListener(new ValueEventListener() {
  		  @Override
  		  public void onDataChange(DataSnapshot dataSnapshot) {
  			//  dataSnapshot = dataSnapshot.child("Organisation");
  			//System.out.println("HeEMPo" + dataSnapshot.getValue(Employee.class));
  			//System.out.println("Helllllooo" + dataSnapshot.getValue(Organisation.class));
  			
  			org1 = dataSnapshot.getValue(Organisation.class);
  			System.out.println("ID" + org1.id);
  			org1.addEmp("name", 2 , 5.5f, 2.4f);
  	    	org1.punch("empId0");
  			//org1 = s;
  		    
  		  }

  		  @Override
  		  public void onCancelled(DatabaseError databaseError) {
  		    System.out.println("The read failed: " + databaseError.getCode());
  		  }
  		});

    	obj.SleepThread(10000);
    	//System.out.println("Helllllooo OUT 3");
    	System.out.println("Helllllooo OUT 2" + org1.allEmp.size());
    	
		//org1.addEmp("ndffdfsdame", 2 , 5.5f, 2.4f);
  	    //org1.punch("empId0");
    	//obj.SleepThread(1000);
    	//org1.punch("empId1");
    	//emp1.getHrs(0);
    	System.out.println("Salary "+ org1.allEmp.size() );
    	
    	obj.saveData("Organisation", org1);
    	obj.SleepThread(100000);

    	System.out.println("Helllllooo OUT 4");
    	
    }
}