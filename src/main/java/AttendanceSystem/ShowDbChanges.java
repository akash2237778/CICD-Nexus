package AttendanceSystem;

import com.google.firebase.database.*;

import java.io.IOException;

public class ShowDbChanges implements Runnable {
    public void run() {
        Firebase fbs = null;
            fbs = new Firebase();
        	
        

        DatabaseReference ref = fbs.getDb()
                .getReference("/");
        System.out.println(ref + "Ref");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String res = (String) dataSnapshot.getValue();
                System.out.println(res);
                System.out.print("ShowDB");
            }

			@Override
			public void onCancelled(DatabaseError error) {
				// TODO Auto-generated method stub
				
			}
        });
        
        
        
        ref.addValueEventListener(new ValueEventListener() {

            public void onDataChange(DataSnapshot dataSnapshot) {
                Object document = dataSnapshot.getValue();
                System.out.println(document);
            }


            public void onCancelled(DatabaseError error) {
                System.out.print("Error: " + error.getMessage());
            }
        });


    }
}