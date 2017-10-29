package entre2.house_home.kostanku;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Adrian Lukito Lo on 29/10/2017.
 */

public class FacilityGridViewAdapter extends BaseAdapter{

    ArrayList<String> facilityNames;
    ArrayList<Drawable> facilityImages;

    Context context;

    ImageView kostFacilityImageView;
    TextView tvKostFacility;

    public FacilityGridViewAdapter(Context context) {
        this.context = context;
        facilityNames = new ArrayList<>();
        facilityImages = new ArrayList<>();
    }

    public void addFacility(String facilityName, Drawable facilityImage){
        facilityNames.add(facilityName);
        facilityImages.add(facilityImage);
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
            convertView = inflater.inflate(R.layout.facility_row,parent,false);
        }

        Typeface quicksand = Typeface.createFromAsset(context.getAssets(), "Quicksand-Regular.ttf");

        kostFacilityImageView = (ImageView) convertView.findViewById(R.id.kostFacilityImageView);
        tvKostFacility = (TextView) convertView.findViewById(R.id.tvKostFacility);

        kostFacilityImageView.setImageDrawable(facilityImages.get(position));
        tvKostFacility.setText(facilityNames.get(position));

        tvKostFacility.setTypeface(quicksand);

        return convertView;
    }
}
