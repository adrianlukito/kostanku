package entre2.house_home.kostanku;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KostDetailActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    private List<String> listHeader;
    private HashMap<String, List<String>> listChild;

    TextView kostName, kostAddress, kostGenderType, kostPrice, kostTitleName, tvInformation;

    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    SliderLayout slider;

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
        //kostGenderType = (TextView) findViewById(R.id.kostGenderType);
        kostPrice = (TextView) findViewById(R.id.kostPrice);
        kostTitleName = (TextView) findViewById(R.id.kostTitleName);
        tvInformation = (TextView) findViewById(R.id.tvInformation);

        kostName.setTypeface(quicksand, Typeface.BOLD);
        kostAddress.setTypeface(quicksand);
        //kostGenderType.setTypeface(quicksand);
        kostPrice.setTypeface(quicksand);
        kostTitleName.setTypeface(quicksand, Typeface.BOLD);
        tvInformation.setTypeface(quicksand);

        //INFORMATION
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new GeneralInformationFragment(), "General Information");
        viewPagerAdapter.addFragment(new RoomFacilityFragment(), "Room Facility");
        viewPagerAdapter.addFragment(new BathroomFacilityFragment(), "Bathroom Facility");
        viewPagerAdapter.addFragment(new PublicFacilityFragment(), "Public Facility");
        viewPagerAdapter.addFragment(new SurroundingAreaFragment(), "Surrounding Area");

        viewPager.setAdapter(viewPagerAdapter);
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
}
