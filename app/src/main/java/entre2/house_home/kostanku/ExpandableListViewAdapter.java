package entre2.house_home.kostanku;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Adrian Lukito Lo on 17/10/2017.
 */

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> headerTitle;
    private HashMap<String, List<String>> childTitle;

    TextView tvCampusListGroup, tvCampusListItem;

    Typeface quicksand;

    public ExpandableListViewAdapter(Context context, List<String> headerTitle , HashMap<String, List<String>> childTitle) {
        this.context = context;
        this.headerTitle = headerTitle;
        this.childTitle = childTitle;
    }

    public void addDataHeader(String dataHeader){
        headerTitle.add(dataHeader);
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
            convertView = inflater.inflate(R.layout.campus_list_group,null);
        }
        quicksand = Typeface.createFromAsset(context.getAssets(), "Quicksand-Regular.ttf");
        tvCampusListGroup = (TextView) convertView.findViewById(R.id.tvCampusListGroup);
        tvCampusListGroup.setText(headerTitle);
        tvCampusListGroup.setTypeface(quicksand);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String)this.getChild(groupPosition, childPosition);

        if(convertView == null){
            //LayoutInflater inflater = LayoutInflater.from(context);
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //convertView = inflater.inflate(R.layout.campus_list_item,parent,false);
            convertView = inflater.inflate(R.layout.campus_list_item,null);
        }
        quicksand = Typeface.createFromAsset(context.getAssets(), "Quicksand-Regular.ttf");
        tvCampusListItem = (TextView) convertView.findViewById(R.id.tvCampusListItem);
        tvCampusListItem.setText(childText);
        tvCampusListItem.setTypeface(quicksand);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
