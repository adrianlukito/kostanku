package entre2.house_home.kostanku;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListViewFragment extends Fragment {

    ListView kostListView;
    KostListViewAdapter kostListViewAdapter;

    Drawable testKostImage;

    public ListViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_list_view,container,false);

        kostListView = (ListView) view.findViewById(R.id.kostListView);

        kostListViewAdapter = new KostListViewAdapter(getContext());

        testKostImage = view.getResources().getDrawable(R.drawable.rasuna_mansion_1);

        kostListViewAdapter.addKostList("Kost Orange","Jl. K.H. Syahdan No. 11 asdsadsa","Man",1500000,testKostImage);
        kostListViewAdapter.addKostList("Kost Orange","Jl. K.H. Syahdan No. 11","Woman",1500000,null);
        kostListViewAdapter.addKostList("Kost Orange","Jl. K.H. Syahdan No. 11","Woman",1500000,testKostImage);
        kostListViewAdapter.addKostList("Kost Orange","Jl. K.H. Syahdan No. 11","Man and Woman",1500000,null);
        kostListViewAdapter.addKostList("Kost Orange","Jl. K.H. Syahdan No. 11","Man",1500000,testKostImage);

        kostListView.setAdapter(kostListViewAdapter);

        Toast.makeText(getContext(), "listview nih", Toast.LENGTH_SHORT).show();
        return view;
    }

}
