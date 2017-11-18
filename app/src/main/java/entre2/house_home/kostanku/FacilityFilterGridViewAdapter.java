package entre2.house_home.kostanku;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Adrian Lukito Lo on 07/11/2017.
 */

public class FacilityFilterGridViewAdapter extends BaseAdapter{

    ArrayList<String> facilityNames;
    ArrayList<Boolean> isSelecteds;

    Context context;

    TextView tvFacilityFilter;
    ImageView imgCheck;

    public FacilityFilterGridViewAdapter(Context context) {
        this.context = context;
        facilityNames = new ArrayList<>();
        isSelecteds = new ArrayList<>();
    }

    public void addFacility(String facilityName, boolean isSelected){
        facilityNames.add(facilityName);
        isSelecteds.add(isSelected);
    }

    public boolean getIselecteds(int position){
        return isSelecteds.get(position);
    }

    public void setIsSelected(int position, boolean isSelected){
        isSelecteds.set(position,isSelected);
    }

    @Override
    public int getCount() {
        return facilityNames.size();
    }

    @Override
    public Object getItem(int position) {
        return facilityNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.facility_filter_row,parent,false);
        }

        Typeface quicksand = Typeface.createFromAsset(context.getAssets(), "Quicksand-Regular.ttf");

        tvFacilityFilter = (TextView) convertView.findViewById(R.id.tvFacilityFilter);
        imgCheck = (ImageView) convertView.findViewById(R.id.imgCheck);

        tvFacilityFilter.setTypeface(quicksand);
        tvFacilityFilter.setText(facilityNames.get(position));

        return convertView;
    }
}
