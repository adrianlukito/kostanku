package entre2.house_home.kostanku;


import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.constraint.solver.SolverVariable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CampusFragment extends Fragment implements ExpandableListView.OnChildClickListener{

    private ExpandableListView expandableListView;
    private ExpandableListViewAdapter expandableListViewAdapter;
    private List<String> listHeader;
    private HashMap<String, List<String>> listChild;

    public CampusFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_campus,container,false);

        expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListView);
        initData();
        expandableListViewAdapter = new ExpandableListViewAdapter(getActivity().getApplicationContext(), listHeader, listChild);
        expandableListView.setAdapter(expandableListViewAdapter);
        expandableListView.setOnChildClickListener(this);

        //expandableListView.setIndicatorBoundsRelative(30,30);

        return view;
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

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        //INI CARA TOAST BWT LIAT CHILD NYA
        // /Toast.makeText(getActivity().getApplicationContext(), listChild.get(listHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();
        return false;
    }
}
