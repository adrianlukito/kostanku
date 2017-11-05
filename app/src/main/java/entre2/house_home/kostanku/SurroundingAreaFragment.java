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

    Drawable icon;

    Drawable atm, bank, church, gas_station, gym, hospital, hotel, mall, mosque, school;

    public SurroundingAreaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_surrounding_area,container,false);

        Typeface quicksand = Typeface.createFromAsset(getActivity().getAssets(), "Quicksand-Regular.ttf");

        icon = getResources().getDrawable(R.drawable.ic_placeholder);

        atm = getResources().getDrawable(R.drawable.ic_atm);
        bank = getResources().getDrawable(R.drawable.ic_bank);
        church = getResources().getDrawable(R.drawable.ic_church);
        gas_station = getResources().getDrawable(R.drawable.ic_gas_station);
        gym = getResources().getDrawable(R.drawable.ic_gym);
        hospital = getResources().getDrawable(R.drawable.ic_hospital);
        hotel = getResources().getDrawable(R.drawable.ic_hotel);
        mall = getResources().getDrawable(R.drawable.ic_mall);
        mosque = getResources().getDrawable(R.drawable.ic_mosque);
        school = getResources().getDrawable(R.drawable.ic_school);

        gridView = (GridView) view.findViewById(R.id.gridView);

        gridViewAdapter = new FacilityGridViewAdapter(getContext());

        gridViewAdapter.addFacility("Mall",mall);
        gridViewAdapter.addFacility("ATM",atm);
        gridViewAdapter.addFacility("Bank",bank);
        gridViewAdapter.addFacility("School",school);
        gridViewAdapter.addFacility("Hospital",hospital);
        gridViewAdapter.addFacility("Church",church);
        gridViewAdapter.addFacility("Gas Station",gas_station);
        gridViewAdapter.addFacility("Gym",gym);
        gridViewAdapter.addFacility("Hotel",hotel);
        gridViewAdapter.addFacility("Mosque",mosque);

        gridView.setAdapter(gridViewAdapter);

        return view;
    }

}
