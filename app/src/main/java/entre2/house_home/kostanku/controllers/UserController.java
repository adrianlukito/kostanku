package entre2.house_home.kostanku.controllers;

import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Vector;

import entre2.house_home.kostanku.models.User;

/**
 * Created by chris on 11/02/2017.
 */

public class UserController {

    private static FirebaseDatabase mFirebaseDatabase;
    private static DatabaseReference mDatabaseReference;

    private static Vector<User>users;
    Query query;

    private static UserController instance = null;
    private UserController(){
        users = new Vector<>();

        query = FirebaseDatabase.getInstance().getReference().child("Users");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getChildrenCount() != 0){
                    users.clear();
                    for (DataSnapshot d:dataSnapshot.getChildren()) {
//                        Log.v("USER",d.getKey().toString());
                        User user = createUser(d);
                        users.add(user);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private User createUser(DataSnapshot data){
        String id = data.getKey();
        String name = getChild(data, "name");
        String email = getChild(data, "email");
        String password = getChild(data, "password");
        String phonenumber = getChild(data, "phone");

        return new User(id, name, email, password, phonenumber);
    }

    private String getChild(DataSnapshot data, String key){
        return data.child("user").child(key).getValue().toString();
    }

    public static UserController getInstance(){
        if(instance==null){
            instance = new UserController();
        }
        return  instance;
    }

    public static User getUser(String email){
        for(User u:users){
            if(u.getEmail().equals(email)){
                return  u;
            }
        }
        return null;
    }

    public static boolean userAuth(String email, String password){
        for (User user:users) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }

    public static void insertUser(User user){
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference("Users");

        DatabaseReference newUser = mDatabaseReference.push();
        user.setId(newUser.getKey());
        newUser.child("user").setValue(user);
    }

    public static String validateRegister(User user, String confirm){
        String err;
        if(user.getEmail().equals("")){
            err = "email must be filled and valid";
            return err;
        }
        if(user.getPassword().equals("")){
            err="password must be filled";
            return err;
        }
        if(user.getPassword().length()<6){
            err="password must be more than 6 character";
            return err;
        }
        if(!confirm.equals(user.getPassword())){
            err="confirm password must be same as password";
            return err;
        }
        if(user.getName().equals("")){
            err="name must be filled";
            return err;
        }
        if(user.getPhone().equals("")){
            err="phone must be filled";
            return err;
        }
        return "";
    }

}
