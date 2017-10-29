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

    TextView tvFragmentTitle;

    Drawable icon;

    public BathroomFacilityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bathroom_facility,container,false);

        Typeface quicksand = Typeface.createFromAsset(getActivity().getAssets(), "Quicksand-Regular.ttf");

        tvFragmentTitle = (TextView) view.findViewById(R.id.tvFragmentTitle);

        tvFragmentTitle.setTypeface(quicksand);

        icon = getResources().getDrawable(R.drawable.ic_lock);

        gridView = (GridView) view.findViewById(R.id.gridView);

        gridViewAdapter = new FacilityGridViewAdapter(getContext());

        gridViewAdapter.addFacility("Bathroom Inside",icon);
        gridViewAdapter.addFacility("Closet",icon);
        gridViewAdapter.addFacility("Shower",icon);
        gridViewAdapter.addFacility("Water Heater",icon);
        gridViewAdapter.addFacility("Washtafel",icon);

        gridView.setAdapter(gridViewAdapter);

        return view;
    }
}
