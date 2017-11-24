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
import java.util.Vector;

import entre2.house_home.kostanku.models.Kos;

/**
 * Created by Adrian Lukito Lo on 20/10/2017.
 */

public class KostListViewAdapter extends BaseAdapter{

    ArrayList<String> kostNames;
    ArrayList<String> kostAddresses;
    ArrayList<String> kostGenderTypes;
    ArrayList<String> kostPrices;
    ArrayList<Drawable> kostImages;

    Vector<Kos>listKos;
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
        this.listKos = new Vector<>();
    }

    public void addKostList(Kos kos, Drawable kostImage){
        kostImages.add(kostImage);
        listKos.add(kos);
    }

    @Override
    public int getCount() {
        return listKos.size();
    }

    @Override
    public Object getItem(int position) {
        return listKos.get(position).getId();
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

        String str = listKos.get(position).getAddress();
        if(str.length() > 28)
            tvKostAddress.setText(str.substring(0,28)+"...");
        else
            tvKostAddress.setText(str);

        tvKostName.setText(listKos.get(position).getName());
        tvKostGenderType.setText(listKos.get(position).getOccupant());
        tvKostPrice.setText("Rp. "+listKos.get(position).getPrice()+"/month");

        if(kostImages.get(position) == null)
            kostImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.no_image_available));
        else{
            kostImageView.setImageDrawable(kostImages.get(position));
        }

        return convertView;
    }

}
