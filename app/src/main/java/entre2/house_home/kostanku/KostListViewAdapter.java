package entre2.house_home.kostanku;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Adrian Lukito Lo on 20/10/2017.
 */

public class KostListViewAdapter extends BaseAdapter{

    ArrayList<String> kostNames;
    ArrayList<String> kostAddresses;
    ArrayList<String> kostGenderTypes;
    ArrayList<Integer> kostPrices;
    ArrayList<Drawable> kostImages;

    Context context;

    TextView tvKostName, tvKostAddress, tvKostGenderType, tvKostPrice;

    ImageView kostImageView;

    public KostListViewAdapter(Context context) {
        this.kostNames = new ArrayList<>();
        this.kostAddresses = new ArrayList<>();
        this.kostGenderTypes = new ArrayList<>();
        this.kostPrices = new ArrayList<>();
        this.kostImages = new ArrayList<>();
        this.context = context;
    }

    public void addKostList(String kostName, String kostAddress, String kostGenderType, int kostPrice, Drawable kostImage){
        kostNames.add(kostName);
        kostAddresses.add(kostAddress);
        kostGenderTypes.add(kostGenderType);
        kostPrices.add(kostPrice);
        kostImages.add(kostImage);
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
            convertView = inflater.inflate(R.layout.kost_list_view_row,parent,false);
        }

        Typeface quicksand = Typeface.createFromAsset(context.getAssets(), "Quicksand-Regular.ttf");

        tvKostName = (TextView) convertView.findViewById(R.id.tvKostName);
        tvKostAddress = (TextView) convertView.findViewById(R.id.tvKostAddress);
        tvKostGenderType = (TextView) convertView.findViewById(R.id.tvKostGenderType);
        tvKostPrice = (TextView) convertView.findViewById(R.id.tvKostPrice);
        kostImageView = (ImageView) convertView.findViewById(R.id.kostImageView);

        tvKostName.setTypeface(quicksand, Typeface.BOLD);
        tvKostGenderType.setTypeface(quicksand);
        tvKostAddress.setTypeface(quicksand);
        tvKostPrice.setTypeface(quicksand);

        String str = kostAddresses.get(position);
        if(str.length() > 28)
            tvKostAddress.setText(str.substring(0,28)+"...");
        else
            tvKostAddress.setText(str);

        tvKostName.setText(kostNames.get(position));
        tvKostGenderType.setText(kostGenderTypes.get(position));
        tvKostPrice.setText("Rp. "+kostPrices.get(position));

        if(kostImages.get(position) == null)
            kostImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.no_image_available));
        else{
            kostImageView.setImageDrawable(kostImages.get(position));
//            try {
//                Glide
//                        .with(context)
//                        .load(kostImages.get(position))
//                        .override(100,100)
//                        .centerCrop()
//                        .crossFade()
//                        .into(kostImageView);
//            }catch (OutOfMemoryError e){
//                Log.d("lolo","asd "+e);
//            }
        }

        return convertView;
    }
}
