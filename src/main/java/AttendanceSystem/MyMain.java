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
    	DatabaseReference ref;
    	Firebase obj = new Firebase();
    	ref = obj.setRef("/");
    
    	Organisation s = new Organisation();
    	s.addEmp("ABCD", 19, 4.2f, 250);
    	s.addEmp("DEFG", 20, 3.6f , 300);
    	s.addEmp("GHIJ", 36, 6.3f , 150);
    	s.addEmp("KLMN", 28, 3.3f , 150);
    	s.addEmp("OPQR", 29, 4.2f , 150);
    	s.punch("empId0");
    	s.punch("empId1");
    	s.punch("empId2");
    	s.punch("empId3");
    	s.punch("empId4");
    	s.punch("empId0");
    	s.punch("empId1");
    	s.punch("empId2");
    	s.punch("empId3");
    	s.punch("empId4");
    	obj.saveData("Organisation", s);
    	obj.SleepThread(100000);
    	
    	
    	String JSONstr = obj.convertToJSON(obj.retriveData("/Organisation"));
    	
    	Gson g = new Gson(); 
    	Organisation p = g.fromJson(JSONstr, Organisation.class);
    	System.out.println(JSONstr);


    	p.punch("empId0");
    	//System.out.println("Helllllooo OUT :" + p.allEmp.get("empId0").inTimeList.get(0)  +"    " 	);//p.allEmp.get("empId0").calSalary() );
    	obj.saveData("Organisation", p);
    	obj.SleepThread(100000);
    }
    
    
    
    
}