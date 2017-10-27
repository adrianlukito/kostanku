package entre2.house_home.kostanku;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AreaFragment extends Fragment {

    private ExpandableListView expandableListView;
    private ExpandableListViewAdapter expandableListViewAdapter;
    private List<String> listHeader;
    private HashMap<String, List<String>> listChild;

    public AreaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_area,container,false);

        expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListView);
        initData();
        expandableListViewAdapter = new ExpandableListViewAdapter(getActivity().getApplicationContext(), listHeader, listChild);
        expandableListView.setAdapter(expandableListViewAdapter);

        //expandableListView.setIndicatorBoundsRelative(30,30);

        return view;
    }

    public void initData(){
        listHeader = new ArrayList<>();
        listChild = new HashMap<String, List<String>>();

        listHeader.add("Balikpapan");
        listHeader.add("Surabaya");
        listHeader.add("Bandung");
        listHeader.add("Semarang");
        listHeader.add("Bekasi");
        listHeader.add("Bogor");

        List<String> listBalikpapan = new ArrayList<>();
        listBalikpapan.add("Balikpapan Barat");
        listBalikpapan.add("Balikpapan Utara");
        listBalikpapan.add("Balikpapan Timur");
        listBalikpapan.add("Balikpapan Tengah");
        listBalikpapan.add("Balikpapan Selatan");
        listBalikpapan.add("Balikpapan Kota");

        List<String> listSurabaya = new ArrayList<>();
        listSurabaya.add("Tegalsari");
        listSurabaya.add("Wonokromo");
        listSurabaya.add("Tandes");
        listSurabaya.add("Genteng");

        List<String> listBandung = new ArrayList<>();
        listBandung.add("Cicendo");
        listBandung.add("Cinambo");
        listBandung.add("Coblong");
        listBandung.add("Gedebage");
        listBandung.add("Lengkong");
        listBandung.add("Mandalajati");
        listBandung.add("Regol");
        listBandung.add("Dago");

        List<String> listSemarang = new ArrayList<>();
        listSemarang.add("Semarang Utara");
        listSemarang.add("Semarang Tengah");
        listSemarang.add("Semarang Timur");
        listSemarang.add("Semarang Selatan");
        listSemarang.add("Semarang Barat");
        listSemarang.add("Genuk");
        listSemarang.add("Tembalang");

        List<String> listBekasi = new ArrayList<>();
        listBekasi.add("Pondok Gede");
        listBekasi.add("Cikarang Barat");
        listBekasi.add("Cikarang Utara");

        List<String> listBogor = new ArrayList<>();
        listBogor.add("Bogor Timur");
        listBogor.add("Bogor Selatan");
        listBogor.add("Bogor Barat");
        listBogor.add("Bogor Utara");
        listBogor.add("Bogor Tengah");
        listBogor.add("Tanah Sereal");


        listChild.put(listHeader.get(0),listBalikpapan);
        listChild.put(listHeader.get(1),listSurabaya);
        listChild.put(listHeader.get(2),listBandung);
        listChild.put(listHeader.get(3),listSemarang);
        listChild.put(listHeader.get(4),listBekasi);
        listChild.put(listHeader.get(5),listBogor);
    }
}
