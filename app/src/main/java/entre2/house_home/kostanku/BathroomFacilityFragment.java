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
public class BathroomFacilityFragment extends Fragment {

    GridView gridView;
    FacilityGridViewAdapter gridViewAdapter;

    Drawable icon;

    Drawable bathroom_inside, shower, sink, squat_toilet, toilet, water_heater;

    public BathroomFacilityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bathroom_facility,container,false);

        Typeface quicksand = Typeface.createFromAsset(getActivity().getAssets(), "Quicksand-Regular.ttf");

        icon = getResources().getDrawable(R.drawable.ic_lock);

        bathroom_inside = getResources().getDrawable(R.drawable.ic_bathroom_inside);
        shower = getResources().getDrawable(R.drawable.ic_shower);
        sink = getResources().getDrawable(R.drawable.ic_sink);
        squat_toilet = getResources().getDrawable(R.drawable.ic_squat_toilet);
        toilet = getResources().getDrawable(R.drawable.ic_toilet);
        water_heater  =getResources().getDrawable(R.drawable.ic_water_heater);

        gridView = (GridView) view.findViewById(R.id.gridView);

        gridViewAdapter = new FacilityGridViewAdapter(getContext());

        gridViewAdapter.addFacility("Bathroom Inside",bathroom_inside);
        gridViewAdapter.addFacility("Toilet",toilet);
        gridViewAdapter.addFacility("Squat Toilet",squat_toilet);
        gridViewAdapter.addFacility("Shower",shower);
        gridViewAdapter.addFacility("Sink",sink);
        gridViewAdapter.addFacility("Water Heater",water_heater);

        gridView.setAdapter(gridViewAdapter);

        return view;
    }
}
