package entre2.house_home.kostanku;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import static entre2.house_home.kostanku.R.id.tvCampusListItem;

/**
 * Created by Adrian Lukito Lo on 20/10/2017.
 */

public class KostDetailExpandableListViewAdapter extends BaseExpandableListAdapter{

    private Context context;
    private List<String> headerTitle;
    private HashMap<String, List<String>> childTitle;

    Drawable testIcon;

    GridView kostFacilityGridView;

    Typeface quicksand;

    TextView tvKostDetailListGroup;

    public KostDetailExpandableListViewAdapter(Context context, List<String> headerTitle , HashMap<String, List<String>> childTitle) {
        this.context = context;
        this.headerTitle = headerTitle;
        this.childTitle = childTitle;
    }

    @Override
    public int getGroupCount() {
        return headerTitle.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childTitle.get(headerTitle.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return headerTitle.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childTitle.get(headerTitle.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String)this.getGroup(groupPosition);

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //convertView = inflater.inflate(R.layout.campus_list_group,parent,false);
            convertView = inflater.inflate(R.layout.kost_detail_list_group,null);
        }
        quicksand = Typeface.createFromAsset(context.getAssets(), "Quicksand-Regular.ttf");
        tvKostDetailListGroup = (TextView) convertView.findViewById(R.id.tvKostDetailListGroup);
        tvKostDetailListGroup.setText(headerTitle);
        tvKostDetailListGroup.setTypeface(quicksand);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Log.d("asd","MASUK");
        final String childText = (String)this.getChild(groupPosition, childPosition);

        if(convertView == null){
            //LayoutInflater inflater = LayoutInflater.from(context);
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //convertView = inflater.inflate(R.layout.campus_list_item,parent,false);
            convertView = inflater.inflate(R.layout.kost_detail_list_item,null);
        }
        quicksand = Typeface.createFromAsset(context.getAssets(), "Quicksand-Regular.ttf");

        testIcon = context.getResources().getDrawable(R.drawable.ic_lock);

        kostFacilityGridView = (GridView) convertView.findViewById(R.id.kostFacilityGridView);

        KostDetailGridViewAdapter kostDetailGridViewAdapter = new KostDetailGridViewAdapter(context);

        kostDetailGridViewAdapter.addKostDetail(childText, testIcon);

        kostFacilityGridView.setAdapter(kostDetailGridViewAdapter);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
