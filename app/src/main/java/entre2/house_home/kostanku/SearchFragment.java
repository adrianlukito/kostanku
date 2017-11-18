package entre2.house_home.kostanku;


import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.Touch;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import co.ceryle.radiorealbutton.RadioRealButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements AdapterView.OnItemClickListener{

    Button btnSearch;
    RadioRealButton radBtnMan, radBtnWoman, radBtnManAndWoman;
    GridView facilityFilterGridView;
    FacilityFilterGridViewAdapter facilityFilterGridViewAdapter;
    Drawable borderPrimaryDark, borderTeal;
    TextView tvFacilityTitle,tvStrip;
    Button btnFindNow;

    boolean isSelected = true;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        Typeface quicksand = Typeface.createFromAsset(getActivity().getAssets(), "Quicksand-Regular.ttf");

        btnSearch = (Button) view.findViewById(R.id.btnSearch);
        radBtnMan = (RadioRealButton) view.findViewById(R.id.radBtnMan);
        radBtnWoman = (RadioRealButton) view.findViewById(R.id.radBtnWoman);
        radBtnManAndWoman = (RadioRealButton) view.findViewById(R.id.radBtnManAndWoman);
        facilityFilterGridView = (GridView) view.findViewById(R.id.facilityFilterGridView);
        borderPrimaryDark = getActivity().getResources().getDrawable(R.drawable.border_radius_primary_dark_no_ripple);
        borderTeal = getActivity().getResources().getDrawable(R.drawable.border_radius_teal_no_ripple);
        tvFacilityTitle = (TextView) view.findViewById(R.id.tvFacilityTitle);
        btnFindNow = (Button) view.findViewById(R.id.btnFindNow);
        tvStrip = (TextView) view.findViewById(R.id.tvStrip);

        btnSearch.setTypeface(quicksand);
        radBtnMan.setTypeface(quicksand);
        radBtnWoman.setTypeface(quicksand);
        radBtnManAndWoman.setTypeface(quicksand);
        tvFacilityTitle.setTypeface(quicksand, Typeface.BOLD);
        btnFindNow.setTypeface(quicksand);
        tvStrip.setTypeface(quicksand,Typeface.BOLD);

        facilityFilterGridViewAdapter = new FacilityFilterGridViewAdapter(getContext());

        facilityFilterGridViewAdapter.addFacility("AC", true);
        facilityFilterGridViewAdapter.addFacility("Bathroom Inside", true);
        facilityFilterGridViewAdapter.addFacility("TV", true);
        facilityFilterGridViewAdapter.addFacility("Parking", true);
        facilityFilterGridViewAdapter.addFacility("Internet", true);
        facilityFilterGridViewAdapter.addFacility("Laundry", true);
        facilityFilterGridViewAdapter.addFacility("Table", true);
        facilityFilterGridViewAdapter.addFacility("Chair", true);
        facilityFilterGridViewAdapter.addFacility("Wardrobe", true);

        facilityFilterGridView.setAdapter(facilityFilterGridViewAdapter);

        facilityFilterGridView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        RelativeLayout facilityFilterLayout = (RelativeLayout) view.findViewById(R.id.facilityFilterLayout);
        TextView t = (TextView) view.findViewById(R.id.tvFacilityFilter);
        ImageView imgCheck = (ImageView) view.findViewById(R.id.imgCheck);
        //Toast.makeText(getContext(), facilityFilterLayout+""+facilityFilterLayout.getId(), Toast.LENGTH_SHORT).show();

        if(facilityFilterGridViewAdapter.getIselecteds(position) == true){
            facilityFilterLayout.setBackground(borderPrimaryDark);
            t.setTextColor(getResources().getColor(R.color.colorWhite));
            imgCheck.setVisibility(View.VISIBLE);
            if(facilityFilterLayout.getBackground() == borderPrimaryDark) {
                facilityFilterGridViewAdapter.setIsSelected(position, false);
            }
        }else if(facilityFilterGridViewAdapter.getIselecteds(position) == false){
            facilityFilterLayout.setBackground(borderTeal);
            t.setTextColor(getResources().getColor(R.color.colorBlack));
                imgCheck.setVisibility(View.GONE);
            if(facilityFilterLayout.getBackground() == borderTeal) {
                facilityFilterGridViewAdapter.setIsSelected(position, true);
            }
        }


    }
}
