package entre2.house_home.kostanku;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.CommonTabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class NearbyFragment extends Fragment {

    TabLayout tabLayout;
    CustomViewPager viewPager;

    public NearbyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_nearby,container,false);

        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        viewPager = (CustomViewPager) view.findViewById(R.id.viewPager);    
        //viewPager.setPagingEnabled(false);

//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());

        viewPagerAdapter.addFragment(new ListViewFragment(), "List View");
        viewPagerAdapter.addFragment(new MapViewFragment(), "Map View");

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        //tabLayout.getTabAt(0).setText(viewPagerAdapter.getPageTitle(0));

        return view;
    }

}
