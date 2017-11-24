package entre2.house_home.kostanku;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Vector;

import entre2.house_home.kostanku.controllers.KosController;
import entre2.house_home.kostanku.models.Kos;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListViewFragment extends Fragment implements AdapterView.OnItemClickListener{

    ListView kostListView;
    KostListViewAdapter kostListViewAdapter;

    Drawable lovingHut;
    Vector<Kos>listKos = new Vector<>();

    public ListViewFragment() {
        // Required empty public constructor
    }

    public static ProgressDialog progressDialog;

    public Kos createKos(DataSnapshot data){
        String id = data.getKey();
        String name = getChild(data, "name");
        String address = getChild(data, "address");
        String occupant = getChild(data, "occupant");
        String price = getChild(data, "price");
        String size = getChild(data,"size");
        String phone = getChild(data,"phone");
        Double latitude = Double.valueOf(getChild(data,"latitude"));
        Double longitude = Double.valueOf(getChild(data,"longitude"));
        return new Kos(id, address, name, latitude, longitude, occupant, price, size, phone);
    }

    public String getChild(DataSnapshot data, String key){
        return data.child("kos").child(key).getValue().toString();
    }


    public void loadData(){
        Query query= FirebaseDatabase.getInstance().getReference().child("Kosan");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getChildrenCount() != 0){
                    listKos.clear();
                    for (DataSnapshot d:dataSnapshot.getChildren()) {
                        Kos kos = createKos(d);
                        listKos.add(kos);
                        kostListViewAdapter.addKostList(kos,lovingHut);
                        kostListViewAdapter.notifyDataSetChanged();
                        KosController.setKos(kos);
                        Log.v("TEST","kosan2"+KosController.getAll().size());
                    }


//                    kostListViewAdapter.refresh(listKos);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    progressDialog.dismiss();
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_list_view,container,false);


        kostListView = (ListView) view.findViewById(R.id.kostListView);

        kostListViewAdapter = new KostListViewAdapter(getContext());
        kostListView.setAdapter(kostListViewAdapter);

        lovingHut = view.getResources().getDrawable(R.drawable.loving_hut);


        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMax(100);
        progressDialog.setMessage("Loading");
        progressDialog.setTitle("");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        loadData();

        kostListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //INI CARA MANGGIL ITEM YANG DI KLIK
        String idx = kostListViewAdapter.getItem(position).toString();
//        Toast.makeText(getContext(), "Nama Kos: "+KosController.getKos(idx).getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), KostDetailActivity.class);
        intent.putExtra("id",idx);
        startActivity(intent);
    }
}
