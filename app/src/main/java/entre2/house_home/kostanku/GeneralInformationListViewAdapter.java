package entre2.house_home.kostanku;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Adrian Lukito Lo on 29/10/2017.
 */

public class GeneralInformationListViewAdapter extends BaseAdapter{

    ArrayList<String> informationNames;
    ArrayList<String> informationValues;

    TextView tvInformationName, tvInformationValue;

    Context context;

    public GeneralInformationListViewAdapter(Context context) {
        informationNames = new ArrayList<>();
        informationValues = new ArrayList<>();
        this.context = context;
    }

    public void addInformation(String informationName, String informationValue){
        informationNames.add(informationName);
        informationValues.add(informationValue);
    }

    @Override
    public int getCount() {
        return informationNames.size();
    }

    @Override
    public Object getItem(int position) {
        return informationNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.general_information_row,parent,false);
        }

        Typeface quicksand = Typeface.createFromAsset(context.getAssets(), "Quicksand-Regular.ttf");

        tvInformationName = (TextView) convertView.findViewById(R.id.tvInformationName);
        tvInformationValue = (TextView) convertView.findViewById(R.id.tvInformationValue);

        tvInformationName.setText(informationNames.get(position));
        tvInformationValue.setText(informationValues.get(position));

        tvInformationName.setTypeface(quicksand);
        tvInformationValue.setTypeface(quicksand);

        return convertView;
    }
}
