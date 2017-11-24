package entre2.house_home.kostanku.controllers;

import android.app.ProgressDialog;
import android.util.Log;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.Objects;
import java.util.Vector;

import entre2.house_home.kostanku.models.Kos;
import entre2.house_home.kostanku.models.User;

/**
 * Created by chris on 11/20/2017.
 */

public class KosController {


    private static FirebaseDatabase mFirebaseDatabase;
    private static DatabaseReference mDatabaseReference;

    private static Vector<Kos> listKost;
    Query query;

    private static KosController instance = null;
    public static boolean isLoad = true;

    private KosController(){
        listKost = new Vector<>();
    }

    public static KosController getInstance(){
        if(instance==null) {
            instance = new KosController();
        }
        return instance;
    }

    public static Vector<Kos> getAll(){
        return listKost;
    }

    public static void setKos(Kos kos){
        listKost.add(kos);
    }

    public static Kos getKos(String id){
        for(int i = 0;i<listKost.size();i++){
            if(listKost.get(i).getId().trim().equals(id)){
                return listKost.get(i);
            }
        }
        return null;
    }
}
