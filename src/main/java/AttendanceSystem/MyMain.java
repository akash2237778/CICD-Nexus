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

    public static void main(String[] args) {
    	System.out.print("Hello");
    	 try {
    		File file = new File("attendancesystem-7604d-firebase-adminsdk-kdrhc-ef35be211b.json");
 	        FileInputStream serviceAccount = new FileInputStream(file);
 	        		
 			FirebaseOptions options = new FirebaseOptions.Builder()
 			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
 			  .setDatabaseUrl("https://attendancesystem-7604d.firebaseio.com/")
 			  .build();
 			
 			FirebaseApp.initializeApp(options);
 			
    	 }catch(Exception e) {
    		 System.out.println("Error" + e.getMessage());
    	 }
    	final FirebaseDatabase database = FirebaseDatabase.getInstance();
    	
    	DatabaseReference ref = database.getReference("/");
    	Map<String, String> users = new HashMap<>();
    	users.put("alanisawesome","asdsdf");
    	users.put("gracehop", "December 9, 190 Grace Hopper");

    	ref.child("Apple").setValueAsync("priority");
    	
    	
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
    	try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("Firebase" + database  +  "    " + ref);	
    	
    }
}