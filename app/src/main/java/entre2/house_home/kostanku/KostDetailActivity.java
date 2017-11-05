package entre2.house_home.kostanku;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.linearlistview.LinearListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KostDetailActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, View.OnClickListener{

    private List<String> listHeader;
    private HashMap<String, List<String>> listChild;

    TextView kostName, kostAddress, kostPrice, kostTitleName, tvInformation, tvFacilityTitle, tvReview, tvRelatedKost;

    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    ImageButton btnPrevFacility, btnNextFacility;

    Button btnReview;

    SliderLayout slider;

    LinearListView linearListView;
    RelatedKostLinearListViewAdapter linearListViewAdapter;

    Drawable sample1, sample2;

    //TEST TANPA FRAGMENT
    ListView listView;
    GeneralInformationListViewAdapter listViewAdapter;
    //TEST TANPA FRAGMENT

    int currentPosition = 0;
    int[] imageInteger = {R.drawable.sample_1,R.drawable.sample_2,R.drawable.sample_3,R.drawable.sample_4};
    String[] imageName = {"Sample 1","Sample 2","Sample 3","Sample 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kost_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Typeface quicksand = Typeface.createFromAsset(getAssets(), "Quicksand-Regular.ttf");

        slider = (SliderLayout) findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();

        for(int i = 0 ; i < imageInteger.length ; i++){
            file_maps.put(imageName[i],imageInteger[i]);
        }

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);

            textSliderView
                    //.description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("name",name);
            textSliderView.getBundle().putString("imageInteger",name);

            slider.addSlider(textSliderView);
        }
        slider.setPresetTransformer(SliderLayout.Transformer.ZoomOut);
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        slider.setCustomAnimation(new DescriptionAnimation());
        slider.setDuration(4000);
        slider.addOnPageChangeListener(this);

        kostName = (TextView) findViewById(R.id.kostName);
        kostAddress = (TextView) findViewById(R.id.kostAddress);
        kostPrice = (TextView) findViewById(R.id.kostPrice);
        kostTitleName = (TextView) findViewById(R.id.kostTitleName);
        tvInformation = (TextView) findViewById(R.id.tvInformation);
        tvFacilityTitle = (TextView) findViewById(R.id.tvFacilityTitle);
        btnPrevFacility = (ImageButton) findViewById(R.id.btnPrevFacility);
        btnNextFacility = (ImageButton) findViewById(R.id.btnNextFacility);
        tvReview = (TextView) findViewById(R.id.tvReview);
        btnReview = (Button) findViewById(R.id.btnReview);
        tvRelatedKost = (TextView) findViewById(R.id.tvRelatedKost);

        kostName.setTypeface(quicksand, Typeface.BOLD);
        kostAddress.setTypeface(quicksand);
        kostPrice.setTypeface(quicksand);
        kostTitleName.setTypeface(quicksand, Typeface.BOLD);
        tvInformation.setTypeface(quicksand);
        tvFacilityTitle.setTypeface(quicksand);
        tvReview.setTypeface(quicksand);
        btnReview.setTypeface(quicksand);
        tvRelatedKost.setTypeface(quicksand);

        btnPrevFacility.setOnClickListener(this);
        btnNextFacility.setOnClickListener(this);

        //INFORMATION
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //viewPagerAdapter.addFragment(new GeneralInformationFragment(), "General Information");
        viewPagerAdapter.addFragment(new RoomFacilityFragment(), "Room Facility");
        viewPagerAdapter.addFragment(new BathroomFacilityFragment(), "Bathroom Facility");
        viewPagerAdapter.addFragment(new PublicFacilityFragment(), "Public Facility");
        viewPagerAdapter.addFragment(new SurroundingAreaFragment(), "Surrounding Area");

        viewPager.setAdapter(viewPagerAdapter);

        buttonController(viewPager);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tvFacilityTitle.setText(viewPagerAdapter.getPageTitle(viewPager.getCurrentItem()));
                buttonController(viewPager);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tvFacilityTitle.setText(viewPagerAdapter.getPageTitle(viewPager.getCurrentItem()));

        listView = (ListView) findViewById(R.id.listView);

        listViewAdapter = new GeneralInformationListViewAdapter(this);

        listViewAdapter.addInformation("Phone Number","0812345567");
        listViewAdapter.addInformation("Room Size","12m");
        listViewAdapter.addInformation("Occupant","Man and Woman");
        listViewAdapter.addInformation("Deposit","Rp. 1.000.000");
        listViewAdapter.addInformation("Phone Number","0812345567");
        listViewAdapter.addInformation("Room Size","12m");
        listViewAdapter.addInformation("Occupant","Man and Woman");
        listViewAdapter.addInformation("Deposit","Rp. 1.000.000");

        listView.setAdapter(listViewAdapter);

        sample1 = getResources().getDrawable(R.drawable.sample_1);
        sample2 = getResources().getDrawable(R.drawable.sample_2);

        linearListView = (LinearListView) findViewById(R.id.linearListView);

        linearListViewAdapter = new RelatedKostLinearListViewAdapter(this);

        linearListViewAdapter.addRelatedKost("Kost Loving Hut","Rp. 1.500.000",sample1);
        linearListViewAdapter.addRelatedKost("Kost Orange","Rp. 1.300.000",sample2);
        linearListViewAdapter.addRelatedKost("Kost Anggur","Rp. 1.800.000",sample1);
        linearListViewAdapter.addRelatedKost("Kost Mandala","Rp. 1.400.000",sample2);
        linearListViewAdapter.addRelatedKost("Kost Brownis","Rp. 1.000.000",sample1);
        linearListViewAdapter.addRelatedKost("Kost U9A","Rp. 1.900.000",sample1);
        linearListViewAdapter.addRelatedKost("Kost Icon","Rp. 2.800.000",sample1);
        linearListViewAdapter.addRelatedKost("Kost 10Z","Rp. 1.700.000",sample1);
        linearListViewAdapter.addRelatedKost("Kost U85A","Rp. 1.200.000",sample1);
        linearListViewAdapter.addRelatedKost("Kost Helena","Rp. 1.900.000",sample1);

        linearListView.setAdapter(linearListViewAdapter);
    }

    public void initData(){
        listHeader = new ArrayList<>();
        listChild = new HashMap<String, List<String>>();

        listHeader.add("Room Facility");
        listHeader.add("Bathroom Facility");
        listHeader.add("Public Facility");
        listHeader.add("Surrounding");

        List<String> listRoomFacility = new ArrayList<>();
        listRoomFacility.add("Bed");
        listRoomFacility.add("TV");
        listRoomFacility.add("Wifi");
        listRoomFacility.add("Wardrobe");
        listRoomFacility.add("AC");

        List<String> listBatchroomFacility = new ArrayList<>();
        listBatchroomFacility.add("Shower");
        listBatchroomFacility.add("Water Heater");
        listBatchroomFacility.add("Toilet Seat");

        List<String> listPublicFacility = new ArrayList<>();
        listPublicFacility.add("Kitchen");
        listPublicFacility.add("Laundry");
        listPublicFacility.add("Parking");
        listPublicFacility.add("Refrigerator");

        List<String> listSurrounding = new ArrayList<>();
        listSurrounding.add("ATM");
        listSurrounding.add("Mini Market");
        listSurrounding.add("Campus / School");
        listSurrounding.add("Mall");

        listChild.put(listHeader.get(0),listRoomFacility);
        listChild.put(listHeader.get(1),listBatchroomFacility);
        listChild.put(listHeader.get(2),listPublicFacility);
        listChild.put(listHeader.get(3),listSurrounding);
    }

    public void buttonController(ViewPager viewPager){
        if(viewPager.getCurrentItem() == 0){
            btnPrevFacility.setVisibility(View.INVISIBLE);
        }else if(viewPager.getCurrentItem() == viewPagerAdapter.getCount()-1){
            btnNextFacility.setVisibility(View.INVISIBLE);
        }else{
            btnPrevFacility.setVisibility(View.VISIBLE);
            btnNextFacility.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        slider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        //Toast.makeText(this,slider.getBundle().get("name") + "",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), FullScreenImageSliderActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //Toast.makeText(this, "Page Change : "+position, Toast.LENGTH_SHORT).show();
        currentPosition = slider.getCurrentPosition();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        if(v == btnNextFacility){
            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            tvFacilityTitle.setText(viewPagerAdapter.getPageTitle(viewPager.getCurrentItem()));
            buttonController(viewPager);
        }else if(v == btnPrevFacility){
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
            tvFacilityTitle.setText(viewPagerAdapter.getPageTitle(viewPager.getCurrentItem()));
            buttonController(viewPager);
        }
    }
}
