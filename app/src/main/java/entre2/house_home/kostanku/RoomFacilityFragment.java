package entre2.house_home.kostanku;


import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RoomFacilityFragment extends Fragment {

    GridView gridView;
    FacilityGridViewAdapter gridViewAdapter;

    Drawable icon;

    Drawable air_conditioner, chair, fan, table, television, wardrobe, wifi, single_bed, king_bed;

    public RoomFacilityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_room_facility,container,false);

        Typeface quicksand = Typeface.createFromAsset(getActivity().getAssets(), "Quicksand-Regular.ttf");

        icon = getResources().getDrawable(R.drawable.ic_building);

        air_conditioner = getResources().getDrawable(R.drawable.ic_air_conditioner);
        chair = getResources().getDrawable(R.drawable.ic_chair);
        fan = getResources().getDrawable(R.drawable.ic_fan);
        table = getResources().getDrawable(R.drawable.ic_table);
        television = getResources().getDrawable(R.drawable.ic_television);
        wardrobe = getResources().getDrawable(R.drawable.ic_wardrobe);
        wifi = getResources().getDrawable(R.drawable.ic_wifi);
        single_bed = getResources().getDrawable(R.drawable.ic_single_bed);
        king_bed = getResources().getDrawable(R.drawable.ic_king_bed);

        gridView = (GridView) view.findViewById(R.id.gridView);

        gridViewAdapter = new FacilityGridViewAdapter(getContext());

        gridViewAdapter.addFacility("Single Bed",single_bed);
        gridViewAdapter.addFacility("King Bed",king_bed);
        gridViewAdapter.addFacility("TV",television);
        gridViewAdapter.addFacility("Table",table);
        gridViewAdapter.addFacility("Chair",chair);
        gridViewAdapter.addFacility("WiFi",wifi);
        gridViewAdapter.addFacility("AC",air_conditioner);
        gridViewAdapter.addFacility("Wardrobe",wardrobe);
        gridViewAdapter.addFacility("Fan",fan);

        gridView.setAdapter(gridViewAdapter);

        return view;
    }

}
