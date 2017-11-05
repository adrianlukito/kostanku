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
public class PublicFacilityFragment extends Fragment {

    GridView gridView;
    FacilityGridViewAdapter gridViewAdapter;

    Drawable icon;

    Drawable bicycle, car, cctv, fridge, kitchen, microwave, motorcycle, security, washing_machine;

    public PublicFacilityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_public_facility,container,false);

        Typeface quicksand = Typeface.createFromAsset(getActivity().getAssets(), "Quicksand-Regular.ttf");

        icon = getResources().getDrawable(R.drawable.ic_mail);

        bicycle = getResources().getDrawable(R.drawable.ic_bicycle);
        car = getResources().getDrawable(R.drawable.ic_car);
        cctv = getResources().getDrawable(R.drawable.ic_cctv);
        fridge = getResources().getDrawable(R.drawable.ic_fridge);
        kitchen = getResources().getDrawable(R.drawable.ic_kitchen);
        microwave = getResources().getDrawable(R.drawable.ic_microwave);
        motorcycle = getResources().getDrawable(R.drawable.ic_motorcycle);
        security = getResources().getDrawable(R.drawable.ic_security);
        washing_machine = getResources().getDrawable(R.drawable.ic_washing_machine);

        gridView = (GridView) view.findViewById(R.id.gridView);

        gridViewAdapter = new FacilityGridViewAdapter(getContext());

        gridViewAdapter.addFacility("Laundry",washing_machine);
        gridViewAdapter.addFacility("Refrigerator",fridge);
        gridViewAdapter.addFacility("Car Park",car);
        gridViewAdapter.addFacility("Motorcycle Park",motorcycle);
        gridViewAdapter.addFacility("Bicycle Park",bicycle);
        gridViewAdapter.addFacility("CCTV",cctv);
        gridViewAdapter.addFacility("Kitchen",kitchen);
        gridViewAdapter.addFacility("Security",security);
        gridViewAdapter.addFacility("Microwave",microwave);

        gridView.setAdapter(gridViewAdapter);

        return view;
    }

}
