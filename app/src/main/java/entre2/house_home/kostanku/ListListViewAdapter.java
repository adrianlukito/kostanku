package entre2.house_home.kostanku;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Adrian Lukito Lo on 17/10/2017.
 */

public class ListListViewAdapter extends BaseAdapter{

    ArrayList<String> kostNames;
    ArrayList<String> kostAddresses;
    ArrayList<String> kostGenderType;
    ArrayList<Integer> kostPrice;
    ArrayList<Drawable> kostPicture;


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
