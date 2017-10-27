package entre2.house_home.kostanku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private ExpandableListViewAdapter expandableListViewAdapter;
    private List<String> listHeader;
    private HashMap<String, List<String>> listChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        initData();
        expandableListViewAdapter = new ExpandableListViewAdapter(this, listHeader, listChild);
        expandableListView.setAdapter(expandableListViewAdapter);
    }

    public void initData(){
        listHeader = new ArrayList<>();
        listChild = new HashMap<String, List<String>>();

        listHeader.add("Jakarta");
        listHeader.add("Surabaya");
        listHeader.add("Bandung");
        listHeader.add("Semarang");

        List<String> listJakarta = new ArrayList<>();
        listJakarta.add("Binus");
        listJakarta.add("Trisakti");
        listJakarta.add("Untar");
        listJakarta.add("Atma Jaya");

        List<String> listSurabaya = new ArrayList<>();
        listSurabaya.add("UBAYA");
        listSurabaya.add("Petra");
        listSurabaya.add("UNAIR");
        listSurabaya.add("ITS");

        List<String> listBandung = new ArrayList<>();
        listBandung.add("UNPAD");
        listBandung.add("UNPAR");
        listBandung.add("ITB");
        listBandung.add("UNJANI");

        List<String> listSemarang = new ArrayList<>();
        listSemarang.add("Udinus");
        listSemarang.add("UNNES");
        listSemarang.add("UNPID");

        listChild.put(listHeader.get(0),listJakarta);
        listChild.put(listHeader.get(1),listSurabaya);
        listChild.put(listHeader.get(2),listBandung);
        listChild.put(listHeader.get(3),listSemarang);
    }
}
