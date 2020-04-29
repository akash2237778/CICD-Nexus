package AttendanceSystem;
import java.io.*;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.errorprone.annotations.Var;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class Firebase {
	FirebaseDatabase db;
	DatabaseReference dbref;
	
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
		 db = FirebaseDatabase.getInstance();

	 }
	 
	 
	 public DatabaseReference  setRef( String ref) {
		  dbref = db.getReference(ref);
		  return dbref;
	 }
	 
	 public FirebaseDatabase getDb() {
	        return db;
	    }
	 
	 public void saveData(String child, String value) {
		 dbref.child(child).setValueAsync(value);
	 }
	 public void SleepThread(int time) {
		 try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	 }
	 public void saveData(String child, Employee value) {
		 dbref.child(child).setValueAsync(value);
	 }
	 public void saveData(String child, Organisation value) {
		 dbref.child(child).setValueAsync(value);
	 }
}
