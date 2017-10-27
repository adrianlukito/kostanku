package entre2.house_home.kostanku;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Adrian Lukito Lo on 06/10/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{

    ArrayList<Fragment> fragments;
    ArrayList<String> titles;
    //ArrayList<D>

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<Fragment>();
        titles = new ArrayList<String>();
    }

    public void addFragment(Fragment fragment, String title){
        fragments.add(fragment);
        titles.add(title);
    }

    public String getPageTitle(int position){
        return titles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
