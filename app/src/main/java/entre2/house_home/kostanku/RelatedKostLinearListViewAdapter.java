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
 * Created by Adrian Lukito Lo on 02/11/2017.
 */

public class RelatedKostLinearListViewAdapter extends BaseAdapter {

    ArrayList<String> kostNames;
    ArrayList<String> kostPrices;
    ArrayList<Drawable> kostPictures;

    TextView tvRelatedKostName, tvRelatedKostPrice;

    ImageView relatedKostPicture;

    Context context;

    RelatedKostLinearListViewAdapter(Context context){
        this.context = context;
        kostNames = new ArrayList<>();
        kostPrices = new ArrayList<>();
        kostPictures = new ArrayList<>();
    }

    public void addRelatedKost(String kostName, String kostPrice, Drawable kostPicture){
        kostNames.add(kostName);
        kostPrices.add(kostPrice);
        kostPictures.add(kostPicture);
    }

    @Override
    public int getCount() {
        return kostNames.size();
    }

    @Override
    public Object getItem(int position) {
        return kostNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.related_kost_row,parent,false);
        }

        Typeface quicksand = Typeface.createFromAsset(context.getAssets(), "Quicksand-Regular.ttf");

        tvRelatedKostName = (TextView) convertView.findViewById(R.id.tvRelatedKostName);
        tvRelatedKostPrice = (TextView) convertView.findViewById(R.id.tvRelatedKostPrice);
        relatedKostPicture = (ImageView) convertView.findViewById(R.id.relatedKostPicture);

        tvRelatedKostName.setTypeface(quicksand);
        tvRelatedKostPrice.setTypeface(quicksand);

        tvRelatedKostName.setText(kostNames.get(position));
        tvRelatedKostPrice.setText(kostPrices.get(position));

        if(kostPictures.get(position) == null){
            relatedKostPicture.setImageDrawable(context.getResources().getDrawable(R.drawable.no_image_available));
        }else{
            relatedKostPicture.setImageDrawable(kostPictures.get(position));
        }

        return convertView;
    }
}
