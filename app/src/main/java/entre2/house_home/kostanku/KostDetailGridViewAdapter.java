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

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Adrian Lukito Lo on 20/10/2017.
 */

public class KostDetailGridViewAdapter extends BaseAdapter{

    ArrayList<String> facilityNames;
    ArrayList<Drawable> facilityIcons;

    TextView tvKostFacility;
    ImageView kostFacilityImageView;

    Context context;

    public KostDetailGridViewAdapter(Context context){
        facilityNames = new ArrayList<>();
        facilityIcons = new ArrayList<>();
        this.context = context;
    }

    public void addKostDetail(String facilityName, Drawable facilityIcon){
        facilityNames.add(facilityName);
        facilityIcons.add(facilityIcon);
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
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.facility_row,parent,false);

        tvKostFacility = (TextView) convertView.findViewById(R.id.tvKostFacility);
        kostFacilityImageView = (ImageView) convertView.findViewById(R.id.kostFacilityImageView);

        tvKostFacility.setText(facilityNames.get(position));
        kostFacilityImageView.setImageDrawable(facilityIcons.get(position));

        Typeface varela = Typeface.createFromAsset(context.getAssets(),"VarelaRound-Regular.ttf");

        return convertView;
    }
}
