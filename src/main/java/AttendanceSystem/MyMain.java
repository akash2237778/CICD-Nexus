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
    	ref = obj.setRef("/Organisation");
    //	org1 = new Organisation();
    	//System.out.println("1");	
		//org1.addEmp("nd", 5 , 5.55f, 2.4f);
	//	org1.addEmp("cddnd", 5 , 5.55f, 2.4f);
  	//    org1.punch("empId0");
    	//obj.SleepThread(1000);
    	//org1.punch("empId1");
    	//emp1.getHrs(0);
    	//System.out.println("Salary "+ org1.allEmp.size() );    	
    //	obj.saveData("Organisation", org1);
    	
    	
    	String Total = obj.retriveData();
    	
    	//String[] arr = Total.split("=");

    	Total =Total.replace("={", "\" : {");

    	Total =Total.replace("=[", "\" : [");
    	Total =Total.replace("=", "\" : \"");
    	Total = Total.replace("{", "{ \"");
    	Total = Total.replace(", ", "\" , \"");

    	Total = Total.replace("}\"", "\" } ");
    	Total = Total.replace("}]\"", "\"}]");
    	Total = Total.replace("0}", "0\"}");
    	Total = Total.replace("st\" : [",     "st\" : [ \"");
    	Total = Total.replace("]\" , \"a", "\"] , \"a");
    	
    	
    	
    

    	System.out.println(Total.charAt(29) +"   :  " +Total);
    	
    	JSONObject jresponse = new JSONObject(Total);
    	//JSONArray arr = jresponse.getJSONArray("currentlyWorking");
    	//jresponse = new JSONObject(arr.get(0));
    	Gson g = new Gson(); 
    	Organisation p = g.fromJson(Total, Organisation.class);
    	//Total = Total.replace("[", "");
    	//JSONArray arr = new JSONArray(Total);
 //   	JSONObject jObj = new JSONObject(Total);
  //  	String date = jObj.getString("NeededString");
    	//String reu
    	//obj.retriveData("allEmp/empId0"+"/name");
    	/*for(int i=0 ; i < Total ; i++) {
    		org1.addEmp("222", 5 , 5.55f, 2.4f);
    		System.out.print(obj.retriveData("allEmp/empId"+i+"/name"));
    	}*/
    	
    //	obj.SleepThread(100000);
    	//p.addEmp("cddnd", 5 , 5.55f, 2.4f);
    	System.out.println("Helllllooo OUT :" + p.id );
    	
    }
    
    
}