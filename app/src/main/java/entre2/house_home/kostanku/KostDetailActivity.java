package entre2.house_home.kostanku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KostDetailActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private KostDetailExpandableListViewAdapter kostDetailExpandableListViewAdapter;
    private List<String> listHeader;
    private HashMap<String, List<String>> listChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kost_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        expandableListView = (ExpandableListView) findViewById(R.id.kostDetailExpandableListView);
        initData();
        kostDetailExpandableListViewAdapter = new KostDetailExpandableListViewAdapter(this, listHeader, listChild);
        expandableListView.setAdapter(kostDetailExpandableListViewAdapter);
    }

    public void initData(){
        listHeader = new ArrayList<>();
        listChild = new HashMap<String, List<String>>();

        listHeader.add("Room Facility");
        listHeader.add("Bathroom Facility");
        listHeader.add("Public Facility");
        listHeader.add("Surrounding");

        List<String> listRoomFacility = new ArrayList<>();
        listRoomFacility.add("Bed");
        listRoomFacility.add("TV");
        listRoomFacility.add("Wifi");
        listRoomFacility.add("Wardrobe");
        listRoomFacility.add("AC");

        List<String> listBatchroomFacility = new ArrayList<>();
        listBatchroomFacility.add("Shower");
        listBatchroomFacility.add("Water Heater");
        listBatchroomFacility.add("Toilet Seat");

        List<String> listPublicFacility = new ArrayList<>();
        listPublicFacility.add("Kitchen");
        listPublicFacility.add("Laundry");
        listPublicFacility.add("Parking");
        listPublicFacility.add("Refrigerator");

        List<String> listSurrounding = new ArrayList<>();
        listSurrounding.add("ATM");
        listSurrounding.add("Mini Market");
        listSurrounding.add("Campus / School");
        listSurrounding.add("Mall");

        listChild.put(listHeader.get(0),listRoomFacility);
        listChild.put(listHeader.get(1),listBatchroomFacility);
        listChild.put(listHeader.get(2),listPublicFacility);
        listChild.put(listHeader.get(3),listSurrounding);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
