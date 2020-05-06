package AttendanceSystem;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class MyMain {
	public static Organisation org1;

    public synchronized static void main(String[] args) {
    //	System.out.print("Hello");
    	DatabaseReference ref;
    	Firebase obj = new Firebase();
    	ref = obj.setRef("/");
    /*	org1 = new Organisation();
    	//System.out.println("1");	
		org1.addEmp("nd", 5 , 5.55f, 2.4f);
		org1.addEmp("cddnd", 5 , 5.55f, 2.4f);
  	    org1.punch("empId0");
  	  org1.punch("empId1");
    	obj.SleepThread(1000);
    	org1.punch("empId0");
    	org1.punch("empId1");
    	org1.punch("empId1");
    	//emp1.getHrs(0);
    	//System.out.println("Salary "+ org1.allEmp.size() );    	
    	obj.saveData("Organisation", org1);*/
    	
    	
    	String JSONstr = obj.convertToJSON(obj.retriveData("/Organisation"));
    	System.out.println(JSONstr);
    	Gson g = new Gson(); 
    	Organisation p = g.fromJson(JSONstr, Organisation.class);
    	p.addEmp("cddndsdsd", 55 , 5.55f, 2.4f);
    	p.punch("empId0");
    	p.punch("empId1");

    	//p.punch("empId0");
    	//System.out.println("Helllllooo OUT :" + p.allEmp.get("empId0").inTimeList.get(0)  +"    " 	);//p.allEmp.get("empId0").calSalary() );
    	obj.saveData("Organisation", p);
    	obj.SleepThread(100000);
    }
    
    
}