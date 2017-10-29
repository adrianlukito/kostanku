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
public class SurroundingAreaFragment extends Fragment {

    GridView gridView;
    FacilityGridViewAdapter gridViewAdapter;

    TextView tvFragmentTitle;

    Drawable icon;

    public SurroundingAreaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_surrounding_area,container,false);

        Typeface quicksand = Typeface.createFromAsset(getActivity().getAssets(), "Quicksand-Regular.ttf");

        tvFragmentTitle = (TextView) view.findViewById(R.id.tvFragmentTitle);

        tvFragmentTitle.setTypeface(quicksand);

        icon = getResources().getDrawable(R.drawable.ic_placeholder);

        gridView = (GridView) view.findViewById(R.id.gridView);

        gridViewAdapter = new FacilityGridViewAdapter(getContext());

        gridViewAdapter.addFacility("Mall",icon);
        gridViewAdapter.addFacility("ATM",icon);
        gridViewAdapter.addFacility("School",icon);
        gridViewAdapter.addFacility("Hospital",icon);
        gridViewAdapter.addFacility("Warteg",icon);
        gridViewAdapter.addFacility("Mini Market",icon);

        gridView.setAdapter(gridViewAdapter);

        return view;
    }

}
