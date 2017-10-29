package entre2.house_home.kostanku;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GeneralInformationFragment extends Fragment {

    ListView listView;
    GeneralInformationListViewAdapter listViewAdapter;

    public GeneralInformationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_general_information,container,false);

        listView = (ListView) view.findViewById(R.id.listView);

        listViewAdapter = new GeneralInformationListViewAdapter(getContext());

        listViewAdapter.addInformation("Phone Number","0812345567");
        listViewAdapter.addInformation("Room Size","12m");
        listViewAdapter.addInformation("Occupant","Man and Woman");
        listViewAdapter.addInformation("Deposit","Rp. 1.000.000");
        listViewAdapter.addInformation("Phone Number","0812345567");
        listViewAdapter.addInformation("Room Size","12m");
        listViewAdapter.addInformation("Occupant","Man and Woman");
        listViewAdapter.addInformation("Deposit","Rp. 1.000.000");

        listView.setAdapter(listViewAdapter);

        return view;
    }

}
