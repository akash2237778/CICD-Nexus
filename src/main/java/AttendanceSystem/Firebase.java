package AttendanceSystem;
import java.io.*;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;
public class Firebase {
	FirebaseDatabase db;
	
	 public Firebase() {
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

	 }
	 
	    public FirebaseDatabase getDb() {
	        return db;
	    }
	 
}
